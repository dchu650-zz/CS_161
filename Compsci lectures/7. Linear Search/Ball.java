import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BouncingBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball
{
    private int diameter;
    private String color;
    private int xPosition;
    private int yPosition;

    //variables for court boundaries -- DO NOT MODIFY
    private int rightBound = Ballcourt.XCORNER + Ballcourt.WIDTH;
    private int upBound    = Ballcourt.YCORNER;
    private int leftBound  = Ballcourt.XCORNER;
    private int lowBound   = Ballcourt.YCORNER + Ballcourt.WIDTH;

    /**
     * Constructor for objects of class BouncingBall
     */
    public Ball()
    {

        draw(); //draws the ball on the screen
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
