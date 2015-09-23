
/**
 * Comparing multiple circle objects
 * 
 * @author Kelly Rotstan and Darren Chu 
 * @version 11/13/2012
 */
public class ComparableCircle extends Circle implements Comparable<ComparableCircle> 
{
    // instance variables 

    /**
     * Constructor for objects of class ComparableCircle
     */
    public ComparableCircle()
    {
        super(); // call upon the super class
    }

    /**
     * Compares the diameters of two circle objects
     * @return  the diameter of the circles
     */
    public int compareTo(ComparableCircle circle2)
    {
        if(diameter == circle2.diameter) //if the diameter of this circle equals the diameter of the other circle
        {
            return 0; //return that they are equal
        }
        
        if(diameter < circle2.diameter) //if the diameter of this circle is less than the diameter of the other circle
        {
            return -1; //return that this circle is less than the other circle
        }
        
        if(diameter > circle2.diameter) //if the diameter of this circle is great than the diameter of the other circle
        {
            return 1; //return that this circle is greater than the other circle
        }
        
        return diameter;
    }

}
