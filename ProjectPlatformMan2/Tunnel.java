import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * Tunnel class, creates tunnel objects
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/12)
 */
public class Tunnel
{
    protected int position; 
    protected int yPosition;
    protected BufferedImage theTunnel;
    /**
     * Constructor for objects of class RegularBlock
     */
    public Tunnel()
    {
        position = 960;
        yPosition = 490;
        theTunnel = ImageUtils.loadImage("Tunnel.jpg");
    }

    /**
     * Draw method for the RegularBlock
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {
        theTunnel = ImageUtils.loadImage("Tunnel.jpg"); 
        canvas.drawImage(theTunnel, position, yPosition);
    }
    
    
}