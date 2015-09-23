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
    private ArrayList<String> possibleWords;
    private int lives;
    private boolean valid;
    private boolean isEvil;
    private int i = 0;
    private String evilGuessTempString;

    private char[] potentialWord; //possible word that matches preivious guesses
    private String aGuess; //that current guess string thats displayed on the canvas
    private char[] anyWord; //arbitrary word in currentPossibleList
    private Canvas theCanvas; //the canvas that we draw on

    /**
     * A class to play a game of Hangman.
     */
    public HangmanGame(Canvas newCanvas)
    {
        generator = new Random();
        wordList1 = new WordList().getWords();
        this.setupGame();
        isEvil = false;
        theCanvas = newCanvas;

    }

    /**
     * Constructor for objects of class HangmanGame when evil
     */
    public HangmanGame(boolean isEvil)
    {
        generator = new Random();
        wordList1 = new WordList().getWords();
        this.setupGame();
        isEvil = false;
        theCanvas = new Canvas("newCanvas");
        System.out.println(isEvil);
    }

    /**
     * Constructor for objects of class HangmanGame
     */
    public HangmanGame()
    {
        generator = new Random();
        wordList1 = new WordList().getWords();
        theCanvas = new Canvas("newCanvas");
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
        theCanvas = new Canvas("newCanvas");
        this.setupGame();
    }

    /**
    /**
     *   A helper method (that could be private) that draws the gallows on the game's Canvas.
     */
    public void drawGallows()
    {
        theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
        //draws a set of lines that makes up the gallows structure
        theCanvas.drawLine(10, 10, 70, 10);
        theCanvas.drawLine(10, 10, 10, 120);
        theCanvas.drawLine(70, 10, 70, 20);
        theCanvas.drawLine(0, 120, 90, 120);

    }

    /**
     * A helper method (that could be private) that draws the current guess on the game's Canvas.
     */
    public void drawCurrentGuess()
    {
        aGuess = currentGuessString(); //gets the current state of the guess string
        theCanvas.drawString(aGuess, 10, 140); //displays the current guess on the canvas
    }

    /**
     * A helper method (that could be private) that draws the hangedman on the game's Canvas.
     */
    public void drawHangedMan()
    {
        if(lives == 5) //first wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the head
            theCanvas.fillCircle(60, 20, 20);
        }
        if(lives == 4) //second wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the head and body
            theCanvas.fillCircle(60, 20, 20);
            theCanvas.drawLine(70, 40, 70, 90);
        }
        if(lives == 3) // third wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the head, body and arm
            theCanvas.fillCircle(60, 20, 20);
            theCanvas.drawLine(70, 40, 70, 90);
            theCanvas.drawLine(70, 45, 55, 45);
        }
        if(lives == 2) // fourth wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the head, body and arms
            theCanvas.fillCircle(60, 20, 20);
            theCanvas.drawLine(70, 40, 70, 90);
            theCanvas.drawLine(70, 45, 55, 45);
            theCanvas.drawLine(70, 45, 85, 45);
        }
        if(lives == 1) //fifth wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the head, body, arms and leg
            theCanvas.fillCircle(60, 20, 20);
            theCanvas.drawLine(70, 40, 70, 90);
            theCanvas.drawLine(70, 45, 55, 45);
            theCanvas.drawLine(70, 45, 85, 45);
            theCanvas.drawLine(70, 90, 55, 105);
        }
        if(lives == 0) //final wrong guess
        {
            theCanvas.setVisible(true); //makes sure anything we draw appears on the canvas
            //draws the entire body
            theCanvas.fillCircle(60, 20, 20);
            theCanvas.drawLine(70, 40, 70, 90);
            theCanvas.drawLine(70, 45, 55, 45);
            theCanvas.drawLine(70, 45, 85, 45);
            theCanvas.drawLine(70, 90, 55, 105);
            theCanvas.drawLine(70, 90, 85, 105);
        }
    }

    /**
     * A helper method that clears and redraws the Canvas based on the current state of the game.
     */
    public void redrawCanvas()
    {
        if(theCanvas != null) //checks if the canvas object exists
        {
            theCanvas.erase(); //erases whatever was previous on the canvas
            //replaces with all the current game information
            drawGallows();
            drawCurrentGuess();
            drawHangedMan();
        }
    }

    /**
     * A helper method (that could be private) that finds the list of possible words 
     * that match the current revealed word. 
     * Finds words that match every revealed character, 
     * and whose unrevealed letters have not previously been guessed. 
     * @return The list of possible words that match the revealed word
     */
    private ArrayList<String> findPossibleMatchingWords()
    {
        boolean isMatch = false; 
        ArrayList<String> tempPossibleWords = new ArrayList<String>(); // an arraylist that stores all the possible words
        char[] tempChar;
        for(String potentialWord : possibleWords) //for all the words in possibleWords arraylist
        {
            isMatch = true;
            if(potentialWord.length() == theTarget.length) //the words must be the same length of letters
            {
                tempChar = potentialWord.toCharArray(); //make a local variable that sets String potentialWord as a CharArray
                for(int i =0; i<potentialWord.length(); i++)
                {
                    if(currentGuess[i]!='_') //if there is a letter or are letters revealed in the hangman game
                    {
                        if(currentGuess[i]!=tempChar[i]) //checks if the letters in th particular position or not
                        {
                            isMatch = false;
                        }
                    }
                    else
                    {
                        if(previousGuess.contains(tempChar[i])) //checks if we have already made the guess before in tempChar
                        {
                            isMatch = false;
                        }
                    }
                }
                if(isMatch == true)
                {
                    tempPossibleWords.add(potentialWord); //add the potentialWord into the arraylist the stores all the possible words
                }
            }
        }
        return tempPossibleWords;
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
        }
        return foundLetter;
    }

    /**
     * A helper method (that could be private) that checks to see if 
     * a given letter is present in the target word, but cheats! 
     * If so, all instances of that letter in the target word are revealed. 
     * This method cheats by picking a new word from the list of possibleWords when necessary, 
     * or trims down the size of possibleWords if the letter is correct 
     * @param Letter the letter being guessed.
     * @return Whether or not the letter was found in the word.
     */
    public boolean checkEvilGuess(char letter)
    {
        boolean foundLetter = false;
        for(int i = 0; i<theWord.length(); i++)
        {
            if(theTarget[i]==letter)
            {
                ArrayList<String> tempList = findPossibleMatchingWords(); //sets a arraylist that is equal to the specific and all the possible words in the PossibleMatchingWords() arraylist
                if(tempList.size()>0)
                {
                    possibleWords = tempList; //we set the wordlist as the tempList
                    int word = generator.nextInt(possibleWords.size()); //set a random generator for the entire possibleWords list
                    theWord = possibleWords.get(word); //select a word in the random generator
                    theTarget = theWord.toCharArray(); //switch the target word!
                    return false; //don't return any letters
                }
                else
                {
                    return checkGuess(letter); //if there are no more possible words to switch with because of the lack of letters, add a letter to their hangman
                }  
            }
        }
        if(foundLetter == true)
        {
            return foundLetter; //if foundletter is true stop. They found a letter 
        }
        else
        {
            return false;
        }
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
            theGuess = guessString.toLowerCase().charAt(0);
            if(Character.isLetter(theGuess))
            {
                return theGuess;
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
            boolean result = false;
            
            if(previousGuess.contains(guess))
            {
                System.out.println("You have already guessed " + guess);
            }
            else
            {
                previousGuess.add(guess);
                if(isEvil == true) //if the game is set a isEvil, the game will cheat!
                {
                    result = checkEvilGuess(guess); //uses the checkEvilGuess method instead of the checkGuess!
                }
                else
                {
                    result = checkGuess(guess);
                }
                if(result == true)
                {
                    redrawCanvas();
                    System.out.println(currentGuessString());
                    System.out.println("Player guesses " + guess);
                }

                else
                {
                    redrawCanvas();
                    System.out.println("I'm sorry, the word has no " + guess + ". You have " + lives + " lives left.");
                    lives = lives - 1;
                    if(lives == 0)
                    {
                        redrawCanvas();
                        System.out.println("No more lives remaining. The word was " + new String(theTarget));
                    }
                }
                //System.out.println(theTarget);
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
    }

    /**
     * Re-initializes variables for the start of a new game.
     */
    public void setupGame()
    {
        possibleWords = wordList1;
        previousGuess = new ArrayList<Character>();
        int word = generator.nextInt(wordList1.size());
        theWord = wordList1.get(word);
        theTarget = new char[theWord.length()];
        theTarget = theWord.toCharArray();
        currentGuess = theWord.toCharArray();
        //System.out.println(currentGuess);
        for(int i = 0; i<currentGuess.length; i++)
        {
            currentGuess[i] = '_';
            redrawCanvas();
        }

        lives = 5;
    }

    /**
     * Toggles whether the game is evil or not
     */
    public void toggleEvil()
    {
        i++;
        if(i%2!=0)
        {
            isEvil=true;
        }
        else
        {
            isEvil=false;
        }
        System.out.println(isEvil);

    }
}

