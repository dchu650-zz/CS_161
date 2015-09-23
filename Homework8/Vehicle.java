/**
 * A parent abstract archetype class for the vehicles
 * 
 * @author Darren Chu
 * @version 11/11/12
 */
public abstract class Vehicle
{
    protected int position; // a position field
    protected int speed; // a speed field 
    protected boolean facingRight; // a field stating which way the vehicle is facing

    /**
     * Draws the vehicles however, method is empty 
     * @param A canvas upon which the vehicles are drawn
     */
    protected void draw(Canvas canvas)
    {

    }

    /**
     * Moves the vehicles based on their positions
     */
    public void drive()
    {
        speed = 2; // sets the speed
        if(facingRight==true)  // a field stating which way the vehicle is facing
        {
            position = position + speed; // moves the vehicle towards the right
            turn(); //calls the turn method
        }
        else
        {
            position = position - speed; //moves the vehicle towards the left
            turn(); //calls the turn method
        }
    }

    /**
     * Turns the vehicles
     */
    public void turn()
    {
        if(position >= LongRoad.LENGTH) //if the car is all the way on the right side of the road   
        {
            facingRight = false; //turns the car to the left
        }
        if(position <= 0) //if the carr is all the way on the left side of the road 
        {
            facingRight = true; //turns the car to the right
        }
    }
}
