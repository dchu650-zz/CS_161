import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A LegoOrganizer.
 */
public class LegoOrganizer implements ActionListener, MouseListener, MouseMotionListener, KeyListener
{
    private int blueCount = 0;
    private int redCount = 0;
    private int greenCourt = 0;

    JButton blueButton;
    JButton redButton;
    JLabel blueLabel;
    JLabel redLabel;

    Timer clock;

    JPanel mouseTester;

    /**
     * Creates a new LegoOrganizer object.
     */
    public LegoOrganizer()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Lego Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new BorderLayout()); //get contentPane ready

        blueButton = new JButton("Add a Blue Brick");
        blueButton.addActionListener(this);
        blueLabel = new JLabel(blueCount+" blue bricks"); //number of blue bricks added
        blueLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(150,200));
        bluePanel.setLayout(new GridLayout(2,1));
        bluePanel.add(blueButton);
        bluePanel.add(blueLabel);

        redButton = new JButton("Add a Red Brick");
        redButton.addActionListener(this);
        redLabel = new JLabel(blueCount+" red bricks"); //number of blue bricks added
        redLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel redPanel = new JPanel();
        redPanel.setPreferredSize(new Dimension(150,200));
        redPanel.setLayout(new GridLayout(2,1));
        redPanel.add(redButton);
        redPanel.add(redLabel);

        frame.getContentPane().add(bluePanel, BorderLayout.WEST);
        frame.getContentPane().add(redPanel, BorderLayout.EAST);

        mouseTester = new JPanel();
        mouseTester.setPreferredSize(new Dimension(300,300));
        frame.getContentPane().add(mouseTester, BorderLayout.SOUTH);
        mouseTester.addMouseListener(this);
        mouseTester.addMouseMotionListener(this);
        mouseTester.addKeyListener(this);
        mouseTester.setFocusable(true);

        clock = new Timer(1000,this);
        //clock.start();

        frame.pack();
        frame.setVisible(true);        
    }

    public void actionPerformed(ActionEvent event)
    {
        System.out.println("OMG action performed!");
        if(event.getSource() == blueButton)
        {
            blueCount++;
            blueLabel.setText(blueCount+" blue bricks");
        }
        else if(event.getSource() == redButton)
        {
            redCount++;
            redLabel.setText(redCount+" red bricks");
        }
        else if(event.getSource() == clock)
        {
            System.out.println("tick");
            //canvas.repaint();
        }
    }

    public void	mouseClicked(MouseEvent e)
    {
        //         System.out.println("mouse clicked");
        //         System.out.println(e);
    }

    public void	mouseEntered(MouseEvent e)
    {
    }

    public void	mouseExited(MouseEvent e)
    {
    }

    public void	mousePressed(MouseEvent e) 
    {
    }

    public void	mouseReleased(MouseEvent e)
    {
    }

    public void	mouseDragged(MouseEvent e)
    {}

    public void	mouseMoved(MouseEvent e) 
    {
        System.out.println("mouse moved: "+e);
    }

    public void	keyPressed(KeyEvent e)
    {}

    public void	keyReleased(KeyEvent e)
    {}

    public void	keyTyped(KeyEvent e)
    {
        if(e.getKeyChar() == 'q')
        {
            System.out.println("Q?");
        }
        else
        {
            System.out.println("not q");
        }
    }

}





