import java.awt.image.BufferedImage;
import java.awt.Color;
/**
 * Allows a user to manipulate a graphic image.
 *  
 * @author Chuck Hommel
 * @version 2012.09.28
 */

//Solution For CS161F12 Lab F
public class PhotoShopper
{
    private BufferedImage theImage; // the current image
    private BufferedImage oldImage; // previous version of image, for undo

    /**
     * Constructor for objects of class PhotoShopper.
     * @param im the BufferedImage to view
     */
    public PhotoShopper(BufferedImage im)
    {
        theImage = im;
        oldImage = null;  // no previous version yet
    }

     /**
     * Simply return this image.
     * @return the image 
     */
    public BufferedImage getImage()
    {
        return theImage;
    }
    /**
     * Erase the image.
     * @return the image erased (i.e. all white pixels)
     */
    public BufferedImage eraseImage()
    {
        oldImage = theImage;  // save the old one
        int maxX = theImage.getWidth();  // dimensions of the image
        int maxY = theImage.getHeight();
        //Make a new version of the image
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
        // for each row in the image
        for (int row = 0; row < maxY; row++)
        {
                        // for each column in the image
            for (int column = 0; column < maxX; column++)
            {

                //change the color of this pixel to white
                newImage.setRGB(column, row, Color.WHITE.getRGB());
            }
        }
        theImage = newImage;
        return theImage;
    }

    /**
     * Create a mirror image of the current image.
     * @return the mirror image of the image
     */
    public BufferedImage mirrorImage()
    {
        oldImage = theImage;  // save the old one
        int maxX = theImage.getWidth();  // dimensions of the image
        int maxY = theImage.getHeight();
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
       // System.out.println("Mirroring image...");
        // for each row in the image
        for (int row = 0; row < maxY; row++)
        {
                        // for each column in the image
            for (int column = 0; column < maxX; column++)
            {

                // get the RGB for the current pixel
                int theRGB = theImage.getRGB(column, row);
                //    System.out.println("theRGB = " + theRGB);
                newImage.setRGB(maxX - column-1, row, theRGB);
            }
        }
        theImage = newImage;
        return theImage;
    }

    /**
     * Create an upside down image of the current image.
     * @return the image turned upside down
     */
    public BufferedImage upsideDownImage()
    {
        oldImage = theImage;  // save the old one
        int maxX = theImage.getWidth();  // dimensions of the image
        int maxY = theImage.getHeight();
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
        //System.out.println("upsideDown image...");
        // for each row in the image
        for (int row = 0; row < maxY; row++)
        {
                        // for each column in the image
            for (int column = 0; column < maxX; column++)
            {


                // get the RGB for the current pixel
                int theRGB = theImage.getRGB(column, row);
                //    System.out.println("theRGB = " + theRGB);
                newImage.setRGB(column, maxY - row - 1, theRGB);
            }
        }
        theImage = newImage;
        return theImage;
    }

    /**
     * Revert to old image.
     * @return previous version of the image, can be null if there is no previous version (only one level of undo allowed)
     */
    public BufferedImage undo()
    {
        if (oldImage == null)
        {
            return null;
        }
        else
        {
            theImage = oldImage;
            oldImage = null;
            return theImage;
        }
    }

    /**
     * Turn the image into its grayscale version.
     * @return the image converted to grayscale
     */
    public BufferedImage grayScaleImage()
    {
        oldImage = theImage;  // save the old one
        int maxX = theImage.getWidth();  // dimensions of the image
        int maxY = theImage.getHeight();
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
        // for each row in the image
        for (int row = 0; row < maxY; row++)
        {
                        // for each column in the image
            for (int column = 0; column < maxX; column++)
            {
                // get the RGB for the current pixel
                int theRGB = theImage.getRGB(column, row);
                // make a color so we can extract RGB components
                Color oldColor = new Color(theRGB);
                // get the components
                int redComponent = oldColor.getRed();
                int greenComponent = oldColor.getGreen();
                int blueComponent = oldColor.getBlue();
  
                //average the components
                int avg = (redComponent + greenComponent + blueComponent)/3;

                redComponent = avg;
                greenComponent = avg;
                blueComponent = avg;
                // make the new Color
                Color newColor = new Color(redComponent, greenComponent, blueComponent);
                // get the RGB for it as an int
                int newRGB = newColor.getRGB();
                // put it in the new picture
                //    System.out.println("theRGB = " + theRGB);
                newImage.setRGB(column, row, newRGB);
            }
        }
        theImage = newImage;
        return theImage;

    }

    /**
     * Turn the image into its negative.
     * @return the negative of this Image
     */
    public BufferedImage negativeImage()
    {
        oldImage = theImage;  // save the old one
        int maxX = theImage.getWidth();  // dimensions of the image
        int maxY = theImage.getHeight();
        BufferedImage newImage = new BufferedImage(maxX, maxY, BufferedImage.TYPE_INT_RGB);
        // for each row in the image
        for (int row = 0; row < maxY; row++)
        {
                        // for each column in the image
            for (int column = 0; column < maxX; column++)
            {
                // get the RGB for the current pixel
                int theRGB = theImage.getRGB(column, row);
                // make a color so we can extract RGB components
                Color oldColor = new Color(theRGB);
                // get the components
                int redComponent = oldColor.getRed();
                int greenComponent = oldColor.getGreen();
                int blueComponent = oldColor.getBlue();
                // negate the components
                redComponent = 255 - redComponent;
                greenComponent = 255 - greenComponent;
                blueComponent = 255 - blueComponent;
                // make the new Color
                Color newColor = new Color(redComponent, greenComponent, blueComponent);
                // get the RGB for it as an int
                int newRGB = newColor.getRGB();
                // put it in the new picture
                //    System.out.println("theRGB = " + theRGB);
                newImage.setRGB(column, row, newRGB);
            }
        }
        theImage = newImage;
        return theImage;

    }
}
