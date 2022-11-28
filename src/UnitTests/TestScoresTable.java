package UnitTests;

import org.testng.annotations.Test;

import java.sql.ResultSet;

import static Databases.H2Commands.*;
import static org.testng.Assert.assertEquals;

public class TestScoresTable {
    @Test
    public void Test1() {
        try {
            connectToH2();
            stmt = conn.createStatement();
            String sql = "INSERT INTO  scores " +
                    "(id,total,wrong,correct) " +
                    "VALUES (1, 100, 32, 68); ";
            stmt.executeUpdate(sql);

            stmt = conn.createStatement();
            sql = "SELECT * FROM scores WHERE id=1;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String questionsTotal = rs.getString("total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 100);

                String questionsWrong = rs.getString("wrong");
                int WrongInt = Integer.parseInt(questionsWrong);
                assertEquals(WrongInt, 32);

                String questionsCorrect = rs.getString("correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 68);
            }
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Test
    public void Test2() {
        try {
            connectToH2();
            stmt = conn.createStatement();
            String sql = "INSERT INTO  scores " +
                    "(id,total,wrong,correct) " +
                    "VALUES (2, 50, 40, 10); ";
            stmt.executeUpdate(sql);

            stmt = conn.createStatement();
            sql = "SELECT * FROM scores WHERE id=2;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String questionsTotal = rs.getString("total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 50);

                String questionsWrong = rs.getString("wrong");
                int WrongInt = Integer.parseInt(questionsWrong);
                assertEquals(WrongInt, 40);

                String questionsCorrect = rs.getString("correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 10);
            }
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Test
    public void Test3() {
        try {
            connectToH2();
            stmt = conn.createStatement();
            String sql = "INSERT INTO  scores " +
                    "(id,total,wrong,correct) " +
                    "VALUES (3, 1000, 999, 1); ";
            stmt.executeUpdate(sql);

            stmt = conn.createStatement();
            sql = "SELECT * FROM scores WHERE id=3;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String questionsTotal = rs.getString("total");
                int TotalInt = Integer.parseInt(questionsTotal);
                assertEquals(TotalInt, 1000);

                String questionsWrong = rs.getString("wrong");
                int WrongInt = Integer.parseInt(questionsWrong);
                assertEquals(WrongInt, 999);

                String questionsCorrect = rs.getString("correct");
                int CorrectInt = Integer.parseInt(questionsCorrect);
                assertEquals(CorrectInt, 1);
            }
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}