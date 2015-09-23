import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
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
        ySpeed = randomSpeed.nextInt(7);
        color = "magenta";
        diameter = 35;
        xPosition = leftBound;
        yPosition = upBound;
        
        draw(); //draws the ball on the screen
    }

    /**
     * Method to move the ball
     */
    public void move()
    {
        xPosition = xPosition + xSpeed;
        yPosition = xPosition + ySpeed;
        draw();
        if (xPosition >= rightBound - diameter)
        {
            xSpeed = -(xSpeed);
            
        }
        else
        {
        }
         if (xPosition >= leftBound)
        {
            xSpeed = -(xSpeed);
            
        }
        else
        {
        }
        if (yPosition >= upBound)
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
    
    public void setColor(String c)
    { 
        c = "color";
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
