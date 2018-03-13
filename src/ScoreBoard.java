import java.util.ArrayList;

/**
 * Beskrivning:
 *
 * @author Katarina Lejonlid, katasl-3
 */

public class ScoreBoard {
    private ArrayList<String> results = new ArrayList<>();

    public void addResult(String result){
        results.add(result);

    }

    public String printResults() {
        String printResults = "";
        for (String result : results) {
            printResults = printResults + result;
        }
        return printResults;

    }

    //TODO Read from file

    //TODO Save to file
}
