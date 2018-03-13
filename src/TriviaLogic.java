/**
 * Beskrivning: Hanterar logiken kring frågesporten
 * @author Katarina Lejonlid, katasl-3
 */


import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriviaLogic {

    //Skapar ett nytt QuestionBank
    static QuestionBank questionBank = new QuestionBank();
    static ScoreBoard scoreBoard = new ScoreBoard();
    final static int NR_OF_CORRECT = 2;

    //Hämtar frågorna från QuestionBank
    ArrayList<Question> questions = questionBank.getQuestions();
    ArrayList<Player> players = new ArrayList<>();

    /**
     * Beskrivning:
     * @param player1
     *@param player2
     * @return
     */
    public void playTrivia(String player1, String player2){
        //Vad händer om kravet av antalet korrekta svar är flera än frågor?
        String nextPlayer = player1;
        int correctPl1 = 0;
        int correctPl2 = 0;

        do {
            for (Question question : questions) {
                if(nextPlayer.equals(player1)){
                    nextPlayer = player2;
                }
                else nextPlayer = player1;

                String yourAnswer = JOptionPane.showInputDialog(nextPlayer + ": \n" + question.getQuestion());
                if(question.getAnswer().equals(yourAnswer)){
                    if(nextPlayer.equals(player1)){
                        correctPl1++;
                    }
                    else correctPl2++;
                }
            }
        } while (correctPl1 != NR_OF_CORRECT && correctPl2 != NR_OF_CORRECT);

        String winnerPlayer = "";

        if(correctPl1==NR_OF_CORRECT){
            winnerPlayer = player1;
        }
        else winnerPlayer = player2;

        String winnerIs = "Vinnaren är " + winnerPlayer + "!\n";
        scoreBoard.addResult(winnerIs);
        JOptionPane.showMessageDialog(null, scoreBoard.printResults() );

    }

    /**
     * Beskrivning: Lägger till fråga
     * @param name
     *@param question
     * @param answer
     * @return
     */
    public void addQuestion(String name, String question, String answer) {
        questionBank.addQuestion(name, question, answer);
    }
    /**
     * Beskrivning:
     * @param name
     * @return boolean för om det lyckades eller ej
     */
    public boolean removeQuestion(String name) {
        boolean found = questionBank.removeQuestion(name);
        return found;
    }

    //File I/O methods
    /**gunpw
     * Beskrivning:
     * @return readQuestions
     */
    public List<Question> readQuestions() throws IOException, ClassNotFoundException {
        return questionBank.readQuestions();
    }
    /**
     * Beskrivning:Spara frågorna vid stängning
     * @return void
     */
    public void saveQuestions() throws IOException {
        questionBank.saveQuestions();
    }

    /**
     * Beskrivning: Rensa filen och skriva över med den nya läsningen
     * @param readQuestions
     * @return void
     */
    public void clearReplace(List<Question> readQuestions) {
        questionBank.clearReplace(readQuestions);
    }

    public String printQuestions() {
        String info = "";

        for (Question question : questions) {
            info = info + question.getName() + ", " + question.getQuestion() + "\n";
        }

        return info;
    }
}
