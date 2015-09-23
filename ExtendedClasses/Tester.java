import java.util.Random;
/**
 * A class to test other classes
 * 
 * @author Kelly Rotstan and Darren Chu 
 * @version 11/13/2012
 */
public class Tester
{
    // instance variables 

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
    }

    /**
     * Main method to test all of our other classes
     */
    public static void main(String[] args) 
    {
        XArrayList<ComparableCircle> circle = new XArrayList<ComparableCircle>(); 
        XArrayList<ComparableSquare> square = new XArrayList<ComparableSquare>();
        Random randgen = new Random(10); // new random number generator
       
        for(int i = 0; i<3; i++)
        {
            ComparableCircle c = new ComparableCircle (); //new comparable circle
            c.setSize(randgen.nextInt(10)); //setting a random diameter for the circle
            circle.add(c); //add the circle to the list
        }
        
        for(int i = 0; i<3; i++)
        {
            ComparableSquare s = new ComparableSquare (); //new comparable circle
            s.setSize(randgen.nextInt(10)); //setting a random diameter for the circle
            square.add(s); //add the circle to the list
        }
       
        for(Circle myCircle : circle)
        {
            System.out.println("This is the circle diameter:" + " "+ myCircle.getSize()); //print out the circle list
        }
        
        for(Square mySquare : square)
        {
            System.out.println("This is the square size:" + " "+ mySquare.getSize()); //print out the square list
        }
        
        circle.findMaximum(); //find the maximum diameter for the circle
        square.findMaximum(); //find the maximum size for the square
       
        if(circle.containDuplicates() ==true)
        {
            System.out.println("There are duplicates of circles"); 
        }
       
        if(square.containDuplicates() ==true)
        {
            System.out.println("There are duplicates of squares");
        }
    }
}
