import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * The spike pit object, an obstacle which platform man must avoid
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class Gap
{
    protected int position; // Stores the X Position for the Gap
    protected int yPosition;// Stores the Y Position for the Gap
    protected BufferedImage theGap; // Stores the image of the Gap
    /**
     * Constructor for objects of class BlockExclaimtionMark
     */
    public Gap()
    {
        position = 200;   
        yPosition = 500;
        theGap = ImageUtils.loadImage("theGap.png");
    }

    /**
     * Draw method for the Gap
     * @param The Canvas which the gap is drawn on
     */
    public void draw(Canvas canvas)
    {
        theGap = ImageUtils.loadImage("theGap.png"); // displays the block image 
        canvas.drawImage(theGap, position, yPosition);
    }
}

