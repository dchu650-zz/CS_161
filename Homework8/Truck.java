import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * A class for the Truck
 * 
 * @author Darren Chu
 * @version 11/11/12
 */
public class Truck extends Vehicle
{  
    protected ArrayList<Color> theColors; // an arraylist of colors field
    protected Color color; // a field for a color
    protected Random randomGen; // a field for the random generator
    protected int random; // a field for a random int
    protected int speed;
    /**
     * Constructor for objects of class Truck
     */
    public Truck()
    {        
        randomGen = new Random(); // instantiates a new random generator 
        random = randomGen.nextInt(4); // sets random with a random number
        theColors = new ArrayList<Color>(); // instantiates a new arraylist of colors
        theColors.add(Color.BLACK); // adds the color black into the arraylist
        theColors.add(Color.BLUE); // adds the color blue into the arraylist
        theColors.add(Color.RED); // adds the color red into the arraylist
        theColors.add(Color.CYAN); // adds the color cyan into the arraylist
    }

    /**
     * Draws the truck 
     * @param A canvas upon which the vehicles are drawn
     */
    public void draw(Canvas c)
    {
        Color foreground = c.getForegroundColor(); // gets the foreground color 
        c.setForegroundColor(color); // sets the foreground color
        if(position%100==0) // if the posistion is multiple of 100
        {
            color = theColors.get(random); // gets a random color and sets the car at the color
            random = randomGen.nextInt(4); // stores the color that it changed 
        }
        c.fillRectangle(position+100, 90, 75, 50); // draws the base of the car
        c.fillCircle(position+100,140,20); // draws a wheel of the car
        c.fillCircle(position+150,140,20); // draws a wheel of the car 
        c.setForegroundColor(foreground); // sets the foreground color
        if(facingRight==false) // if the car is facing left
        {
            facingRight = true; // make the car always facing right
        }
    }

    /**
     * Moves the vehicles based on their positions
     */
    public void drive()
    {
        speed = 3;
        super.drive(); // calls upon Vehicles' drive method
    }
}

