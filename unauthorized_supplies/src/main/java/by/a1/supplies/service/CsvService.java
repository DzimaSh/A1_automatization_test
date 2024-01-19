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
import com.opencsv.CSVReaderBaseBuilder;
import com.opencsv.bean.*;
import com.opencsv.exceptions.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void readCsvFiles() throws IOException {
        Resource loginsResource = resourceLoader.getResource(constants.getDataLocation() + "logins.csv");

        try (Reader reader = new InputStreamReader(loginsResource.getInputStream())) {
            CSVReader csvReader = new TrimmedLineCsvReader(reader);

            CsvToBean<Login> csvToBean = new CsvToBeanBuilder<Login>(csvReader)
                    .withType(Login.class)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Login> logins = csvToBean.parse();

            log.info(logins.toString());
        }

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

            log.info(postings.toString());
        }
    }
}
