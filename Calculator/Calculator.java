
/**
 * Calculator will model a basic calculator that can calculate basic math
 * such as addition, subtraction, multiplication, and division. 
 * Also converts inches to centimeters. 
 * 
 * @author (Darren Chu) 
 * @version (September 4th)
 */
public class Calculator
{
    
    private int memory; // accumulator for integer calculations
    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
        memory = 0;
    }
    
    /**
     * adds a value to the memory
     * @param x the value to add to the memory
     */
    public void addInt(int x)
    {
        memory = memory + x;
    }
    
    /**
     * subtracts a value to the memory
     * @param x the value to subtract to the memory
     */
    public void subtractInt(int x)
    {
        memory = memory - x;
    }
    
    /**
     * multiplys a value to the memory
     * @param x the value to multiply to the memory
     */
    public void multiplyInt(int x)
    {
        memory = memory * x;
    }
    
    /**
     * divides a value to the memory
     * @param x the value to divide to the memory
     */
    public void divideInt(int x)
    {
        memory = memory / x;
    }
    
    
    /**
     * clear the memory
     */
    public void clearMemory()
    {
        memory = 0;
    }
    
    /**
     * Adds two real numbers together.
     */
    public double getSum(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"+"+y);
        System.out.println("="+(x+y));
        return x + y;
    }
    
    /**
     * Adds two real numbers together with a decoration.
     */
    public void decorativeAdd(double x,double y)
    {
        // put your code here
        System.out.println("~`~`~`~`~`~`");
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"+"+y);
        System.out.println("="+(x+y));
        System.out.println("~`~`~`~`~`~`");
    }
    
    /**
     * Converts inches to centimeters.
     */
    public void convertToCentimeters(double inch)
    {
        // put your code here
        System.out.println(inch);
        System.out.println(inch+"x"+2.54);
        System.out.println((inch)+" inch "+" = "+((inch*2.54))+" centimeters ");
    }
    
    /**
     * Computes two percentages together.
     */
    public void findPercentage(double quantity,double percentage)
    {
        // put your code here
        double thePercentage = percentage / 100.0;
        System.out.println(quantity);
        System.out.println(percentage/100);
        System.out.println(quantity+"*"+(percentage/100));
        System.out.println((percentage)+" percent of "+(quantity)+" = "+(quantity*thePercentage));
    }
    
    /**
     * Add two percentages together.
     */
    public void addPercentage(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"%"+"+"+y+"%");
        System.out.println("="+(x+y)+"%");
    }
    
    /**
     * Divide two real numbers together.
     */
    public void divideInts(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"/"+y);
        System.out.println("="+(x/y));
    }
    
    /**
     * Divide two whole numbers together.
     */
    public void divideInts(int x,int y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"/"+y);
        System.out.println("="+(x/y));
    }
    
    /**
     * Multiply two whole numbers together.
     */
    public void multiplyInts(int x,int y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"*"+y);
        System.out.println("="+(x*y));
    }
    
    /**
     * Multiply two real numbers together.
     */
    public void multiplyInts(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"*"+y);
        System.out.println("="+(x*y));
    }
    
    /**
     * Subtract two whole numbers together.
     */
    public void subtractInts(int x,int y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"-"+y);
        System.out.println("="+(x-y));
    }
    
    /**
     * Subtract two real numbers together.
     */
    public void subtractInts(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"-"+y);
        System.out.println("="+(x-y));
    }
    
    /**
     * Adds two real numbers together.
     */
    public void addInts(double x,double y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"+"+y);
        System.out.println("="+(x+y));
    }
    
    /**
     * Adds two whole numbers together.
     */
    public void addInts(int x,int y)
    {
        // put your code here
        System.out.println(x);
        System.out.println(y);
        System.out.println(x+"+"+y);
        System.out.println("="+(x+y));
    }
}
