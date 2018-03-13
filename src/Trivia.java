import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Beskrivning: Trivia är interfacet mot användaren och är textbaserat
 * @author Katarina Lejonlid, katasl-3
 */

public class Trivia {
    public static void main(String[] args) {
        TriviaLogic logic = new TriviaLogic();
        int choice = 0;

        //TODO Läsa från fil
        // En metod i logic som heter readQuestions() tex och den i sin tur anropar en motsvarande metod i QuestionBank.
        // På motsvarande sätt för att läsa resultaten
        try
        {
            List<Question> readQuestions = logic.readQuestions();
            logic.clearReplace(readQuestions);
        }
        catch(FileNotFoundException f)
        {
            System.out.println("Filen hittades ej. ");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Programmet avslutas");
            System.exit(1);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Klassen hittade ej");
        }

        do {
            String input = JOptionPane.showInputDialog("Du kan \n lägga till fråga(1) editera fråga(2) ta bort fråga(3) " +
                    "\n visa frågor(4) spela quiz (5) eller avsluta(6)");
            try
            {
                choice = Integer.parseInt(input);
                menu(choice, logic);
            }
            catch (NumberFormatException exception)
            {
                JOptionPane.showMessageDialog(null, "Se över ditt val.");
            }
        } while (choice < 6);

        try
        {
            logic.saveQuestions();
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("Frågorna kunde tyvärr inte sparas. ");
        }
    }

    /**
     * Beskrivning:
     * @param choice
     * @param logic
     * @return void
     */
    public static void menu(int choice, TriviaLogic logic){
        switch (choice){
            case 1:
                String name = JOptionPane.showInputDialog("Lägg till etikett :");
                String question = JOptionPane.showInputDialog("Lägg till fråga:");
                String answer = JOptionPane.showInputDialog("Lägg till korrekt svar:");
                logic.addQuestion(name, question, answer);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "TBI");
                break;
            case 3:
                String nameRemove = JOptionPane.showInputDialog("Ange etiketten för den fråga du vill ta bort:");
                if(logic.removeQuestion(nameRemove))
                {
                    JOptionPane.showMessageDialog(null, "Frågan har blivit borttagen\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Frågan med etikett " + nameRemove + " hittades inte.");
                }
                break;
            case 4:
                JOptionPane.showMessageDialog(null, logic.printQuestions());
                break;
            case 5:
                String player1 = JOptionPane.showInputDialog("Spelare 1:");
                String player2 = JOptionPane.showInputDialog("Spelare 2:");
                logic.playTrivia(player1, player2);
                break;

        }

        //Skriver till fil på motsvarande sätt som vid läsning


    }
}
