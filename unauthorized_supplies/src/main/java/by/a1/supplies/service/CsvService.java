package by.a1.supplies.service;

import by.a1.supplies.entity.Login;
import by.a1.supplies.entity.Posting;
import by.a1.supplies.repository.LoginRepository;
import by.a1.supplies.repository.PostingRepository;
import by.a1.supplies.util.Constants;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsvService {
    private final LoginRepository loginRepository;
    private final PostingRepository postingRepository;
    private final Constants constants;

    @PostConstruct
    public void readCsvFiles() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(constants.getDataLocation() + "logins.csv"))) {
            CsvToBean<Login> csvToBean = new CsvToBeanBuilder<Login>(reader)
                    .withType(Login.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Login> logins = csvToBean.parse();

            loginRepository.saveAll(logins);
        }

        try (Reader reader = Files.newBufferedReader(Paths.get("postings.csv"))) {
            CsvToBean<Posting> csvToBean = new CsvToBeanBuilder<Posting>(reader)
                    .withType(Posting.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Posting> postings = csvToBean.parse();

            postingRepository.saveAll(postings);
        }
    }
}
