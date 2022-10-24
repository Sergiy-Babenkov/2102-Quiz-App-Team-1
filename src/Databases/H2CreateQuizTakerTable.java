package Databases;

import static Databases.H2Commands.*;

public class H2CreateQuizTakerTable {
    public static void main(String[] args) {
        try {
            connectToH2();
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   quiz_takers " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " first varchar(255), " +
                    " last varchar(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            // STEP 4: Clean-up environment
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println("Goodbye!");
    }
}