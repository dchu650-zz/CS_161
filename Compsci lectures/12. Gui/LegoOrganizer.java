import javax.swing.*;
import java.awt.*;

/**
 * A LegoOrganizer.
 */
public class LegoOrganizer
{
    /**
     * Creates a new LegoOrganizer object.
     */
    public LegoOrganizer()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Lego Organizer");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = frame.getContentPane();
        
        JLabel label = new JLabel("Legos with very very long text ");
        
        JButton blueButton = new JButton("Add Blue Brick");
        JLabel blueLabel = new JLabel("Blue Bricks");

        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(new GridLayout(2,1));
        bluePanel.add(blueButton);
        bluePanel.add(blueLabel);
        
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(label, BorderLayout.NORTH);
        frame.getContentPane().add(bluePanel, BorderLayout.CENTER);
        frame.getContentPane().add(new JLabel("3"), BorderLayout.WEST);
        
        frame.pack();
        frame.setVisible(true);
        
        
        
    }



}
