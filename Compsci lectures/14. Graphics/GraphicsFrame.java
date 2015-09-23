import javax.swing.*;

/**
 * A GraphicsFrame.
 */
public class GraphicsFrame extends JFrame
{
    /**
     * Creates a new GraphicsFrame object.
     */
    public GraphicsFrame()
    {
        setTitle("Graphics Test");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        DrawingPanel panel = new DrawingPanel();
        getContentPane().add(panel);
        
        pack();
        setVisible(true);        
    }

}
