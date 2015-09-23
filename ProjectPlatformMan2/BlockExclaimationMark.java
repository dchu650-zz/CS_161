import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * The block which holds the shroom, an item which platform man must pick up in order to win the game
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class BlockExclaimationMark{
    protected int position; // Stores the X Position of the exclamation block
    protected int yPosition; //Stores the Y Position of the exclamation block
    protected BufferedImage block; // stores the image of the block
    /**
     * Constructor for objects of class BlockExclaimtionMark
     */
    public BlockExclaimationMark()
    {
        position = 500; // sets the batmobile at the position 300       
        yPosition = 300;
        block = ImageUtils.loadImage("ExclaimationBlock.jpg");
    }

    /**
     * Draw method for the Block
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {        
        canvas.drawImage(block, position, yPosition);
    }
}
