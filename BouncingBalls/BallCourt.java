
/**
 * This defines ballcourt for balls to move around
 * 
 * @author Chuck Hommel
 * @version 2011.07.27
 */
public class BallCourt
{
   public final static int XCORNER = 50;
   public final static int YCORNER = 50;
   public final static int WIDTH = 300;
  
   private Square inner; //the square of the ballcourt

   private Ball theBall;
    /**
     * Constructor for objects of class BallCourt
     */
    public BallCourt()
    { 
        //defines the square of the ballcourt
        inner = new Square();
        inner.changeColor("lightGray");
        inner.moveHorizontal(XCORNER);
        inner.moveVertical(YCORNER);
        inner.changeSize(WIDTH);
        inner.makeVisible();   
        theBall = new Ball();
    }       
    
    /**
     * 
     */
    public void addBall()
    {
        
    }
    
    /**
     * Moves the ball on the ballcourt
     * @param time number of times to move the balls
     */
    public void moveBalls(int time)
    {
        int t = 0; //loop control variable (lcv)
        while(t<time)  //test
        {
            theBall.move();
            t=t+1; //update
        }
    }
}
