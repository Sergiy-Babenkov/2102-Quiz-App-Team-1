package Resources;

/*

Start of Singleton Score file

*/

public class Score {

    private static Score single_instance = null;

    private Score() {
    }

    public static Score getInstance() {
        if (single_instance == null)
            single_instance = new Score();

        return single_instance;
    }

}
