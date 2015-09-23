
/**
 * Write a description of class Robot here.
 * 
 * @author (Darren Chu) 
 * @version (9/8/12)
 */
public class Robot
{
    private String theRobot;
    private Circle head;
    private Square body;
    private Triangle arm1;
    private Triangle arm2;
    private Triangle leg1;
    private Triangle leg2;
    private boolean isOn;
    private String facing;
    /**
     * Constructor for objects of class Robot
     */
    public Robot(String name)
    {
        theRobot = name;
        isOn = true;
        facing = "forward";
        // Draws the Robot at a set location
        head=new Circle(30, 70, 5);
        body=new Square(30, 70, 35);
        body.changeColor("green");
        arm1=new Triangle(10, 10, 60, 55);
        arm1.changeColor("black");
        arm2=new Triangle(10, 10, 90, 55);
        arm2.changeColor("black");
        leg1=new Triangle(10, 10, 70, 70);
        leg1.changeColor("magenta");
        leg2=new Triangle(10, 10, 80, 70);
        leg2.changeColor("magenta");
    }

    /**
     * Rotates the Robot 90 degrees
     */
    public void turnRight()
    {
        if (facing.equals("forward"))
        {
            //move the pieces to be right
            head.moveHorizontal(29);
            head.moveVertical(29);
            arm1.moveHorizontal(15);
            arm1.moveVertical(-20);
            arm2.moveHorizontal(-15);
            arm2.moveVertical(18);
            leg1.moveHorizontal(-15);
            leg1.moveVertical(-20);
            leg2.moveHorizontal(-25);
            leg2.moveVertical(-11);

            facing = "right";
        }
        else if(facing.equals("right"))
        {
            //move the pieces to be down
            head.moveHorizontal(-29);
            head.moveVertical(29);
            arm1.moveHorizontal(-15);
            arm1.moveVertical(20);
            arm2.moveHorizontal(15);
            arm2.moveVertical(-18);
            leg1.moveHorizontal(15);
            leg1.moveVertical(-13);
            leg2.moveHorizontal(25);
            leg2.moveVertical(-22);

            facing = "down";
        }
        else if(facing.equals("down"))
        {
            //moves the pieces to be left
            head.moveHorizontal(-29);
            head.moveVertical(-29);
            arm1.moveHorizontal(15);
            arm1.moveVertical(-20);
            arm2.moveHorizontal(-15);
            arm2.moveVertical(18);
            leg1.moveHorizontal(20);
            leg1.moveVertical(20);
            leg2.moveHorizontal(10);
            leg2.moveVertical(11);

            facing = "left";
        }
        else if(facing.equals("left"))
        {
            //move the pieces to be forward
            head.moveHorizontal(29);
            head.moveVertical(-29);
            arm1.moveHorizontal(-15);
            arm1.moveVertical(20);
            arm2.moveHorizontal(15);
            arm2.moveVertical(-18);
            leg1.moveHorizontal(-20);
            leg1.moveVertical(18);
            leg2.moveHorizontal(-10);
            leg2.moveVertical(27);
            
            facing = "forward";
        }

    }
    /**
     * Moves Robot forward.
     */
    public void moveForward(int distance)
    {
        if (isOn==true)
        {
            if (facing.equals("forward"))
            {
                //moves robot horizontally depending on where the robot is facing
                head.moveHorizontal(distance);
                body.moveHorizontal(distance);
                arm1.moveHorizontal(distance);
                arm2.moveHorizontal(distance);
                leg1.moveHorizontal(distance);
                leg2.moveHorizontal(distance);
            }
            else if (facing.equals("right"))
            {
                //moves robot horizontally depending on where the robot is facing
                head.moveVertical(distance);
                body.moveVertical(distance);
                arm1.moveVertical(distance);
                arm2.moveVertical(distance);
                leg1.moveVertical(distance);
                leg2.moveVertical(distance);
            } 
            else if (facing.equals("down"))
            {
                //moves robot horizontally depending on where the robot is facing
                head.moveHorizontal(-distance);
                body.moveHorizontal(-distance);
                arm1.moveHorizontal(-distance);
                arm2.moveHorizontal(-distance);
                leg1.moveHorizontal(-distance);
                leg2.moveHorizontal(-distance);
            }
            else if (facing.equals("left"))
            {
                //moves robot horizontally depending on where the robot is facing
                head.moveVertical(-distance);
                body.moveVertical(-distance);
                arm1.moveVertical(-distance);
                arm2.moveVertical(-distance);
                leg1.moveVertical(-distance);
                leg2.moveVertical(-distance);
            }
        }
    }

    /**
     * Makes the robot visible
     * 
     */
    public void makeVisible()
    {  
        head.makeVisible();
        body.makeVisible();
        arm1.makeVisible();
        arm2.makeVisible();
        leg1.makeVisible();
        leg2.makeVisible();
    }

    /**
     * Turns on the Robot.
     */
    public void turnOn()
    {   
        isOn = true;
    }

    /**
     * Turns off the Robot
     */
    public void turnOff()
    {
        isOn = false;
    }

    /**
     * Returns a statement, "name" the Robot.
     */
    public String toString()
    {
        if(isOn)
        {
            return theRobot + " the Robot the robot is on";
        }
        else
        {
            return theRobot + " the Robot the robot is off";

        }
    }
}
