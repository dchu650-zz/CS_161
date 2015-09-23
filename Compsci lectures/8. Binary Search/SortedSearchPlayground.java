import java.util.Random;

/**
 * A class for playing with searching methods.
 */
public class SortedSearchPlayground
{
    private int[] nums; //the numbers for us to play with!
    Random gen = new Random();

    /**
     * Creates a new SearchPlayground object.
     */
    public SortedSearchPlayground()
    {
        nums = new int[16];
        nums[0] = gen.nextInt(10);
        for(int i=1; i<nums.length; i++)
        {
            nums[i] = nums[i-1] + gen.nextInt(10); //add 10 to the previous number
        }
    }

    /**
     * 
     */
    public boolean binarySearch(int target)
    {
        int startList = 0; //index
        int endList = nums.length; //index
        int checks = 0;
        while(endList - startList > 1)
        {
            int middleIndex = (startList+endList)/2;
            checks++;
            if(target < nums[middleIndex]) //am I smaller than the middle
            {
                endList = middleIndex; //move end to the middle
            }
            else //greater than or equal to the middle
            {
                startList = middleIndex; //move start to middle
            }
        }
        System.out.println("number of checks:" + checks);
        return (target == nums[startList]); //note that we're using startList because our "target==middle" case involves us moving the start
        
        
        
        
    }
    
    
    /**
     * Linear Search (from last time)
     */
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
