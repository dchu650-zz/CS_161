import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A set of buttons to control a Hangman game
 */
public class HangmanButtons implements ActionListener
{
    private HangmanGame game;

    private JFrame container; //not extending to make documentation more readable
    private JButton playButton;
    private JButton evilButton;
    private boolean evilMode;
    
    /**
     * Creates a new HangmanButtons object. This is a frame with buttons to press
     * @param game The HangmanGame object to control
     */
    public HangmanButtons(HangmanGame game)
    {
        this.game = game;
        container = new JFrame();
        container.setTitle("Hangman Game");
        container.setResizable(false); //we don't need to resize this
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playButton = new JButton("Play Hangman");
        playButton.addActionListener(this); //add listener
        evilButton = new JButton("Evil Mode: Off");
        evilButton.addActionListener(this); //add listener
        evilMode = false; //start false
        
         //do layout
        container.getContentPane().setLayout(new BorderLayout()); //make a layout for the frame
        container.getContentPane().add(playButton,BorderLayout.WEST); //play button to the west
        container.getContentPane().add(evilButton,BorderLayout.EAST); //evil button to the east
        
        container.pack();
        container.setVisible(true);
    }

    /**
     * Handle events (e.g., button clicks)
     * The actionPerformed method is required by the ActionListener interface
     * @param evt the ActionEvent triggered by some outside event
     */
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource() == playButton) //respond to playButton
        {
            game.playGame(); //play the game!
        }
        
        if(evt.getSource() == evilButton) //respond to evilButton
        {
            game.toggleEvil(); //toggle evil
            evilMode = !evilMode; //note in our local variable
            if(evilMode == false) //make text match
            {
                evilButton.setText("Evil Mode: Off");
            }
            else
            {
                evilButton.setText("Evil Mode: On");
            }
        }
    }

}
