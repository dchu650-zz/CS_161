import javax.swing.*;
import java.awt.*;

/**
 * A frame that displays the StarSpinner; will eventually have a button to start the star spinning.
 */
public class StarSpinnerFrame extends JFrame
{
    private StarSpinnerPanel sky; //a panel for our spinning star

    /**
     * The constructor that makes the frame.
     */
    public StarSpinnerFrame()
    {
        //set up the frame
        setTitle("Twinkle Twinkle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout()); //put a border layout in the contentPane
        
        sky = new StarSpinnerPanel(); //make the canvas with the spinning star
        
        getContentPane().add(sky, BorderLayout.CENTER); //add the canvas to the frame
        
        //pack and display
        pack();
        setVisible(true);
    }
    
}
