package Server;

import Resources.Questions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Databases.H2Commands.*;

public class FirstServerResource extends ServerResource {
    private static String json_string;

    public static void main(String[] args) throws Exception {
        try {
            connectToH2();
            System.out.println("Connected database successfully...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM QUESTIONS";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Retrieve by column name
                String Questions = rs.getString("Question");
                String Answers = rs.getString("Answer");

                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();
                Gson gson = builder.create();

                Questions one_q = new Questions(Questions, Answers);

                json_string = gson.toJson(one_q);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Create the HTTP server and listen on port 8182
        new Server(Protocol.HTTP, 8182, FirstServerResource.class).start();
    }

    @Get
    public String toString() {
        return json_string;
    }
}