import java.lang.Object;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import javax.swing.JOptionPane;
/**
 * The man class. The main character whom the player controls.
 * 
 * @author (Andrew Graham && Darren Chu) 
 * @version (12/9/2012)
 */
public class Man implements KeyListener, ActionListener
{
    protected Timer timer; //Timer used to animate the Man's jump
    protected boolean isOnTunnel; //Boolean used to determine if the man is on the tunnel. If it's true, the player wins the game.
    protected int position; //The X Position of the man on the canvas
    protected int yPosition; //The Y Position of the mna on the canvas
    protected int previousPosition; //Used to get the man's position after a single animation. Used to reduce the number of artifacts the man leaves behind
    protected BufferedImage theMan; //Loads the jpeg image of the man
    protected boolean reachedMaxHeight; //Used to set a max height to mario's jump
    protected boolean isDead; //Used to see if mario is dead or alive
    protected BufferedImage theDeadMan; //Draws the Man's reversed image if he is dead
    protected int previousYPosition;  //Stores the man's previous Y position. Used to reduce artifacts left behind by the man.
    protected boolean isJumping; //Used to stop the man from jumping again while the jump animation is executing.
    /**
     * Constructor for objects of class RegularBlock
     */
    public Man()
    {
        isJumping = false;
        reachedMaxHeight = false;
        timer = new Timer(30, this);
        isDead=false;
        position = 100;
        yPosition = 480;
        previousPosition = position;
        previousYPosition = yPosition;
        theMan = ImageUtils.loadImage("SmallMan.jpg");
        theDeadMan = ImageUtils.loadImage("DeadMan.jpg");
    }
    
    /**
     * The timer used to animate the man's jump
     * 
     * @param ActionEvent e refers to the timer used to animate the man's jump
     */

    public void actionPerformed(ActionEvent e)
    {
        if(yPosition>=360 && reachedMaxHeight == false)
        {
            isJumping = true;
            previousYPosition=yPosition;
            yPosition=yPosition-7;            
        }
        if(yPosition <= 360)
        {
            reachedMaxHeight=true;
            yPosition= yPosition+7;
        }
        if(yPosition>=360 && reachedMaxHeight == true)
        {
            previousYPosition=yPosition;
            yPosition=yPosition+7;

        }  
        if(yPosition >= 480)
        {
            timer.stop();
            reachedMaxHeight = false;
            isJumping = false;
        }
        //timer.stop();
        //new Timer(100, *someactionlistenerobject*).start();
    }

    /**
     * Draw method for the man
     * @param A canvas
     */
    public void draw(Canvas canvas)
    {         
        if(isDead==false)
        {
            canvas.drawImage(theMan, position, yPosition);
        }
        if(isDead==true)
        {
            canvas.drawImage(theDeadMan, position, yPosition);
            JOptionPane.showMessageDialog(null,"You fell into the pit!");
        }
    }    

    /**
     * The Keylistener for Mario's movements
     * Allows Mario to move based on the arrow keys on the keyboard.
     * @param KeyEvent e refers to the pressing of a directional key
     */
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            previousPosition = position;
            position = position + 30;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            previousPosition = position;
            position = position - 30;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {                                    
            timer.start();
        }            
    }
    
    /**
     * Non-used method, required for KeyListener to operate
     */

    public void keyTyped(KeyEvent e)
    {        
    }
    
    /**
     * Non-used method, required for KeyListener to operate
     */
    public void keyReleased(KeyEvent e)
    {
    }
    
    /**
     * Draws the Man in the "victory position" once the game is won
     * 
     * @param the canvas he is drawn on
     */
    public void setWinPosition(Canvas canvas)
    {
        canvas.drawImage(theMan, 430 ,980);
    }
    
    /**
     * Method used to reduce the number of artifacts the man leaves behind
     * 
     * @param A canvas which the game is drawn on.
     */
    public void erase(Canvas canvas)
    {        
        Color oc = canvas.getForegroundColor();
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillRectangle(previousPosition-20,490,60,40);
        canvas.setForegroundColor(oc);
    }
    
    /**
     * Fills rectangles in positions where the man moves. This is the
     * primary source of artifact reduction in the game.
     * 
     * @param The canvas where the white rectangles are drawn to reduce artifacts.
     */
    
    public void jumpRedraw(Canvas canvas)
    {
        canvas.fillRectangle(previousPosition, previousYPosition, 60, 40);
        canvas.fillRectangle(previousPosition-5, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition-10,previousYPosition,61 ,41);
        canvas.fillRectangle(previousPosition-15, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-5, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-10, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-15, 61, 41);
        canvas.fillRectangle(previousPosition+5, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition+10, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition+15, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition+5, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition+10, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition+15, 61, 41);
        canvas.fillRectangle(previousPosition-5, previousYPosition-5, 61, 41);
        canvas.fillRectangle(previousPosition-10, previousYPosition-10, 61, 41);
        canvas.fillRectangle(previousPosition-15, previousYPosition-15, 61, 41);
        canvas.fillRectangle(previousPosition+5, previousYPosition+5, 61, 41);
        canvas.fillRectangle(previousPosition+10, previousYPosition+10, 61, 41);
        canvas.fillRectangle(previousPosition+15, previousYPosition+15, 61, 41);
        canvas.fillRectangle(previousPosition+20, previousYPosition-20, 61, 41);
        canvas.fillRectangle(previousPosition-25, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition-30, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition-35, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition+20, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition+25, previousYPosition, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-20, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-25, 61, 41);
        canvas.fillRectangle(previousPosition, previousYPosition-30, 61, 41); 
        canvas.fillRectangle(position,yPosition,60,40);
    }
}
