import java.util.Random;

/**
 * A Demos.
 */
public class Demos
{
    /**
     * Selection Sort the nums
     */
    public static void selectionSort()
    {
        int[] nums = fillNums(16);
        printNums(nums);
        
        for(int i=0; i<nums.length-1; i++) //go through list, but don't need to sort the last guy!
        {
            int smallestIndex = i; //call the current guy the smallest
            for(int j=i+1; j<nums.length; j++) //go through the rest of the list
            {
                if(nums[j] < nums[smallestIndex]) //see if anyone is smaller
                {
                    smallestIndex = j;
                }
            }
            //swap i and the smallest
            int temp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = temp;
        }
        
        printNums(nums);
    }

    /**
     * Insertion Sort the nums
     */
    public static void insertionSort()
    {
        int[] nums = fillNums(16);
        printNums(nums);
        
        for (int i=1; i<nums.length; i++) //for each item after the first
        {
            int toPlace = nums[i]; //the number we're trying to place
            int hole = i; //the spot we're going to check [an index]
            while (hole > 0 && nums[hole-1] > toPlace) //see if there is someone earlier than us
                                                       //and the guy before us is bigger
            {
                nums[hole] = nums[hole - 1]; //move the hole backward
                hole--; //count backwards
            }
            nums[hole] = toPlace;
        }

        printNums(nums);
    }
    
    /**
     * Fill the array of nums with something random
     */
    private static int[] fillNums(int size)
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
    private static void printNums(int[] nums)
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
