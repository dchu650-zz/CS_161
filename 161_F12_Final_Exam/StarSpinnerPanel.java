import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StarSpinnerPanel extends JPanel implements ActionListener
{
    private Polygon star;    
    private double rotation;
    private Timer timer;

    JPanel startPanel;
    JButton startButton; 

    /**
     * Creates an image of a Star
     */
    public StarSpinnerPanel()
    {
        JFrame frame = new JFrame();//makes a new frame
        setPreferredSize(new Dimension(400,400));//sets the size of the frame that appears.The frame appears behind the star frame. 

        startButton = new JButton("Spin");//(Darren) make a new button that invokes the action
        startButton.addActionListener(this);
        startPanel = new JPanel();
        startPanel.setPreferredSize(new Dimension(100,100));
        startPanel.setLayout(new GridLayout(2,1));
        startPanel.add(startButton);

        star = new Polygon();
        star.addPoint(205,295);//draws that points that the star will be located at.
        star.addPoint(235,230);//draws that points that the star will be located at.
        star.addPoint(305,220);//draws that points that the star will be located at.
        star.addPoint(250,170);//draws that points that the star will be located at.
        star.addPoint(265,100);//draws that points that the star will be located at.
        star.addPoint(200,135);//draws that points that the star will be located at.
        star.addPoint(140,105);//draws that points that the star will be located at.
        star.addPoint(150,175);//draws that points that the star will be located at.
        star.addPoint(100,225);//draws that points that the star will be located at.
        star.addPoint(175,235);//draws that points that the star will be located at.

        frame.getContentPane().add(startPanel,BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);

        //creates a time for which the speed the star will keep spinning
        //startSpinning();
    }

    /**
     * A method that paints the image of the Star and displays it in a blue background.
     * @param Graphics g parameter
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);//Gains all the information of the super class so we dont lose methods or information
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(new Color(0,0,51));//Basically dipping the paint brush at a color
        g2d.fillRect(0,0,400,400);//Drawing the image

        g2d.setPaint(new GradientPaint(130,130, Color.YELLOW, 270,270, Color.ORANGE));//Basically dipping the paint brush at a color
        g2d.rotate(rotation,200,200);//Rotates the star
        g2d.fill(star);//Draws the image of the star
    }

    /**
     * An ActionListener method that takes the timer into account in order to set a speed.
     * @param ActionEvent e parameter
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == timer)  
        {
            rotation += 0.01;
            repaint();
        }
    }
    
    public void actionPerformedButton(ActionEvent e)
    {
        if(e.getSource() == startButton)
        {
            timer = new Timer(25,this); 
            startSpinning();
        }
    }

    /**
     * A method that starts the timer.
     * When the timer stars, the action will perform.
     */
    public void startSpinning()
    {
        timer.start();
    }

}
