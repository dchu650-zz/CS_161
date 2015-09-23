import java.util.Random;

/**
 * A SortingPlayground.
 */
public class SortingPlayground
{
    private int[] nums;
    private Random gen = new Random();

    /**
     * Creates a new SortingPlayground object.
     */
    public SortingPlayground()
    {
        fillNums(16);
        printNums();
        sort();
        printNums();

        fillNums(32);
        sort();
        fillNums(64);
        sort();
        fillNums(128);
        sort();
        fillNums(256);
        sort();

        
    }

    
    /**
     * A method we wrote in class that uses BubbleSort to sort the array
     */
    public void sort()
    {
        //nums is our array
        int swaps = 0;
        int comparisons = 0;
        for(int j=0; j<nums.length; j++)
        {
            for(int i=0; i<nums.length; i++)
            {
                comparisons++;
                if(nums[j] < nums[i])
                {
                    //swap
                    swaps++;
                    int a = nums[j];
                    int b = nums[i];
                    nums[j] = b;
                    nums[i] = a;
                }

            }
        }
        System.out.println("swaps "+swaps+", comps: "+comparisons);
    }
    
    
    /**
     * Fill the array of nums with something random
     */
    public void fillNums(int size)
    {
        nums = new int[size];
        for(int i=0; i<nums.length; i++)
        {
            nums[i] = gen.nextInt(size*10);
        }
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
