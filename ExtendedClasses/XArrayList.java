import java.util.ArrayList;
/**
 * The XArrayList Class can be used to build a list of comparable objects from any class.
 * 
 * @author Kelly Rotstan and Darren Chu 
 * @version 11/13/2012
 */
public class XArrayList<E extends Comparable<E> > extends ArrayList<E> 
{
    // instance variables

    /**
     * Constructor for objects of class XArrayList
     */
    public XArrayList()
    {
        // initialise instance variables
        super(); //calling on the super class
    }

    /**
     * Finds and returns the index of the largest object  
     * @return  an int of the max index
     */
    int findMaximum()
    {
        int maxIndex = 0; //index of maximum
        for(int i = 0; i < size(); i++) //for the elements in the ArrayList
        {
            if(get(i).compareTo(get(maxIndex))>0) // if i is greater than the max Index
            {
                maxIndex = i; //set the max index to i
            }
        }
        System.out.println(maxIndex); //prints out the maximum index
        return maxIndex; //return the updated index of maximum
    }

    /**
     * Returns true if two or more elements in the list are equal and false, otherwise.  \
     * @return  boolean of whether the list contains duplicates
     */
    boolean containDuplicates()
    {
        for(int i = 0; i < size(); i++)  //for each element in the list i
        {
            for(int j = i; j < size(); j++) //for each element in the list j
            {
                if(get(i).compareTo(get(j))==0) //compare index at i to index at j
                {
                    return true; //if they are equal return true
                }
            }
        }
        return false;
    }
}
