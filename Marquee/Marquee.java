import java.awt.Font;
import javax.swing.*;
/**
 * Write a description of class Marquee here.
 * 
 * Kelly Rotstan and Darren Chu
 * 11//06/12
 */
public class Marquee
{
    private Canvas canvas;   
    private String text;
    private int speed;
    private int newTime;
    private int xPos;
    private int yPos;
    /**
     * Constructor for objects of class Marquee
     */
    public Marquee()
    {
        canvas = new Canvas("canvas");
    }

    /**
     * Takes input to set the text 
     */
    public void setText()
    {
        canvas.erase();
        text = JOptionPane.showInputDialog(null, "Please insert your text");
    }

    /**
     * Sets the initial position of the text  
     */
    public void setPosition(int x, int y)
    {
        canvas.erase();
        xPos = y;
        yPos = x;
        canvas.drawString(text, xPos, yPos);
    }

    /**
     * Set the font for displaying the text 
     */
    public void setFont(Font newFont)
    {
        canvas.erase();
        canvas.setFont(newFont);
    }

    /**
     * Sets the speed of scrolling
     */
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;    
    }

    /**
     * Scroll the text horizontally for the specified amount of time unit 
     */
    public void scrollHorizontal(int time)
    {
        for(int i = 0; i<time; i++)
        {
            canvas.erase();
            String newText = text;
            xPos = xPos + speed;
            canvas.drawString(text, xPos, yPos);
            canvas.drawString(newText, xPos-canvas.getWidth(), yPos);
            canvas.wait(10);
            if(xPos >= canvas.getWidth())
            {
                xPos = 0;
                canvas.drawString(text, xPos, yPos);
                canvas.drawString(newText, xPos-canvas.getWidth(), yPos);
                canvas.wait(10);
            }
        }
    }

    /**
     * Scroll the text vertically for the specified amount of time unit 
     */
    public void scrollVertical(int time)
    {
        for(int i = 0; i<time; i++)
        {
            canvas.erase();
            String newText = text;
            yPos = yPos + speed;
            canvas.drawString(text, xPos, yPos);
            canvas.drawString(newText, xPos, yPos-canvas.getHeight());
            canvas.wait(10);
            if(yPos >= canvas.getHeight())
            {
                yPos = 0;
                canvas.drawString(text, xPos, yPos);
                canvas.drawString(newText, xPos, yPos-canvas.getHeight());
                canvas.wait(10);
            }
        }
    }
}