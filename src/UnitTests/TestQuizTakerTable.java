package UnitTests;

import org.testng.annotations.Test;

import java.sql.ResultSet;

import static Databases.H2Commands.*;
import static org.testng.Assert.assertEquals;

public class TestQuizTakerTable {

    @Test
    public void Test() {
        try {
            connectToH2();

            stmt = conn.createStatement();
            String sql = "INSERT INTO  quiz_takers " +
                    "(first,last,age) " +
                    "VALUES ('Sergiy','Babenkov', 21); ";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO  quiz_takers " +
                    "(first,last,age) " +
                    "VALUES ('Matthew','Dunn', 21); ";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO  quiz_takers " +
                    "(first,last,age) " +
                    "VALUES ('Nadia','Brown', 20); ";
            stmt.executeUpdate(sql);


            System.out.println("Inserted records into the table...");

            stmt = conn.createStatement();

            sql = "SELECT * FROM quiz_takers WHERE first = 'Sergiy' AND last = 'Babenkov';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ageStr = rs.getString("age");
                int ageInt = Integer.parseInt(ageStr);
                assertEquals(ageInt, 21);
            }

            sql = "SELECT * FROM quiz_takers WHERE first = 'Matthew' AND last = 'Dunn';";
            ResultSet rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                String ageStr = rs2.getString("age");
                int ageInt = Integer.parseInt(ageStr);
                assertEquals(ageInt, 21);
            }

            sql = "SELECT * FROM quiz_takers WHERE first = 'Nadia' AND last = 'Brown';";
            ResultSet rs3 = stmt.executeQuery(sql);
            while (rs3.next()) {
                String ageStr = rs3.getString("age");
                int ageInt = Integer.parseInt(ageStr);
                assertEquals(ageInt, 20);
            }

            //STEP 5: Remove the test row
            sql = "DELETE FROM quiz_takers WHERE first = 'Sergiy' AND last = 'Babenkov';"
                    + "DELETE FROM quiz_takers WHERE first = 'Matthew' AND last = 'Dunn';"
                    + "DELETE FROM quiz_takers WHERE first = 'Nadia' AND last = 'Brown';";

            stmt.executeUpdate(sql);

            System.out.println("Deleted the test rows from the table...");
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}