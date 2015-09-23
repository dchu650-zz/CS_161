import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * A DrawingPanel.
 */
public class DrawingPanel extends JPanel implements ActionListener
{
    Rectangle rect;
    Polygon poly;
    
    Timer clock;
    
    BufferedImage image;
    Graphics2D img2d;
    
    /**
     * Creates a new DrawingPanel object.
     */
    public DrawingPanel()
    {
        setPreferredSize(new Dimension(500,500));
        
        rect = new Rectangle(50,50,300,200);
        poly = new Polygon();
        poly.addPoint(30,30);
        poly.addPoint(130,30);
        poly.addPoint(120,200);
        poly.addPoint(70,200);
        poly.addPoint(290,100);
        poly.addPoint(0,100);
        
        clock = new Timer(30, this);
        clock.start();
        
        image = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
        img2d = image.createGraphics();
    }

    //override parent's method
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(image,0,0,null);
        
//         
//         g2d.setColor(Color.WHITE); //clear background
//         g2d.fillRect(0,0,500,500);
//                 
//         g2d.drawOval(100,75,150,40);        
//         
//         g2d.setColor(Color.GREEN);
//         g2d.fill3DRect(300,50,100,100,false);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == clock)
        {
            System.out.println("moving rectangle");
            rect.translate(2,1);

            //redraw our image
            img2d.setPaint(new GradientPaint(0,250,Color.GREEN,500,250,Color.PINK,true));
            img2d.fill(rect);

            
            if(rect.getX() > 500)
            {
                clock.stop();
            }
            
            
            repaint();
        }
        
    }
    
}
