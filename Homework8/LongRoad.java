import java.lang.Object;
/**
 * Allows users to drive three separate vehicles on a road in a canvas.
 * 
 * @author Darren Chu
 * @version 11/11/12    
 */
public class LongRoad
{
    private Canvas canvas; //The canvas in which the Car, Truck, Batmobile and Road is displayed on
    private Car theCar; //A car field
    private Truck theTruck; //A truck field
    private Batmobile theBatmobile; //A batmobile field
    public static final int LENGTH = 600; //Setting the length of the LongRoad
    public static final int HEIGHT = 200; //Setting the height of the LongRoad
    /**
     * Constructor for objects of class LongRoad
     */
    public LongRoad()
    {
        theCar = new Car(); // initialise the Car
        theTruck = new Truck(); // initialise the Truck
        theBatmobile = new Batmobile(); // initialise the Batmobile
        canvas = new Canvas("canvas", LENGTH, HEIGHT); // initialise a new Canvas at the set length and width
        canvas.drawLine(0, 160, 600, 160); // draws the road
        this.redraw(); //calls the redraw method
    }

    /**
     * Moves all of the objects
     * @param The number of pixels it moves
     */
    public void animate(int turns)
    {
        for(int i = 0; i<turns; i++)
        {
            canvas.erase(); // erases the canvas
            canvas.drawLine(0, 160, 600, 160); // redraws the road
            theCar.drive(); // moves the car
            theTruck.drive(); // moves the truck
            theBatmobile.drive(); // moves the batmobile
            redraw(); // calls the redraw method to redraw all of objects
            canvas.wait(10); // set a speed
        }
    }

    /**
     * Draws all the objects onto the canvas.
     */
    public void redraw()
    {
        theCar.draw(canvas); // draws the car onto the canvas
        theTruck.draw(canvas); // draws the truck onto the canvas
        theBatmobile.draw(canvas); // draws the batmobile onto the canvas
    }
}
