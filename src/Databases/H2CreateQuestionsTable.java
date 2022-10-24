package Databases;

import static Databases.H2Commands.*;

public class H2CreateQuestionsTable {
    public static void main(String[] args) {
        try {
            connectToH2();
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE questions " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " question varchar(1024), " +
                    " Answer varchar(1024), " +
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
