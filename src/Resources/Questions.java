package Resources;

public class Questions {

    private String question;
    private String answer;

    public Questions(String q, String a) {
        question = q;
        answer = a;
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