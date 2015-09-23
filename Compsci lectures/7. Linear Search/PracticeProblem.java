/**
 * A PracticeProblem.
 */
public class PracticeProblem
{
    /**
     * Write a method called   allSame()    that takes in an array of ints as an argument, 
     * and returns whether every item in the array is the same (i.e., if the array is all 
     * 1s, all 2s, all 101s, etc.)
     */
    public boolean allSame(int[] ints)
    {
        for(int i = 1; i < ints.length; i++)
        {
            if(ints[i] != ints[0])
            {
                return false;
            }
        }
        return true;
    }
    
    
    
    
    
    
    
    
    


    public PracticeProblem()
    {
        int length = 7;
        int[] same = new int[length];
        int[] notSame = new int[length];
        int[] almostSame = new int[length];
        for(int i=0; i<length; i++)
        {
            same[i] = 7; //all sames are 7
            notSame[i] = i*2; //all notsames are mults of 2
            if(i < length-1) //if we're not tothe last guy yet
            {
                almostSame[i] = 7;
            }
            else
            {
                almostSame[i] = 6;
            }
            almostSame[0] = 6;
        }
        
        //print the arrays (for proof that they're filled)
        printIntArray(same);
        printIntArray(notSame);
        printIntArray(almostSame);

        System.out.println("same are all same? "+allSame(same));
        System.out.println("notSame are all same? "+allSame(notSame));
        System.out.println("almostSame are all same? "+allSame(almostSame));
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
