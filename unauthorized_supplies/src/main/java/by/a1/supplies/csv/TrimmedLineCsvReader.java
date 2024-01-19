package by.a1.supplies.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.processor.RowProcessor;
import com.opencsv.stream.reader.LineReader;
import com.opencsv.validators.LineValidatorAggregator;
import com.opencsv.validators.RowValidatorAggregator;
import org.apache.commons.lang3.ObjectUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;

public class TrimmedLineCsvReader extends CSVReader {
    /**
     * Constructs CSVReader using defaults for all parameters.
     *
     * @param reader The reader to an underlying CSV source.
     */
    public TrimmedLineCsvReader(Reader reader) {
        super(reader);
    }

    @Override
    public String[] readNext() throws IOException, CsvValidationException {
        String[] result = super.readNext();
        if (result == null)
            return null;

        for (int index = 0; index < result.length; index++) {
            result[index] = result[index].trim();
        }
        return result;
    }

    public void setParser(ICSVParser parser) {
        this.parser = parser;
    }
}
