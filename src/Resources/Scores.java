package Resources;

import static Databases.H2Commands.*;


public class Scores {
    private static Scores INSTANCE = null;
    private int correct = 0;
    private int incorrect = 0;
    private int total = 0;

    private Scores() {
    }

    private static void insertIntoH2(int id, int total, int correct, int wrong) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO  scores " +
                    "(total, correct, wrong) " +
                    "VALUES (" +
                    total +
                    "," +
                    correct +
                    "," +
                    wrong +
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
            int id = 0;
            int total = 90;
            int correct = 10;
            int incorrect = 8;
            insertIntoH2(id, total, correct, incorrect);
            id += 1;
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public Scores getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Scores();
        }
        return INSTANCE;
    }

    public int getCorrect() {
        return this.correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return this.incorrect;
    }

    public void setIncorrect(int inCorrect) {
        this.incorrect = inCorrect;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
