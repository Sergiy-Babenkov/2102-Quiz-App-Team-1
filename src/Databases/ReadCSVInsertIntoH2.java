package Databases;

import Data.constants;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

import static Databases.H2Commands.*;

public class ReadCSVInsertIntoH2 {
    // Data file
    private final static String file = constants.CsvFileLocation;

    private static void insertIntoH2(int id, String question, String answer) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO  questions " +
                    "(question,answer) " +
                    "VALUES ('" +
                    question +
                    "','" +
                    answer +
                    "'" +
                    "); ";
            System.out.println("SQL: " + sql);

            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error! in insertIntoH2");
        }
    }

    public static void main(String[] args) {
        try {

            connectToH2();
            System.out.println(file);
            Reader in = new FileReader(file);

            int id = 0;

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String question = record.get("Question");
                String answer = record.get("Answer");
                System.out.println("Question: " + question + "\n Answer: " + answer);
                insertIntoH2(id, question, answer);
                id += 1;
            }

            in.close();
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}