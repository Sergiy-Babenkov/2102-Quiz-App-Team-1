package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2Commands {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test"; //

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static Connection conn = null;
    public static Statement stmt = null;

    public static void connectToH2() {
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.err.println("Error! in connectTo H2()");
        }
    }

    public static void disconnectFromH2() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Error! in disconnectFrom H2()");
        }
    }

}
