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
        connectToH2();
        System.out.println("Connected to the database...");

        stmt = conn.createStatement();
        String sql = "SELECT id, question, answer FROM Questions";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            // Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }

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
        return json_string;
    }
}