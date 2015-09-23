import java.lang.Object;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * The Shroom, an item platform man must get in order to win the game
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class Shroom
{
    protected int position; // Stores the X Position of the Shroom
    protected BufferedImage theShroom; // Stores the jpeg image of the shroom
    protected boolean onShrooms; //If the man has picked up the shroom, he can win the game. This boolean is used to determine if the play can win the game.
    protected boolean noMoreShrooms; //Once the shroom is drawn, this field becomes true so that multiple mushrooms will not be drawn.
    /**
     * Constructor for objects of class Shroom
     */
    public Shroom()
    {
        position = 0;  
        onShrooms = false;
        noMoreShrooms = false;
        theShroom = ImageUtils.loadImage("Shrooms.jpg");
    }

    /**
     * Draws the shroom on the canvas
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {
        theShroom = ImageUtils.loadImage("Shrooms.jpg"); // displays the block image 
        canvas.drawImage(theShroom, position, 490);       
    }
    
    /**
     * Used to reduce artifacts left by the shroom
     * 
     * @param the canvas which the shroom is drawn on
     */
    public void erase(Canvas canvas)
    {        
        Color oc = canvas.getForegroundColor();
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillRectangle(position,490,60,40);
        canvas.setForegroundColor(oc);
    }
}