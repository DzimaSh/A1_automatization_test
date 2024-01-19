package by.a1.supplies.service;

import by.a1.supplies.csv.TrimmedLineCsvReader;
import by.a1.supplies.entity.Login;
import by.a1.supplies.entity.Posting;
import by.a1.supplies.repository.LoginRepository;
import by.a1.supplies.repository.PostingRepository;
import by.a1.supplies.util.Constants;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsvService {
    private final LoginRepository loginRepository;
    private final PostingRepository postingRepository;
    private final ResourceLoader resourceLoader;
    private final Constants constants;

    @PostConstruct
    public void readCsvFiles() {
        log.info("Starting to read CSV files");
        try {
            readLogins();
            readPostings();
        } catch (IOException e) {
            log.error("Error reading CSV files", e);
        } finally {
            log.info("Finished reading CSV files");
        }
    }

    private void readLogins() throws IOException {
        log.debug("Reading logins");

        Resource loginsResource = resourceLoader.getResource(constants.getDataLocation() + "logins.csv");
        try (Reader reader = new InputStreamReader(loginsResource.getInputStream())) {
            CSVReader csvReader = new TrimmedLineCsvReader(reader);

            CsvToBean<Login> csvToBean = new CsvToBeanBuilder<Login>(csvReader)
                    .withType(Login.class)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Login> logins = csvToBean.parse();

            loginRepository.saveAll(
                    filterExistingLogins(logins)
            );
        }
    }

    private List<Login> filterExistingLogins(List<Login> logins) {
        Set<String> existingUsernames = getUniqueUsernames(loginRepository.findAll());
        return logins.stream()
                .filter(login -> !existingUsernames.contains(login.getAppAccountName()))
                .toList();
    }

    private void readPostings() throws IOException {
        log.debug("Reading postings");

        Resource postingsResource = resourceLoader.getResource(constants.getDataLocation() + "postings.csv");
        try (Reader reader = new InputStreamReader(postingsResource.getInputStream())) {
            TrimmedLineCsvReader csvReader = new TrimmedLineCsvReader(reader);

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .build();
            csvReader.setParser(parser);

            CsvToBean<Posting> csvToBean = new CsvToBeanBuilder<Posting>(csvReader)
                    .withType(Posting.class)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Posting> postings = csvToBean.parse();

            markAuthorized(postings, getUniqueUsernames(loginRepository.findAll()));

            postingRepository.saveAll(
                    filterExistingPostings(postings)
            );
        }
    }

    private List<Posting> filterExistingPostings(List<Posting> postings) {
        Set<String> existingMatDocs = getUniqueMatDocs(postingRepository.findAll());
        return postings.stream()
                .filter(posting -> {
                    if (existingMatDocs.contains(posting.getMatDoc())) {
                        List<Integer> persistingPostingItemInMatDoc = postingRepository
                                .findAllByMatDoc(posting.getMatDoc())
                                .stream()
                                .map(Posting::getItem)
                                .toList();

                        return !persistingPostingItemInMatDoc.contains(posting.getItem());
                    }
                    return true;
                }).toList();
    }

    private Set<String> getUniqueUsernames(Iterable<Login> logins) {
        Set<String> uniqueUsernames = new HashSet<>();
        for (Login login : logins) {
            uniqueUsernames.add(login.getAppAccountName());
        }
        return uniqueUsernames;
    }

    private Set<String> getUniqueMatDocs(Iterable<Posting> postings) {
        Set<String> uniqueMatDocs = new HashSet<>();
        for (Posting posting : postings) {
            uniqueMatDocs.add(posting.getMatDoc());
        }
        return uniqueMatDocs;
    }


    private void markAuthorized(List<Posting> postings, Set<String> uniqueUsernames) {
        for (Posting posting : postings) {
            if (uniqueUsernames.contains(posting.getUserName())) {
                posting.setAuthorized(true);
                posting.setUser(
                        loginRepository
                                .findByAppAccountName(posting.getUserName())
                                .orElse(null)
                );
            } else {
                posting.setAuthorized(false);
            }
        }

        log.debug("Marked postings as authorized: {}", postings);
    }
}
