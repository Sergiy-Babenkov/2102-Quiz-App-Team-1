package UnitTests;

import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.Assert.assertEquals;

public class TestQuestionsTable {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";


    @Test
    public void test() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            /* */
            //STEP 3: Insert a test row in the score table

            stmt = conn.createStatement();
            String sql = "INSERT INTO questions " +
                    "(question,a,b,c,d,e,answer,explanation) " +
                    "VALUES ('What is the largest Desert?', 'Gobi', 'Sahara', 'Kalahari', 'Patagonian', 'Great Sandy', 'Sahara', 'The Sahara is a desert on the African continent. With an area of 9,200,000 square kilometres.' ); ";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            /* */

            // STEP 4 Select the row
            stmt = conn.createStatement();

            sql = "SELECT * FROM questions WHERE answer='Sahara';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String aStr = rs.getString("a");
                assertEquals(aStr, "Gobi");
                String bStr = rs.getString("b");
                assertEquals(bStr, "Sahara");
                String cStr = rs.getString("c");
                assertEquals(cStr, "Kalahari");
                String dStr = rs.getString("d");
                assertEquals(dStr, "Patagonian");
                String eStr = rs.getString("e");
                assertEquals(eStr, "Great Sandy");
                String questionStr = rs.getString("question");
                assertEquals(questionStr, "What is the largest Desert?");
            }

            //STEP 5: Remove the test row
            sql = "DELETE FROM questions WHERE answer='Sahara';";
            stmt.executeUpdate(sql);

            System.out.println("Deleted the test rows from the table...");

            //Clean Up Environment

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
    }

}