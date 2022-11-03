package Resources;

public class Scores {

    private static Scores single_instance = null;

    private Scores() {
    }

    public static Scores getInstance() {
        if (single_instance == null)
            single_instance = new Scores();

        return single_instance;
    }

}
