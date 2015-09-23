import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * A panel for showing images.
 * 
 * @author Chuck Hommel  
 * @version 2011.11.26
 */
public class ImagePanel extends JPanel
{
    private BufferedImage theImage;   // the image to show

    /**
     * Constructor for objects of class ImagePanel
     */
    public ImagePanel()
    {
        theImage = null;
    }

    /** 
     * shows the image
     * @param b the buffered image to show
     */
    public void showImage(BufferedImage b)
    {
        theImage = b;
        repaint();
    }

    /**
     * overrides the paintComponent of JPanel
     */
    protected void paintComponent(Graphics g)
    {
        // always call the super method to refresh the things we aren't doing explicitly here
        super.paintComponent(g);
        // is there an image to show?
        if (theImage != null)
        {
            // scale the image so it fits nicely in the panel
            // set up a small border
            int border = 10;
            // get window size
            Dimension d = this.getSize();
            // compute ratios of  panel height and width to image height and width
            double hRatio = (double)(d.getHeight() - 2 * border)/theImage.getHeight();
            double wRatio = (double)(d.getWidth() - 2 * border)/theImage.getWidth();
            // pick the smaller ratio for scaling
            double theRatio = Math.min(hRatio, wRatio);
            
            // compute rescaled width and height of image. 
            int theWidth = (int)(theImage.getWidth() * theRatio);
            int theHeight = (int)(theImage.getHeight() * theRatio);
            // really fancy, center it
            int xoffset = ((int)d.getWidth() - theWidth)/2;
            int yoffset = ((int)d.getHeight() - theHeight)/2;
                        
            // draw the image
            g.drawImage(theImage, xoffset, yoffset, theWidth, theHeight, null);
        }
    }
}
