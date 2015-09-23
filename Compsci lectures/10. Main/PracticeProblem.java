import java.util.Random;

/**
 * A PracticeProblem.
 */
public class PracticeProblem
{
    /**
     * Write a method called   allDifferent()    that takes in an array of ints as an argument
     * and prints out (whether or not each item in the array is unique)
     */

    public void allDifferent(int[] nums)
    {
        boolean isUnique = true;
        for(int i=0; i<nums.length; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                if(i!=j && nums[i] == nums[j])
                {
                    isUnique = false;
                }                
            }
        }
        if(isUnique == true)
        {
            System.out.println("they're all unique");
        }
        else
        {
            System.out.println("they're not all unique");
        }
    }

    
        
    
    
    
    
    
    
    
    

    public PracticeProblem()
    {
        int[] oneToNine = new int[9];
        for(int i=0; i<oneToNine.length; i++)
        {
            oneToNine[i] = i+1;
        }

        int[] randNums = new int[10];
        Random gen = new Random();
        for(int i=0; i<randNums.length; i++)
        {
            randNums[i] = gen.nextInt(50);
        }

        printNums(oneToNine);
        allDifferent(oneToNine);
        printNums(randNums);
        allDifferent(randNums);
    }

    /**
     * Print the array of numbers (all on one line, comma separated)
     */
    public void printNums(int[] nums)
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
