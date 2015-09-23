import java.lang.Object;
/**
* A GUI for the Hangman Game
*
* @author Darren Chu
* @version 10/31/12
*/
public class HangmanGUI //A GUI for the Hangman Game
{
   private Canvas theCanvas; //the canvas that we draw on
 
   private HangmanGame game; //declares the HangmanGame object
   private HangmanButtons buttons;//declares the HangmanButtons object
   //private HangmanButtons game;
 
    /**
     * Creates a new HangmanGUI object
     */
    public HangmanGUI()
    {
        theCanvas = new Canvas("newCanvas"); //initiates the canvas to play the game on
        game = new HangmanGame(theCanvas); //initiates the game with the canvas
        buttons = new HangmanButtons(game); //initiates the canvas game with buttons to play with
 
    }
}
 