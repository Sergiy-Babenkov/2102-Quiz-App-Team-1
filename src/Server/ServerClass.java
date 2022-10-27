package Server;

import Resources.Questions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.ResultSet;

import static Databases.H2Commands.*;

public class ServerClass extends ServerResource {
    private static String json_string;


    public static void main(String[] args) throws Exception {
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, ServerClass.class).start();

        connectToH2();
        System.out.println("Connected to the database...");

        stmt = conn.createStatement();
        String sql = "SELECT * FROM Questions ORDER BY RAND() Limit 1";
        ResultSet rs = stmt.executeQuery(sql);

        String question = null;
        String answer = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            question = rs.getString("question");
            answer = rs.getString("answer");

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            Questions one_q = new Questions(question, answer);

            json_string = gson.toJson(one_q);
        }
        System.out.println(json_string);
        disconnectFromH2();
        System.out.println("Disconnected from the database...");
    }
    @Get
    public String toString() {
        return json_string;
    }
}