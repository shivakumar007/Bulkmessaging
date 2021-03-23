package com.example.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
    public static String TYPE = "text/csv";
    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    //static String[] HEADERs = { "MobileNumber", "OrderNumber", "Amount" };

    public static List<String> headerList(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<String> headerList=csvParser.getHeaderNames();
            return  headerList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<HashMap<String,String>> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Merchant> developerTutorialList = new ArrayList<>();
            List<HashMap<String,String>> values=new ArrayList<HashMap<String,String>>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int sizeofheaders=csvParser.getHeaderNames().size();
            List<String> headerList=csvParser.getHeaderNames();
            //System.out.println(csvParser.getHeaderNames());
            for (CSVRecord csvRecord : csvRecords) {

                HashMap<String,String> value=new HashMap<>();
                for(int i=0;i<sizeofheaders;i++){
                    value.put(headerList.get(i),csvRecord.get(i));
                }
                values.add(value);
                //developerTutorialList.add(developerTutorial);
            }
            return values;
            //return developerTutorialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
