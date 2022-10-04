package Unit_Tests;

import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.Assert.assertEquals;

class TestScoreTable {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";


    @Test
    void test() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 0: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 0: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            /* */
            //STEP 1: Insert a test row in the score table

            stmt = conn.createStatement();
            String sql = "INSERT INTO  score " +
                    "(usr,questions_total,questions_answered,questions_correct) " +
                    "VALUES ('Alan Turing', 100, -5, 2); ";
            stmt.executeUpdate(sql);
            /* */

            // STEP 2: Select the rest row

            stmt = conn.createStatement();
            sql = "SELECT * FROM score WHERE usr='Alan Turing' ;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String actualString = rs.getString("questions_total");
                int actualInt = Integer.parseInt(actualString);
                assertEquals(actualInt, 100);
            }

            //STEP 3: Remove the test row
            sql = "DELETE FROM score WHERE usr='Alan Turing' ;";
            stmt.executeUpdate(sql);

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