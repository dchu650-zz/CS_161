import javax.swing.*;

/**
 * This class runs a series of tests of the Mixed class
 * 
 * @author Chuck Hommel, adapted by Joel Ross
 * @version 2/2/2008
 */
public class MixedTester
{
    private Mixed m1;     // some Mixed numbers for testing
    private Mixed m2;
    private Mixed m3;
    private Mixed m4;
    private Mixed m5;   

    private Mixed m6;    // for user input
    private Mixed m7;

    /**
     * Constructor for objects of class MixedTester
     */
    public MixedTester()
    {
        // make some new Mixeds for testing
        System.out.println("In Constructor ...");
        System.out.print("Creating new Mixed 1 1/2...");
        m1 = new Mixed(1, 1, 2);    // 1 1/2
        System.out.println("result: " + m1.toString());
        System.out.print("Creating new Mixed 0 2/3 ...");      
        m2 = new Mixed(0, 2, 3);    // 0 2/3
        System.out.println("result: " + m2.toString());
        System.out.print("Creating new Mixed -8 4/5...");
        m3 = new Mixed(-8, 4, 5);   // -8 4/5
        System.out.println("result: " + m3.toString());
        System.out.print("Creating new Mixed 8 4/5...");
        m4 = new Mixed(8, 4, 5);   // 8 4/5
        System.out.println("result: " + m4.toString());
        System.out.print("Creating new Mixed (default constructor 0 0/1)...");
        m5 = new Mixed();   // 
        System.out.println("result: " + m5.toString());

        System.out.println("Done.\n\n");
    }

    /**
     * 
     *  Addition test
     *  
     *  Tests the Mixed class add(r) method
     * 
     */
    public void additionTest()
    {
        Mixed result;       // result of addition

        System.out.println("Testing addition ...");
        System.out.print("Adding " + m2.toString() + " to " + m1.toString() + "...");
        result = m1.add(m2);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + m3.toString() + " to " + m2.toString() + "...");
        result = m2.add(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + m3.toString() + " to " + m1.toString() + "...");
        result = m1.add(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + m3.toString() + " to " + m4.toString() + "...");
        result = m4.add(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + m5.toString() + " to " + m4.toString() + "...");
        result = m4.add(m5);
        System.out.println("result: " + result.toString());

        System.out.println("Done.\n\n");
    }

    /**
     * 
     *  Multiplication test
     *  
     *  Tests the Mixed class multiply(r) method
     * 
     */
    public void multiplicationTest()
    {
        Mixed result;       // result of multiplication

        System.out.println("Testing multiplication ...");
        System.out.print("Multiplying " + m2.toString() + " by " + m1.toString() + "...");
        result = m1.multiply(m2);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + m3.toString() + " by " + m2.toString() + "...");
        result = m2.multiply(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + m3.toString() + " by " + m1.toString() + "...");
        result = m1.multiply(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + m3.toString() + " by " + m4.toString() + "...");
        result = m4.multiply(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + m5.toString() + " by " + m4.toString() + "...");
        result = m4.multiply(m5);
        System.out.println("result: " + result.toString());

        System.out.println("Done.\n\n");
    }    

    /**
     * 
     *  Division test
     *  
     *  Tests the Mixed class divide(r) method
     * 
     */
    public void divisionTest()
    {
        Mixed result;       // result of division

        System.out.println("Testing division ...");
        System.out.print("Dividing " + m2.toString() + " into " + m1.toString() + "...");
        result = m1.divide(m2);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }
        System.out.print("Dividing " + m3.toString() + " into " + m2.toString() + "...");
        result = m2.divide(m3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + m3.toString() + " into " + m1.toString() + "...");
        result = m1.divide(m3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + m3.toString() + " into " + m4.toString() + "...");
        result = m4.divide(m3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + m5.toString() + " into " + m4.toString() + "...");
        result = m4.divide(m5);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.println("Done.\n\n");
    }  

    /**
     * 
     *  Subtraction test
     *  
     *  Tests the Mixed class subtract(r) method
     * 
     */
    public void subtractionTest()
    {
        Mixed result;       // result of subtraction

        System.out.println("Testing subtraction ...");
        System.out.print("Subtracting " + m2.toString() + " from " + m1.toString() + "...");
        result = m1.subtract(m2);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + m3.toString() + " from " + m2.toString() + "...");
        result = m2.subtract(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + m3.toString() + " from " + m1.toString() + "...");
        result = m1.subtract(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + m3.toString() + " from " + m4.toString() + "...");
        result = m4.subtract(m3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + m5.toString() + " from " + m4.toString() + "...");
        result = m4.subtract(m5);
        System.out.println("result: " + result.toString());

        System.out.println("Done.\n\n");
    }  


    /**
     *   Runs all tests sequentially
     */
    public void runAllTests()
    {
        additionTest();
        subtractionTest();
        multiplicationTest();
        divisionTest();
        //compareToTest();

    }

    /**
     *  Gets user input for individual test
     *  
     */
    public void testUserInput()
    {
        Mixed result;
        int compareResult;   // result of comparison

        System.out.println("Testing user input...");

        // get numerator and denominator for first Mixed
        String wholeTemp = JOptionPane.showInputDialog("Enter a whole part for first Mixed: ");
        String numTemp = JOptionPane.showInputDialog("Enter a numerator for first Mixed: ");
        String denTemp = JOptionPane.showInputDialog("Enter a denominator for first Mixed: ");
        m6 = new Mixed(Integer.parseInt(wholeTemp), Integer.parseInt(numTemp), Integer.parseInt(denTemp));
        System.out.println("Constructed " + m6.toString() + " from " + wholeTemp + "and " + numTemp + " and " + denTemp);

        // get numerator and denominator for first Mixed
        wholeTemp = JOptionPane.showInputDialog("Enter a whole part for second Mixed: ");
        numTemp = JOptionPane.showInputDialog("Enter a numerator for second Mixed: ");
        denTemp = JOptionPane.showInputDialog("Enter a denominator for second Mixed: ");
        m7 =new Mixed(Integer.parseInt(wholeTemp), Integer.parseInt(numTemp), Integer.parseInt(denTemp));
        System.out.println("Constructed " + m7.toString() + " from " + wholeTemp + "and " + numTemp + " and " + denTemp);

        // run all tests
        System.out.print("Adding " + m6.toString() + " to " + m7.toString() + "...");
        result = m6.add(m7);
        System.out.println("result: " + result.toString());   

        System.out.print("Subtracting " + m7.toString() + " from " + m6.toString() + "...");
        result = m6.subtract(m7);
        System.out.println("result: " + result.toString());        System.out.println("Testing multiplication ...");

        System.out.print("Multiplying " + m6.toString() + " by " + m7.toString() + "...");
        result = m6.multiply(m7);
        System.out.println("result: " + result.toString());

        System.out.print("Dividing " + m7.toString() + " into " + m6.toString() + "...");
        result = m6.divide(m7);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        //         compareResult = m6.compareTo(m7);
        //         System.out.print("compareTo() method reports... " + m6.toString());
        //         if (compareResult == -1)
        //         {
        //             System.out.print( " < ");
        //         }
        //         else if (compareResult == 0)
        //         {
        //           System.out.print( " = ");
        //         }
        //         else if (compareResult == 1)
        //         {
        //           System.out.print( " > ");
        //         }
        //         else
        //         {             
        //           System.out.print( " undecipherable code: " + result + " ");  
        //         }
        //         System.out.println(m7.toString());

        System.out.println("Done.\n\n");        

    }
}
