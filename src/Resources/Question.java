package Resources;

public class Question {

    private final int id;
    private String question;
    private String answer;

    public Question(int id, String q, String a) {
        this.id = id;
        this.question = q;
        this.answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String q) {
        question = q;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String a) {
        answer = a;
    }

    public String toString() {
        return "[]";
    }

}