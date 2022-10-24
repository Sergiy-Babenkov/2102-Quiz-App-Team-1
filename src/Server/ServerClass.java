package Server;

import Resources.Questions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
public class ServerClass extends ServerResource {
    private static String json_string;

    public static void main(String[] args) throws Exception {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Questions one_q = new Questions("How many members of the US Congress?", "435");

        json_string = gson.toJson(one_q);

        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, ServerClass.class).start();
    }

    @Get
    public String toString() {
        return  json_string;
    }
}