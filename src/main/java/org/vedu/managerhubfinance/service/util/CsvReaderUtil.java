package org.vedu.managerhubfinance.util;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;

public class CsvReaderUtil {

    public static List<List<String>> readCommomCSV(String filePath, String[] columnNames) throws IOException, CsvException {
        List<List<String>> result = new ArrayList<>();
        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(filePath))) {
            Map<String, String> line;
            while ((line = reader.readMap()) != null) {
                List<String> selectedColumns = new ArrayList<>();
                for (String columnName : columnNames) {
                    selectedColumns.add(line.get(columnName));
                }
                result.add(selectedColumns);
            }
        }
        return result;
    }
    
	public static List<List<String>> readCSV(String filePath) throws IOException, CsvException {
	    List<List<String>> records = new ArrayList<>();
	
	    CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
	
	    try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(csvParser).build()) {
	        String[] values;
	        while ((values = csvReader.readNext()) != null) {
	            records.add(Arrays.asList(values));
	        }
	    }
	
	    return records;
	}
	
	public static List<List<String>> readCSV(String filePath, int columnToFilter, String filterValue, int... columnIndices) throws IOException, CsvException {
        List<List<String>> records = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(csvParser).build()) {
            String[] header = csvReader.readNext();
            if (header != null) {
                int filterColumnIndex = columnToFilter;
                String[] values;
                while ((values = csvReader.readNext()) != null) {
                    if (filterColumnIndex >= 0 && filterColumnIndex < values.length &&
                            values[filterColumnIndex].trim().equalsIgnoreCase(filterValue.trim())) {
                        List<String> selectedColumns = new ArrayList<>();
                        for (int columnIndex : columnIndices) {
                            if (columnIndex >= 0 && columnIndex < values.length) {
                                selectedColumns.add(values[columnIndex]);
                            } else {
                                selectedColumns.add("");
                            }
                        }
                        records.add(selectedColumns);
                    }
                }
            } else {
                throw new IllegalArgumentException("CSV file is empty.");
            }
        }

        return records;
    }
	
	public static List<List<String>> readCSV(String filePath, int... columnIndices) throws IOException, CsvException {
        List<List<String>> records = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(csvParser).build()) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> selectedColumns = new ArrayList<>();
                for (int columnIndex : columnIndices) {
                    if (columnIndex >= 0 && columnIndex < values.length) {
                        selectedColumns.add(values[columnIndex]);
                    } else {
                        selectedColumns.add("");
                    }
                }
                records.add(selectedColumns);
            }
        }

        return records;
    }

}
