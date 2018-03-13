/**
 * Beskrivning:
 * @author Katarina Lejonlid, katasl-3
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private ArrayList<Question> questions = new ArrayList<>();

    //Getter för listan av frågor
    public ArrayList<Question> getQuestions() { return questions; }

    /**
     * Beskrivning: Leta fram en fråga i arrayen
     * @param name
     * @return question
     */
    public Question findQuestion(String name){
        for (Question question : questions) {
            if(question.getName().equals(name)){
                return question;
            }
        }
        return null;
    }

    /**
     * Beskrivning: Lägger till fråga
     * @param question sträng fråga
     * @param answer  sträng svar
     * @return void
     */
    public void addQuestion(String name, String question, String answer){
        questions.add(new Question(name, question, answer));
    }

    /**
     * Beskrivning: Ta bort fråga
     * @param name
     * @return boolean för om den kunde tas bort eller ej
     */
    public boolean removeQuestion(String name){

        boolean found = false;
        Question question = findQuestion(name);
        if(question != null)
        {
            questions.remove(question);
            found = true;
        }
        return found;
    }

    //TODO Implementera metoden
    /**
     * Beskrivning: Att editera en fråga
     * @param
     * @return
     */
    public void editQuestion(){

    }
    //File I/O methods
    /**
     * Beskrivning: Läsa från fil
     * @param
     * @return lista med frågor
     */
    public List<Question> readQuestions() throws IOException, ClassNotFoundException {
        ObjectInputStream inFile = new ObjectInputStream (new FileInputStream("Katasl3_Files/questions.dat"));
        List<Question> readQuestions = (List<Question>)inFile.readObject();
        inFile.close();
        return readQuestions;
    }

    /**
     * Beskrivning: Rensa och ersätta listan med frågor
     * @param readQuestions
     * @return
     */
    public void clearReplace(List<Question> readQuestions) {

        questions.clear();
        questions.addAll(readQuestions);
    }
    /**
     * Beskrivning: Spara frågorna
     * @param
     * @return void
     */
    public void saveQuestions() throws IOException {
        ObjectOutputStream outFile = new ObjectOutputStream (new FileOutputStream("Katasl3_Files/questions.dat"));
        outFile.writeObject(questions);
        outFile.close();
    }
}
