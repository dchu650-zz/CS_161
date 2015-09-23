import java.util.ArrayList;
/**
 * This defines ballcourt for balls to move around
 * 
 * @author Darren and Deron
 * @version 2011.07.27
 */

public class BallCourt
{
    public final static int XCORNER = 50;
    public final static int YCORNER = 50;
    public final static int WIDTH = 300;

    private Square inner; //the square of the ballcourt
    private Ball theBall;
    private ArrayList<Ball> ballList;
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
        ballList = new ArrayList <Ball>();

    }       

    /**
     * Moves the ball on the ballcourt and swaps the colors with another circle if the circle's color is different
     * and if the circles haven't previously touched before.
     * @param time number of times to move the balls
     */
    public void moveBalls(int time)
    {
        int t = 0; //loop control variable (lcv)
        while(t<time)  //test
        {   

            for (Ball ball1: ballList)// checks ball1 to all the balls in the list
            {
                ball1.move(); //move the balls
                for(Ball ball2: ballList) //checks other balls with all the other balls in the list
                {
                    if(ball1.isTouching(ball2)) //checks if the balls are touching or not
                    {
                        if(ball1 != ball2) //if the balls are not the same color then keep going
                        {
                            if(ball1.getBallTouched() != ball2) //if the balls haven't touched before then impliments
                                           //next steps.
                            {
                                String ball2Color = ball2.getColor(); //sets the color of the ball to local variable
                                String ball1Color = ball1.getColor(); //sets the color of the ball to local variable
                                ball1.setColor(ball2Color); //changes the balls color to the recevied ball's color
                                ball2.setColor(ball1Color); //changes the balls color to the recevied ball's color
                                ball2.setBallTouched(ball1); //set the balls as touched so the colors 
                                                            //don't continually swap colors. Only once
                                ball1.setBallTouched(ball2); //set the balls as touched so the colors 
                                                            //don't continually swap colors. Only Once
                            }
                        }
                    }
                }

                t=t+1; //update
            }
        }
    }

    /**
     * Add a new ball to the BallCourt
     */
    public void addBall()
    {
        ballList.add(new Ball());

    }
}
