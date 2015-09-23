import java.util.*;         // for the ArrayList collection class
import java.lang.Math.*;    // for the random number generator

/**
 * This program tests the Robot class by
 * creating a list of robots and moving them around 
 * randomly
 * New topics:
 *      <ul>
 *         <li>import statement  (java.util)</li>
 *         <li>ArrayList collection </li>
 *         <li>Looping statements   </li>
 *         <li>final declarations   </li>
 *      </ul>
 *      
 *
 * @author Chuck Hommel  
 * @version 2/7/08
 * 
 */
public class RobotChaos
{
    public final int MAXROBOTS = 10;   // the maximum number of robots allowed
    ArrayList<Robot> myRobots;         // the list of robots
 
    /**
     * Constructor for objects of class RobotChaos
     */
    public RobotChaos()
    {
        // create the list of robots
        System.out.println ("Creating a list of robots...");
        myRobots = new ArrayList<Robot>();
        System.out.println ("Adding " + MAXROBOTS + " robots...");
         for (int i = 0; i < MAXROBOTS; i++)
        {
            Robot r = new Robot("robot"+i);
            myRobots.add(r);
            r.makeVisible();
        }
        
        System.out.println ("Starting the robots...");
        for (Robot r : myRobots)
        {
            r.turnOn();
        }
         
        System.out.println ("Here they are...");
        for (Robot r : myRobots)
        {
            System.out.println( r.toString());
        }
        
        System.out.println ("Done.");
    }
    
    /**
     * OK. Now the robots get to move all over the place.
     * This method goes through the list of robots one by one.
     * For each robot, it instructs the robot to turn right a 
     * (random) number of times, then to move forward a (random)
     * number of steps. This method does not change the state
     * of the robot motors.
     */
    public void letEmLoose()
    {
        int nTurns;     // number of times to turn right
        int nMoves;     // number of pixels to advance
        
        for (int j = 0; j < 100; j++)     // do this 100 times
        {
            // for each robot
            for (Robot r : myRobots)
            {
                //generate a random number of turns in interval 0-3
                nTurns = (int)(4.0 * Math.random());
                
                //generate a random number of pixels to move 0-99
                nMoves = (int)(100.0 * Math.random());
                
                // now make the robot turn nTurns times
                for (int i = 0; i < nTurns; i++)     // could also use 
                                                     //        for (int i = 1; i <= nTurns; i++)
                {
                    r.turnRight();
                }
                
                // now move forward
                // could use 
                r.moveForward(nMoves); 
                //but this is a little cooler
                // for (int i = 0; i < nMoves; i=i+3)
                // {
                //      r.moveForward(3);
                //  }
                
                // go to next robot
            }
            // do 'em all again
        }
    }
}
