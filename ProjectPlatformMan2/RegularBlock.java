import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * The blocks, or ground, which platform man runs on
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/12)
 */
public class RegularBlock
{
    protected int position; 
    protected int yPosition;
    protected BufferedImage regularBlock;
    protected boolean facingRight;
    /**
     * Constructor for objects of class RegularBlock
     */
    public RegularBlock()
    {
        position = 0;
        yPosition = 300;
        facingRight=true;
        regularBlock = ImageUtils.loadImage("Brick.jpg");
    }

    /**
     * Draw method for the RegularBlock
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {
        regularBlock = ImageUtils.loadImage("Brick.jpg"); 
        canvas.drawImage(regularBlock, position+540, yPosition);
        canvas.drawImage(regularBlock, position+470, yPosition);
        for(int i = 0; i<PlatformMan.LENGTH; i++)
        {
            if(position % 30 == 0 || position == 0)
            {
                canvas.drawImage(regularBlock, position, yPosition+240);
                position = position + 30;
            }
        }
    }
}
