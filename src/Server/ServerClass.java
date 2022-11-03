package Server;

import Resources.AllQuestions;
import Resources.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;


public class ServerClass extends ServerResource {

    private static final GsonBuilder builder = new GsonBuilder();
    private static final Gson gson = builder.create();
    private static int count = 0;
    private static ArrayList<Question> allQuestionsAnswers = null;

    public static void ServerStart() throws Exception {
        builder.setPrettyPrinting();
        AllQuestions allQuestions = new AllQuestions();
        allQuestionsAnswers = allQuestions.getAllQuestionsAnswers();
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, ServerClass.class).start();
    }

    @Get
    public String toString() {
        count++;
        count = count % allQuestionsAnswers.size();
        Question questionAnswer = allQuestionsAnswers.get(count);
        return gson.toJson(questionAnswer);
    }

}