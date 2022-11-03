package UnitTests;

import org.testng.annotations.Test;

import java.sql.ResultSet;

import static Databases.H2Commands.*;
import static org.testng.Assert.assertEquals;

public class TestQuestionTable {
    @Test
    public void Test1() {
        try {
            connectToH2();

            stmt = conn.createStatement();

            String sql = "SELECT * FROM questions WHERE answer='Arizona';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String questionStr = rs.getString("question");
                assertEquals(questionStr, "The city of Yuma in this state has a record average of 4,055 hours of sunshine each year");
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

            String sql = "SELECT * FROM questions WHERE answer='Michael Jordan';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String questionStr = rs.getString("question");
                assertEquals(questionStr, "No. 8: 30 steals for the Birmingham Barons; 2,306 steals for the Bulls");
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

            String sql = "SELECT * FROM questions WHERE answer='a chart';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String questionStr = rs.getString("question");
                assertEquals(questionStr, "A graphic representation of information");
            }
            disconnectFromH2();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}