import java.util.Random;

/**
 * A class for playing with searching methods.
 */
public class SearchPlayground
{
    private int[] nums; //the numbers for us to play with!
    Random gen = new Random();

    //making constants, for fun
    public static final double PI = 3.1415926535;
    public static final double GRAVITATIONAL_CONSTANT = 9.8;
    
    /**
     * Creates a new SearchPlayground object.
     */
    public SearchPlayground()
    {
        nums = new int[16];
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = gen.nextInt(1000);
        }
    }

    public boolean inList(int n)
    {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == n)
            {
                return true;
            }            
        }
        return false;
    }
    
    public int largest()
    {
        int biggest = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > biggest) //beat the king
            {
                biggest = nums[i]; //become the king
            }
        }
        return biggest; //return the king        
    }

    public int smallest()
    {
        int smallest = Integer.MAX_VALUE; //really big number
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] < smallest) //beat the king
            {
                smallest = nums[i]; //become the king
            }
        }
        return smallest; //return the king        
    }
        
    public int secondSmallest()
    {
        int smallest = Integer.MAX_VALUE; //really big number
        int second = smallest;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] < smallest) //beat the king
            {
                second = smallest; //we need to move the previous smallest into the second-place slot!
                smallest = nums[i]; //become the king
            }

            if(nums[i] > smallest && nums[i] < second)
            {
                second = nums[i];
            }
        }
        return second; //return the king        
        
        
    }
    
    
    
    
    
    /**
     * Print the array of numbers (all on one line, comma separated)
     */
    public void printNums()
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
