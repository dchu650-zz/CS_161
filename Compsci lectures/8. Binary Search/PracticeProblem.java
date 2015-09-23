import java.util.Random;

/**
 * A PracticeProblem.
 */
public class PracticeProblem
{
    /**
     * Write a method called   checksToFind()    that takes in an array of ints as an 
     * argument AND a target number as a argument. The method searches the array for the 
     * target, and _prints_ both whether it found the number and how many items the search looked 
     * at. (We don't need to return anything)
     */
    public void checksToFind(int[] ints, int target)
    {
        boolean found = false;
        for(int i = 0; i < ints.length; i ++)
        {
            if(ints[i] == target)
            {
                found = true;
                System.out.println("You found " + target + "! You looked at " + (i+1) + "things!");
            }
        }
        if(found == false)
        {
                System.out.println("You did not find " + target + "! You looked at " + ints.length + "things!");
        }
    }
            
    
    
    
    
    
    
    
    
    
    


    public PracticeProblem()
    {
        int[] a1 = randomNumberList(10);
        int[] a2 = randomNumberList(100);
        int[] a3 = randomNumberList(1000);
        int[] a4 = randomNumberList(10000);
        int[] a5 = randomNumberList(100000);
        int[] a6 = randomNumberList(1000000);
        
        checksToFind(a1,4);
        checksToFind(a2,42);
        checksToFind(a3,420);
        checksToFind(a4,4200);
        checksToFind(a5,42000);
        checksToFind(a6,420000);
    }

    
    /**
     * Makes an array of random numbers with the given size. Maximum value is 10*size
     */
    public int[] randomNumberList(int size)
    {
        Random gen = new Random();
        int[] nums = new int[size];
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = gen.nextInt(size*10);
        }
        return nums;
    }
        

       /**
     * Print the array of numbers (all on one line, comma separated)
     */
    public void printIntArray(int[] nums)
    {
        String toPrint = "["+nums[0];
        for(int i=1; i<nums.length; i++)
        {
            toPrint += ", "+nums[i];
        }
        toPrint += "]";
        System.out.println(toPrint);
    }

}
