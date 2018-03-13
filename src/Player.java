import java.util.ArrayList;

/**
 * Beskrivning:
 * @author Katarina Lejonlid, katasl-3
 */

public class Player {
    private String name= "";
    private ArrayList<Integer> scores;


    //Konstruktor
    public Player(String name) {
        this.name = name;
    }

    //Getters och setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
