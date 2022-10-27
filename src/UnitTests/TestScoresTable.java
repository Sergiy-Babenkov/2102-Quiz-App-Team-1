package UnitTests;

import org.testng.annotations.Test;

import java.sql.ResultSet;

import static Databases.H2Commands.*;
import static org.testng.Assert.assertEquals;

public class TestScoresTable {
    @Test
    public void Test() {
        try {
            connectToH2();

            stmt = conn.createStatement();
            String sql = "INSERT INTO  score " +
                    "(usr,questions_total,questions_answered,questions_correct) " +
                    "VALUES ('Sergiy Babenkov', 100, -5, 2); ";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO  score " +
                    "(usr,questions_total,questions_answered,questions_correct) " +
                    "VALUES ('Nadia Brown', 50, 45, 30); ";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO  score " +
                    "(usr,questions_total,questions_answered,questions_correct) " +
                    "VALUES ('Matthew Dunn', 26, 14, 5); ";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            /* */

            // STEP 4 Select the row
            stmt = conn.createStatement();

            sql = "SELECT * FROM score WHERE usr='Sergiy Babenkov';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String questionsTotal = rs.getString("questions_total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 100);

                String questionsAnswered = rs.getString("questions_answered");
                int AnsweredInt = Integer.parseInt(questionsAnswered);
                assertEquals(AnsweredInt, -5);

                String questionsCorrect = rs.getString("questions_correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 2);
            }

            sql = "SELECT * FROM score WHERE usr='Nadia Brown';";
            ResultSet rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                String questionsTotal = rs2.getString("questions_total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 50);

                String questionsAnswered = rs2.getString("questions_answered");
                int AnsweredInt = Integer.parseInt(questionsAnswered);
                assertEquals(AnsweredInt, 45);

                String questionsCorrect = rs2.getString("questions_correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 30);
            }

            sql = "SELECT * FROM score WHERE usr='Matthew Dunn';";
            ResultSet rs3 = stmt.executeQuery(sql);
            while (rs3.next()) {
                String questionsTotal = rs3.getString("questions_total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 26);

                String questionsAnswered = rs3.getString("questions_answered");
                int AnsweredInt = Integer.parseInt(questionsAnswered);
                assertEquals(AnsweredInt, 14);

                String questionsCorrect = rs3.getString("questions_correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 5);
            }

            //STEP 5: Remove the test row
            sql = "DELETE FROM score WHERE usr='Sergiy Babenkov';" + "DELETE FROM score WHERE usr='Nadia Brown';" + "DELETE FROM score WHERE usr='Matthew Dunn';";
            stmt.executeUpdate(sql);

            System.out.println("Deleted the test rows from the table...");

            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}