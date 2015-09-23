import java.lang.Object;
import java.awt.image.BufferedImage;
/**
 * A class for the Batmobile
 * 
 * @author Darren Chu 
 * @version 11/15/12
 */
public class Batmobile extends Vehicle
{
    protected boolean facingRight; // a field for setting the direction
    protected int position; // a field for where the batmobile is located
    protected int speed; // a field for how fast the batmobile moves
    protected BufferedImage batmobile; // a field for the batmobile image
    protected BufferedImage flippedMobile; // a field for the flipped batmobile image
    /**
     * Constructor for objects of class Batmobile
     */
    public Batmobile()
    {
        facingRight = true; // sets the batmobile facing right
        position = 300; // sets the batmobile at the position 300
        batmobile = ImageUtils.loadImage("batmobile.jpg"); // displays the batmobile image
        flippedMobile = ImageUtils.mirrorImage(batmobile); // displays the flipped batmobile image
    }

    /**
     * Draw method for the Batmobile
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {
        batmobile = ImageUtils.loadImage("batmobile.jpg"); // displays the batmobile image       
        if(facingRight == true) // if the batmobile is facing the right
        {
            canvas.drawImage(batmobile, position, 132); // draw the batmobile
        }
        if(facingRight == false) // if the batmobile is facing the left
        {
            canvas.drawImage(flippedMobile, position, 132); //draw the flipped batmobile
        }
    }

    /**
     * Drive method for the batmobile
     */
    public void drive()
    {
        if(facingRight==true) // if the batmobile is facing the right
        {
            position = position + speed; // move the batmobile by the speed toward the right
            if(position >= 0) // if the batmobile is moving to the right from the left side of the road
            {
                speed = 7; // increase the speed
                if(position >= LongRoad.LENGTH/2) // if the the batmobile is halfway across the road
                {
                    speed = 3; // sets the speed back to the original speed
                }
            }
            turn(); // calls the turn method
        }
        else
        {
            if(position <=LongRoad.LENGTH) // if the batmobile is moving to the left from the right side of the road
            {
                speed = 7; // increas the speed
                if(position<=LongRoad.LENGTH/2) // if the batmobile is halfway across the road
                {
                    speed = 3; // sets the speed back to the original speed
                }
            }
            position = position - speed; // move the batmobile by the speed toward the left
            turn(); // calls the turn method
        }
    }

    /**
     * Turns the car around
     */
    public void turn()
    {
        if(position >= LongRoad.LENGTH) // if the car is all the way to the right side of the road
        {
            facingRight = false; // the car flips
        }
        if(position <= 0) // if the car is all the way on the left side of the road
        {
            facingRight = true; // the car flips
        }
    }
}
