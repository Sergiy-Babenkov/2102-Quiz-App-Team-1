package Resources;

import java.sql.ResultSet;
import java.util.ArrayList;

import static Databases.H2Commands.*;

public class AllQuestions {
    ArrayList<Question> questionArrayList = new ArrayList<Question>();

    public ArrayList<Question> getAllQuestionsAnswers() {
        connectToH2();
        try {
            String sql = "SELECT * FROM Questions ORDER BY RAND() Limit 10";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String actualQuestion = rs.getString("question");
                String actualAnswer = rs.getString("answer");
                Question question = new Question(id, actualQuestion, actualAnswer);
                questionArrayList.add(question);
            }
            disconnectFromH2();
        } catch (Exception e) {
            System.err.println("Error! in connectTo H2()");
        }
        return questionArrayList;
    }
}
