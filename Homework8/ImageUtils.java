import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 * 
 */
public class ImageUtils
{
    /**
     * Loads an image from a specitic file
     * @param The name of the image file being uploaded
     * @return Returns the loaded image.
     */
    public static BufferedImage loadImage(String filename)
    {        
        try 
        {
            return ImageIO.read(new File(filename));
        }
        catch (IOException e) 
        {
            System.out.println("Failed to load image "+filename);
            return null;
        }
    }

    /**
     * Makes a mirror image if the buffered image
     * @param The image that has been loaded
     * @return Returns mirror image of the buffered image.
     */
    public static BufferedImage mirrorImage(BufferedImage theImage)
    {
        int maxX = theImage.getWidth();
        int maxY = theImage.getHeight();
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < maxY; row++)
        {
            for (int column = 0; column < maxX; column++)
            {
                int theRGB = theImage.getRGB(column, row);
                newImage.setRGB(maxX - column-1, row, theRGB);
            }
        }
        return newImage;
    }
    
}
