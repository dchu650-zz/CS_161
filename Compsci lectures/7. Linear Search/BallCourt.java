
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


    /**
     * Constructor for objects of class Ballcourt
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
    }       
}
