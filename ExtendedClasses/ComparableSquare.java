
/**
 * Compares the size of multiple square objects
 * 
 * @author Kelly Rotstan and Darren Chu 
 * @version 11/13/2012
 */
public class ComparableSquare extends Square implements Comparable<ComparableSquare> 
{
    // instance variables 

    /**
     * Constructor for objects of class ComparableSquare
     */
    public ComparableSquare()
    {
        super(); // call upon the super class
    }

    /**
     * Comparing the size of two square objects
     * @return  size of the squares
     */
    public int compareTo(ComparableSquare square2)
    {
        if(size == square2.size) //if the diameter of this circle equals the diameter of the other circle
        {
            return 0; //return that they are equal
        }
        
        if(size < square2.size) //if the diameter of this circle is less than the diameter of the other circle
        {
            return -1; //return that this circle is less than the other circle
        }
        
        if(size > square2.size) //if the diameter of this circle is great than the diameter of the other circle
        {
            return 1; //return that this circle is greater than the other circle
        }
        
        return size;
    }

}