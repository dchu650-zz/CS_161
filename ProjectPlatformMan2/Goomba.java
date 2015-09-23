import java.lang.Object;
import java.awt.image.BufferedImage;
import java.awt.*;
/**
 * A moving enemy which platform man must avoid
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class Goomba
{
    public BufferedImage goomba; //Used to store the jpeg image of the goomba
    protected int position;  //The X Position on the canvas of the Goomba
    protected int yPosition; //The Y Position on the canvas of the Goomba
    protected int speed; //The speed at which the goomba moves across the canvas
    protected boolean facingRight; //Decides if the goomba should switch directions
    /**
     * Constructor for objects of class Goomba
     */
    public Goomba()
    {
        facingRight = true;
        position = 700;
        yPosition = 500;
        goomba = ImageUtils.loadImage("Goomba.jpg");
    }

    /**
     * Draw method for the Goomba
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {
        canvas.drawImage(goomba, position, yPosition);
    }
    
    /**
     * Allows the goomba to move acorss the screen. This method
     * Is called in the animate class in Marioland
     * 
     * @param
     * @return
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
     *Erases the canvas. 
     * 
     * @param Canvas parameter, erases the canvas it is given as a parameter
     * @return
     */
    
    public void erase(Canvas canvas)
    {
        Color oc = canvas.getForegroundColor();
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillRectangle(position,500,40,40);
        canvas.setForegroundColor(oc);
    }

    /**
     * Makes facing right true or false depending on if the goomba
     * needs to move left or right
     * 
     * @param
     */
    public void turn()
    {
        if(position >= PlatformMan.LENGTH-150) //if the car is all the way on the right side of the road   
        {
            facingRight = false; //turns the car to the left
        }
        if(position <= 400) //if the carr is all the way on the left side of the road 
        {
            facingRight = true; //turns the car to the right
        }
    }
}
