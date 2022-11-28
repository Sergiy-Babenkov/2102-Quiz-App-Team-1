package Server;

import Resources.AllQuestions;
import Resources.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.io.IOException;
import java.util.ArrayList;

public class BookmarkedQuestionsServer extends ServerResource {
    private static final GsonBuilder builder = new GsonBuilder();
    private static final Gson gson = builder.create();
    private static int count = 0;
    private static ArrayList<Question> allQuestionsAnswers = null;

    public static void StartBookmarkedQuestionsServer() throws Exception {
        builder.setPrettyPrinting();
        AllQuestions allQuestions = new AllQuestions();
        allQuestionsAnswers = allQuestions.getAllQuestionsAnswers();
        // Create the HTTP server and listen on port 8183
        new Server(Protocol.HTTP, 8183, BookmarkedQuestionsServer.class).start();
    }

    /*
     * curl http://localhost:8183
     */
    @Get
    public String toString() {
        count++;
        count = count % allQuestionsAnswers.size();
        Question questionAnswer = allQuestionsAnswers.get(count);
        return gson.toJson(questionAnswer);
    }

    /*
     * curl -v -d "Hello=YEAH" -X  POST "http://localhost:8183" -H "Content-type: text/html; charset=UTF-8"
     */
    @Post
    public Response addScore(Representation r) {
        String s;
        Request request = new Request();
        try {
            s = r.getText();
            System.out.println("s: " + s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Response(request);
    }

    /*
     * curl -v -d "Hello=YEAH" -X  PUT "http://localhost:8183" -H "Content-type: text/html; charset=UTF-8"
     *
     * We can use this PUT to reset the count variable!
     *
     * curl -d "9" -X  PUT "http://localhost:8183" -H "Content-type: text/html; charset=UTF-8"
     */
    @Put
    public Response updateScore(Representation r) {
        String s;

        try {
            s = r.getText();
            System.out.println("s: " + s);
            count = Integer.parseInt(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Request request = new Request();
        return new Response(request);
    }
}