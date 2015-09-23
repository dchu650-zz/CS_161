import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * Write a description of class Dario here.
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class Cloudman
{
    protected int position; // The X Position of the cloudman
    protected int yPosition; //The Y Position of the cloudman
    protected BufferedImage theCloudman; //Stores the jpeg image of the cloudman
    protected int speed; // determines how fast the cloudman moves across the screen
    protected boolean facingRight; //Determines if the cloudman should go left or right depending on his position on the screen
    /**
     * Constructor for objects of class RegularBlock
     */
    public Cloudman()
    {
        facingRight = true;
        position = 0;
        yPosition = 0;
        theCloudman = ImageUtils.loadImage("Cloudman.jpg");
    }

    /**
     * Draw method for the RegularBlock
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {        
        canvas.drawImage(theCloudman, position, yPosition);
    }
    
     /**
     * Moves the cloudman based on his position
     */
    public void drive()
    {
        speed = 10; // sets the speed
        if(facingRight==true)  // a field stating which way the vehicle is facing
        {
            position = position + speed; // moves the vehicle towards the right
            turn(); //calls the turn method
        }
        else
        {
            position = position - speed; //moves the vehicle towards the left
            turn(); //calls the turn method
        }
    }
    
     /**
     * Changes the cloudman's direction
     */
    public void turn()
    {
        if(position >= PlatformMan.LENGTH) //if the car is all the way on the right side of the road   
        {
            facingRight = false; //turns the car to the left
        }
        if(position <= 0) //if the carr is all the way on the left side of the road 
        {
            facingRight = true; //turns the car to the right
        }
    }
}