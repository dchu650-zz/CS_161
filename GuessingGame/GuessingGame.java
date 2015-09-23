import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Stimulates a guessing game. It generates a random number and askes the user to
 * guess it. The user has a fixed number of tries. 
 * 
 * @author Graham Cameron and Darren Chu 
 * @version 9/11/2012
 */
public class GuessingGame
{
    private int theNumber; //the random number that is generated
    private boolean checkGuess;

    /**
     * 
     */
    public GuessingGame()
    {
        Random randGen = new Random(); // make the random number generator
        theNumber = randGen.nextInt(30); //the number to guess

    }

    /**
     * Gets the user's guess.
     * @return the user's guess.
     */
    private int getGuess()
    {
        int theGuess; // the user's guess
        String guessString;
        guessString = JOptionPane.showInputDialog("Enter your guess");
        theGuess = Integer.parseInt(guessString);
        return theGuess;
    }

    /**
     * Checks the user's guess.
     * @param guess the user's guess.
     * @return true - correct guess, false - incoreect guess
     */
    private boolean checkGuess(int guess) 
    {
        if (guess == theNumber)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * 
     */
    private void hotOrCold(int difference)
    {
        if (difference > 0)
        {
            JOptionPane.showMessageDialog(null, "Hot");
        }
        else if (difference < 0)
        {
            JOptionPane.showMessageDialog(null, "Cold");
        }
    }

    /**
     * plays the game.
     */
    public void playGame()
    {
        // basic idea
        // ask for a guess
        int usersGuess = getGuess();
        // if the guess is correct
        if (checkGuess(usersGuess) == true)
        {
            JOptionPane.showMessageDialog(null, "Good job you know numbers");
        }
        else
        {
            hotOrCold(usersGuess-theNumber);
            JOptionPane.showMessageDialog(null, "Guess again, 4 more tries");
            usersGuess = getGuess();
            if (checkGuess(usersGuess) == true)
            {
                JOptionPane.showMessageDialog(null, "Good job you know numbers");
            }
            else 
            {
                hotOrCold(usersGuess-theNumber);
                JOptionPane.showMessageDialog(null, "Guess again 3 more tries");
                usersGuess = getGuess();
                if (checkGuess(usersGuess) == true)
                {
                    JOptionPane.showMessageDialog(null, "Good job you know numbers");
                }
                else 
                {
                    hotOrCold(usersGuess-theNumber);
                    JOptionPane.showMessageDialog(null, "Guess again 2 more tries");
                    usersGuess = getGuess();
                    if (checkGuess(usersGuess) == true)
                    {
                        JOptionPane.showMessageDialog(null, "Good job you know numbers");
                    }
                    else 
                    {
                        hotOrCold(usersGuess-theNumber);
                        JOptionPane.showMessageDialog(null, "Guess again last try");
                        usersGuess = getGuess();
                        if (checkGuess(usersGuess) == true)
                        {
                            JOptionPane.showMessageDialog(null, "Good job you know numbers");
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Game Over");
                        }
                    }
                }
            }
        }

    }
}
