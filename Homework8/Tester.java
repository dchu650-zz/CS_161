/**
 * A tester for the long road
 * 
 * @author Darren Chu
 * @version 11/11/12
 */
public class Tester
{
    private static LongRoad theRoad;
    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
    }
    /**
     * The main method
     */
    public static void main(String[] args)
    {
        theRoad = new LongRoad(); // calls the long road method
        theRoad.animate(2000); // animates the car for 2000 turns
    }
}
