import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Write a description of class HangmanGame here.
 * 
 * @author Darren Chu
 * @version October 18 2012
 */
public class HangmanGame
{
    // instance variables - replace the example below with your own
    private int wordIndex;
    private Random generator;
    private char[] theTarget;
    private char[] currentGuess;
    private char letter;
    private String theWord;
    private ArrayList<Character> previousGuess;
    private ArrayList<String> wordList1;
    private int lives;
    private boolean valid;

    /**
     * Constructor for objects of class HangmanGame
     */
    public HangmanGame()
    {
        generator = new Random();
        wordList1 = new WordList().getWords();
        this.setupGame();
    }

    /**
     * Creates a new HangmanGame object, with the wordlist containing only the given debugWord.
     * @param debugWord The single word in the wordlist, used for testing and debugging.
     */
    public HangmanGame(String debugWord) 
    {
        // put your code here
        generator = new Random();
        wordList1 = new ArrayList<String>();
        wordList1.add(debugWord);
        this.setupGame();
    }

    /**
     * Checks to see if a given letter is present in the target word.
     * @param Letter the letter being guessed.
     * @return Whether or not the letter was found in the word.
     */
    public boolean checkGuess(char letter)
    {
        boolean foundLetter = false;
        for(int i = 0; i<theWord.length(); i++)
        {
            if(theTarget[i]==letter)
            {
                currentGuess[i]=letter;
                foundLetter = true;
            }
            else
            {

            }
        }
        return foundLetter;
    }

    /**
     * Returns a String representation of the current guess state.
     * @return A String displaying the current guess of the word. Has the form "g _ e _ _ ".
     */
    public String currentGuessString()
    {
        String out = "";
        for(int i = 0; i<theWord.length(); i++)
        {
            out = out + currentGuess[i] + " ";
        }
        return out;
    }

    /**
     * Prompts the user to provide a guessed letter.
     * @return A single, lower-case char that the player guessed.
     */
    public char getGuess()
    {
        char theGuess = '_';
        String guessString;
        while(valid == false)
        {
            guessString = JOptionPane.showInputDialog("Enter your guess");

            if(Character.isLetter(theGuess))
            {
                return theGuess;
            }
            else
            {

            }
        }

        return theGuess;
    }

    /**
     * Plays a complete game of Hangman.
     */
    public void playGame()
    {   
        setupGame();
        System.out.println(currentGuessString());
        while(lives != 0)
        {
            char guess = getGuess();
            boolean result = checkGuess(guess);
            
            for(char s: previousGuess)
            {
               if(s == guess)
               {
                   System.out.println("You already guessed " + guess +". Pick another letter.");
               }
               else
               {
                   
               }
            }
            previousGuess.add(guess);
            if(result == true)
            {
                System.out.println(currentGuessString());
                System.out.println("Player guesses " + guess);
            }

            else
            {
                System.out.println("I'm sorry, the word has no " + guess + ". You have " + lives + " lives left.");
                lives = lives - 1;
                if(lives == 0)
                {
                    System.out.println("No more lives remaining. The word was " + new String(theTarget));
                }
            }
            boolean allTheSame = true;
            for(int i = 0; i<theWord.length();i++)
            {
                if(theTarget[i] != currentGuess[i])
                {
                    allTheSame = false;
                }

            }
            if(allTheSame == true)
            {
                System.out.println("You Win!");
                lives=0; //kill loop because game is over 
            }
        }
        
    }

    /**
     * Re-initializes variables for the start of a new game.
     */
    public void setupGame()
    {
        previousGuess = new ArrayList<Character>();
        int word = generator.nextInt(wordList1.size());
        theWord = wordList1.get(word);
        theTarget = new char[theWord.length()];
        theTarget = theWord.toCharArray();
        currentGuess = new char[theWord.length()];
        currentGuess = theWord.toCharArray();
        for(int i = 0; i<currentGuess.length; i++)
        {
            currentGuess[i] = '_';
        }

        lives = 5;
    }
}
