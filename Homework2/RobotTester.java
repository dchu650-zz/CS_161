
/**
 * A simple program to test the Robot class
 * 
 * @author Chuck Hommel 
 * @version 2011.06.07
 */
public class RobotTester
{
    
    Robot bob;   // robot to test

    /**
     * Constructor for objects of class RobotTester
     */
    public RobotTester()
    {
        bob = new Robot("testRobot");
        bob.makeVisible();
    }

    /**
     *  Test the turnRight() method 
     */
    public void testTurn()
    {
        System.out.println("Testing turnRight()...");
        System.out.println("Status before turning..." + bob.toString());
        bob.turnRight();
        System.out.println("Status after turning..." + bob.toString());
        System.out.println("End of test\n\n");

    }
    
    /**
     * Test the turnOn() method
     * 
     */
    public void testStart()
    {
        System.out.println("Testing turnOn()...");
        System.out.println("Status before starting..." + bob.toString());
        bob.turnOn();
        System.out.println("Status after starting..." + bob.toString());
        System.out.println("End of test\n\n");
    }
 
    /**
     * Test the turnOff() method
     * 
     */    
    public void testStop()
    {
        System.out.println("Testing turnOff()...");
        System.out.println("Status before stopping..." + bob.toString());
        bob.turnOff();
        System.out.println("Status after stopping..."+ bob.toString());
        System.out.println("End of test\n\n");
    }
    /**
     * More complicated test to check turning when motor is on or off
     * 
     */
    public void testTurnWithStartAndStop()
    {
        System.out.println("Testing turning with motor off...");
        testStop();
        System.out.println("Testing turn...");
        testTurn();
        System.out.println("Status after turn..."+ bob.toString());
        System.out.println("Testing turning with the motor on...");
        testStart();
        System.out.println("Testing turn...");
        testTurn();
        System.out.println("Status after turn..."+ bob.toString());
        System.out.println("End of test\n\n");
    }
    
    /** 
     * test turning in complete circle
     * 
     */
    public void testTurnInCircle()
    {
        bob.turnOn();
        System.out.println("Status before full turn..." + bob.toString());
        bob.turnRight();
        bob.turnRight();
        bob.turnRight();
        bob.turnRight();
        System.out.println("Status after full turn..." + bob.toString());
        System.out.println("End of test\n\n");
    }
    
    /**
     * More complicated test to check moving when motor is on or off
     * 
     */
    public void testMove()
    {
        System.out.println("Test 1:  Testing moving with motor off. Stopping motor...");
        testStop();
        System.out.println("Testing move...");
        bob.moveForward(100);
        System.out.println("Status after move..."+ bob.toString());
        System.out.println("Test 2:  Testing moving with the motor on. Starting motor...");
        testStart();
        System.out.println("Testing move...");
        bob.turnRight();
        bob.moveForward(100);
        bob.turnRight();
        bob.moveForward(100);
        bob.turnRight();
        bob.turnRight();
        bob.turnRight();
        bob.moveForward(100);
        bob.turnRight();
        bob.turnRight();
        bob.turnRight();
        bob.moveForward(50);
        System.out.println("Status after move..."+ bob.toString());
        System.out.println("End of test\n\n");
    }
        
}

