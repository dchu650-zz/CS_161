import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class BouncingBall here.
 * 
 * @author Darren and Deron 
 * @version September 18 2012
 */
public class Ball
{
    private int diameter;
    private String color;
    private int xPosition;
    private int yPosition;
    private int xSpeed;   //speed of movement in the x-direction
    private int ySpeed; //speed of movement in the y-direction
    private ArrayList<String> colors;
    private Ball ballTouched;

    //variables for court boundaries -- DO NOT MODIFY
    private int rightBound = BallCourt.XCORNER + BallCourt.WIDTH;
    private int upBound    = BallCourt.YCORNER;
    private int leftBound  = BallCourt.XCORNER;
    private int lowBound   = BallCourt.YCORNER + BallCourt.WIDTH;

    /**
     * Constructor for objects of class BouncingBall
     */
    public Ball()
    {
        Random randomSpeed = new Random ();
        xSpeed = randomSpeed.nextInt(7);
        if (xSpeed == 0)
        { xSpeed = randomSpeed.nextInt(7);
        }
        else
        {}
        ySpeed = randomSpeed.nextInt(7);
        if (ySpeed == 0)
        { ySpeed = randomSpeed.nextInt(7);
        }
        else
        {}
        colors = new ArrayList <String>();
        colors.add(new String ("red"));
        colors.add(new String ("blue"));
        colors.add(new String ("green"));
        colors.add(new String ("cyan"));
        colors.add(new String ("magenta"));
        colors.add(new String ("yellow"));
        colors.add(new String ("pink"));
        colors.add(new String ("orange"));
        Random randomColor = new Random();

        int index = randomColor.nextInt(8);
        color = colors.get(index);
        diameter = 35;
        xPosition = leftBound;
        yPosition = upBound;
        ballTouched = null;

        draw(); //draws the ball on the screen
    }

    /**
     * Method to move the ball
     */
    public void move()
    {
        xPosition = xPosition + xSpeed;
        yPosition = yPosition + ySpeed;
        draw();
        if (xPosition >= rightBound - diameter)
        {
            xSpeed = -(xSpeed);

        }
        else
        {
        }
        if (xPosition <= leftBound)
        {
            xSpeed = -(xSpeed);

        }
        else
        {
        }
        if (yPosition <= upBound)
        {
            ySpeed = -(ySpeed);

        }
        else
        {
        }
        if (yPosition >= lowBound - diameter)
        {
            ySpeed = -(ySpeed);

        }
        else 
        {
        }

    }

    /**
     * Change the color of the ball
     */
    public void setColor(String c)
    { 
        color = c;
        draw();
    }

    /**
     * Get the color of the ball
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Gives value of xPosition for circle
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Gets the information of the last ball touched 
     */
    public Ball getBallTouched()
    {
        return ballTouched;
    }

    /**
     * Sets the ball as a ball that has been touched
     */
    public void setBallTouched(Ball ball)
    {
        ballTouched = ball;
    }

    /**
     * Gives value of yPostion for circle
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * Check if one ball is touching the other
     */
    public boolean isTouching(Ball otherBall)
    {
        boolean isTouching = true;
        int x1 = xPosition + diameter/2;
        int y1 = yPosition + diameter/2;
        int x2 = otherBall.getXPosition() + diameter/2;
        int y2 = otherBall.getYPosition() + diameter/2;
        if(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))<=diameter)
        {
            isTouching = true;
        } 
        else
        {
            isTouching = false;
        }
        return isTouching;
    }

    /* ***************************************************************************************
     * The below methods draw and erase the ball. You may call them, but do not modify them! *
     *****************************************************************************************/

    /**
     * Draw the ball with current specifications on screen.
     */
    private void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
        canvas.wait(10);
    }

    /**
     * Erase the ball on screen.
     */
    private void erase()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }

}
