import java.io.Serializable;

/**
 * Beskrivning:
 * @author Katarina Lejonlid, katasl-3
 */

public class Question implements Serializable {

    //Instansvariabler
    private String name = "";
    private String question = "";
    private String answer = "";

    public Question(String name, String question, String answer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    //Getters och setters
    public String getName() { return name; }
    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() {  return answer; }

    public void setAnswer(String answer) {  this.answer = answer;  }
}
