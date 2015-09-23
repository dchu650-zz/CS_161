import java.lang.Object;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 * Mario Land
 * Darren Chu & Andrew Graham
 * 11/20/12
 */
public class PlatformMan
{
    private Canvas canvas; //The canvas in which the game is played.
    protected boolean newGame; //Used for indiating whether or not the program will reset the variables and start a new game.
    private BlockExclaimationMark exMark; //Creates an instance of the block which hits to get a mushroom.
    private Goomba theGoomba; //Creates an instance of the goomba which platform man must avoid.
    private RegularBlock theBlock; //Creates an instance of the Blocks which platform man walks on.
    private Man theMan; //Creates an instance of platform man.
    private Cloudman theCloudman; // Creates an instance of the Cloudman(purely aesthetic!)
    private Tunnel theTunnel; //Creates an instance of the tunnel platform man must get to to win.
    private Color color; //Used to set the foreground color of the canvas to white.
    private Gap theGap; //Creates an instance of the spike pit which platform man must jump over.
    private Shroom theShroom; // Creates an instance of the shroom that platform man must get to win. 
    public static final int LENGTH = 1000; //Setting the length of the MarioLand
    public static final int HEIGHT = 1000; //Setting the height of the MarioLand
    /**
     * Constructor for objects of class MarioLand
     */
    public PlatformMan() 
    {
        newGame = false;
        exMark = new BlockExclaimationMark();
        theGoomba = new Goomba();
        theBlock = new RegularBlock();
        theMan = new Man();
        theCloudman = new Cloudman();
        theTunnel = new Tunnel();
        theGap = new Gap();     
        theShroom = new Shroom();
        canvas = new Canvas("The Canvas", LENGTH, HEIGHT); // initialise a new Canvas at the set length and width
        (canvas.getCanvas()).addKeyListener(theMan); //adds a key listener for the man
        (canvas.getCanvas()).setFocusable(true); 
        canvas.setForegroundColor(color.WHITE); 
        this.drawObjects();
        animate(100000);
    }

    /**
     * The animation method moves all of the objects on the canvas.
     * It is responisble for managing object interation, explaining
     * the rules of the game to the player, providing a win condition,
     * and managing the canvas so that the animation runs as smoothly
     * as possible.
     * @param The number of times the animation method is invoked
     */
    public void animate(int turns)
    {
        JOptionPane.showMessageDialog(null, "Welcome to platform man! Don't fall in the spike pit or touch the Moomba!");
        JOptionPane.showMessageDialog(null, "Press up key to jump, the left and right keys to move side to side.To win, you must get the shroom and then make it to the tunnel. Good luck!");
        for(int i = 0; i<turns; i++)
        {            
            if(theMan.isJumping == true) //Animation condition which is used to reduce artifacts when platform man is jumping
            {
                theMan.erase(canvas);
                theMan.jumpRedraw(canvas);
                theMan.draw(canvas);
            }

            canvas.fillRectangle(theMan.previousPosition, theMan.previousYPosition-30, 61, 41); 
            canvas.fillRectangle(theMan.position, theMan.yPosition,60,40);

            if(theMan.position >= theTunnel.position-20 && theMan.position<=theTunnel.position+20 && theMan.yPosition >= theTunnel.yPosition && theShroom.onShrooms == true) //Conditional used if mario has gotten the mushroom and is at the tunnel. If he has done these, the game is over
            {
                theMan.yPosition=theTunnel.yPosition+430;
                JOptionPane.showMessageDialog(null, "You've Won the Game!");
            }

            if(theMan.position >= 200 && theMan.position <=300 && theMan.yPosition == 480) //Conditional statement used to kill platform man if he is over the spike pit
            { 
                theMan.yPosition = 540;
                theMan.isDead = true;
            }

            if(theMan.position <= theGoomba.position + 20 && theMan.position >= theGoomba.position - 20 && theMan.yPosition <= 480 && theMan.yPosition >=440) //conditional statement used to kill platform man if he is touched by the goomba
            {
                theMan.isDead = true;
                JOptionPane.showMessageDialog(null,"You died by goomba disease. Sucks.");
            }

            if(theMan.yPosition >= exMark.yPosition + 60 && theMan.yPosition <= exMark.yPosition + 100 && theMan.position >= 490 && theMan.position <=510 && theShroom.noMoreShrooms == false)
            {
                theShroom.draw(canvas);       
            }

            if(theMan.position <= theShroom.position + 30 && theMan.position >= theShroom.position -30)
            {
                theShroom.erase(canvas);
                theShroom.onShrooms = true;
                theShroom.noMoreShrooms = true;         
            }

            if(theMan.position >= 930 && theMan.yPosition >=430)
            {
                theMan.yPosition = 430;
                theMan.isOnTunnel = true;
            }
            else
            {
                theMan.isOnTunnel = false;
            }

            if(theMan.isDead == true)
            {                
                JOptionPane.showMessageDialog(null,"The Game is Over. You lose. Sorry!");
                newGame = true; 
                theMan.isDead = false;
                canvas.erase();
                resetGame();
                return;
            }

            if(theShroom.onShrooms == true && theMan.isOnTunnel == true)
            {
                theMan.setWinPosition(canvas);
                JOptionPane.showMessageDialog(null, "You've Won The Game!");
                canvas.erase();
                resetGame();
                return;
            }
            theGoomba.erase(canvas);
            theMan.erase(canvas);
            theCloudman.drive();
            theGoomba.drive();
            drawObjects(); // calls the redraw method to redraw all of objects
            canvas.wait(10); // sets the speed
        }
    }

    /**
     * Draws each of the objects in the game on the canvas
     */
    public void drawObjects()
    {
        theMan.draw(canvas);
        exMark.draw(canvas);
        theGoomba.draw(canvas);
        theBlock.draw(canvas);
        theCloudman.draw(canvas);
        theTunnel.draw(canvas);
        theGap.draw(canvas);
    }

    /**
     * Resets all the variables to their default values. Used when reseting the game after
     * defeat or victory
     */
    private void resetGame()
    {
        theMan.isJumping = false;
        theMan.isOnTunnel = false;
        theMan.isDead=false;
        theMan.position = 100;
        theMan.yPosition = 480;
        theGoomba.position = 700;
        theGoomba.yPosition = 500;
        theCloudman.position = 0;
        theCloudman.yPosition = 0;  
        theGap.position = 200;   
        theGap.yPosition = 500;
        theBlock.position = 0;
        theBlock.yPosition = 300;
        theShroom.onShrooms = false;         
        theShroom.noMoreShrooms = false;
        this.animate(100000);
    }
}
