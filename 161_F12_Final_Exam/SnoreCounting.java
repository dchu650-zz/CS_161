
/**
 * A class to contain the snoreCount method.
 * Darren Chu
 */
public class SnoreCounting
{   
    private int snoreCounter;
    /**
     * 
     */
    public static void snoreCount(int num)
    {
        int snoreCounter = 0;
        for(int i = 0; i<num;i ++)
        {
            snoreCounter = snoreCounter + 1;
            if(snoreCounter % 3 == 0)
            {
                System.out.println("zzzz");
            }
            else if(snoreCounter % 5 == 0)
            {
                System.out.println("ZZZZ");
            }
            else if(snoreCounter % 5 == 0 && snoreCounter % 3 == 0)
            {
                System.out.println("zzzzZZZZ");
            }
            if(snoreCounter % 3 != 0 && snoreCounter % 5 !=0)
            {
                System.out.println(snoreCounter);
            }
        }
    }
}
