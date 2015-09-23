/**
 * A Calendar class
 */
public class Calendar
{
    /*
     * PRACTICE PROBLEM:
     * A leap year is a year with 366 days. A year is a leap year if it is divisible 
     * by 4 (for example, 1980). However, since the introduction of the Gregorian 
     * calendar on October 15, 1582, a year is not a leap year if it is divisible by 
     * 100 (for example, 1900). However, it is a leap year if it is divisible by 400 
     * (for example, 2000). 

     * Write a static method called isLeapYear that takes in a year and returns whether 
     * or not that year is a leap year.

     */
    /**
     * Practice problem goes here
     */
    public static boolean isLeapYear(int year)
    {
        boolean isLeap = false;
        if(year % 4 == 0)
        {
            isLeap = true;
            if(year > 1582) //optional?
            {
                if(year % 100 == 0)
                {
                    isLeap = false;
                    if(year % 400 == 0)
                    {
                        isLeap = true;
                    }
                }
            }
        }
        return isLeap;
        
        //along with numerous other ways to do this!
    }
    
    
    
    
    
    
    /**
     * Tests the practice problem
     */
    public static void TestIsLeapYear()
    {
        for(int i=1992; i<=2012; i++)
        {
            if(Calendar.isLeapYear(i) == true)
            {
                System.out.println(i+" is a leap year");
            }
        }
    }
}









