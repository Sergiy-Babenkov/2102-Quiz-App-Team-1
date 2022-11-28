import static Server.AllQuestionsServer.StartAllQuestionsServer;
import static Server.BookmarkedQuestionsServer.StartBookmarkedQuestionsServer;

public class Main {
    public static void main(String[] args) throws Exception {
        StartAllQuestionsServer();
        StartBookmarkedQuestionsServer();
    }
}