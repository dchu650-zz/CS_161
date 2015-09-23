import javax.swing.*;

/**
 * This class runs a series of tests of the Rational class
 * 
 * @author Chuck Hommel 
 * @version 2/2/2008
 */
public class RationalTester
{
    private Rational r1;     // some rational numbers for testing
    private Rational r2;
    private Rational r3;
    private Rational r4;
    private Rational r5;   

    private Rational r6;    // for user input
    private Rational r7;

    /**
     * Constructor for objects of class RationalTester
     */
    public RationalTester()
    {
        // make some new Rationals for testing
        System.out.println("In Constructor ...");
        System.out.print("Creating new Rational 1/2...");
        r1 = new Rational(1, 2);    // 1/2
        System.out.println("result: " + r1.toString());
        System.out.print("Creating new Rational 3/2 ...");      
        r2 = new Rational(3, 2);    // 3/2
        System.out.println("result: " + r2.toString());
        System.out.print("Creating new Rational -4/5...");
        r3 = new Rational(-4, 5);   // -4/5
        System.out.println("result: " + r3.toString());
        System.out.print("Creating new Rational -4/5...");
        r4 = new Rational(7, -10);   // -7/10
        System.out.println("result: " + r4.toString());
        System.out.print("Creating new Rational (default constructor 0/1)...");
        r5 = new Rational();   // 
        System.out.println("result: " + r5.toString());

        System.out.println("Done.\n\n");
    }

    /**
     * 
     *  Addition test
     *  
     *  Tests the Rational class add(r) method
     * 
     */
    public void additionTest()
    {
        Rational result;       // result of addition

        System.out.println("Testing addition ...");
        System.out.print("Adding " + r2.toString() + " to " + r1.toString() + "...");
        result = r1.add(r2);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + r3.toString() + " to " + r2.toString() + "...");
        result = r2.add(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + r3.toString() + " to " + r1.toString() + "...");
        result = r1.add(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + r3.toString() + " to " + r4.toString() + "...");
        result = r4.add(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Adding " + r5.toString() + " to " + r4.toString() + "...");
        result = r4.add(r5);
        System.out.println("result: " + result.toString());

        System.out.println("Done.\n\n");
    }

    /**
     * 
     *  Multiplication test
     *  
     *  Tests the Rational class multiply(r) method
     * 
     */
    public void multiplicationTest()
    {
        Rational result;       // result of multiplication

        System.out.println("Testing multiplication ...");
        System.out.print("Multiplying " + r2.toString() + " by " + r1.toString() + "...");
        result = r1.multiply(r2);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + r3.toString() + " by " + r2.toString() + "...");
        result = r2.multiply(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + r3.toString() + " by " + r1.toString() + "...");
        result = r1.multiply(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + r3.toString() + " by " + r4.toString() + "...");
        result = r4.multiply(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Multiplying " + r5.toString() + " by " + r4.toString() + "...");
        result = r4.multiply(r5);
        System.out.println("result: " + result.toString());

        System.out.println("Done.\n\n");
    }    

    /**
     * 
     *  Division test
     *  
     *  Tests the Rational class divide(r) method
     * 
     */
    public void divisionTest()
    {
        Rational result;       // result of division

        System.out.println("Testing division ...");
        System.out.print("Dividing " + r2.toString() + " into " + r1.toString() + "...");
        result = r1.divide(r2);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }
        System.out.print("Dividing " + r3.toString() + " into " + r2.toString() + "...");
        result = r2.divide(r3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + r3.toString() + " into " + r1.toString() + "...");
        result = r1.divide(r3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + r3.toString() + " into " + r4.toString() + "...");
        result = r4.divide(r3);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        System.out.print("Dividing " + r5.toString() + " into " + r4.toString() + "...");
        result = r4.divide(r5);
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
     *  Tests the Rational class subtract(r) method
     * 
     */
    public void subtractionTest()
    {
        Rational result;       // result of subtraction

        System.out.println("Testing subtraction ...");
        System.out.print("Subtracting " + r2.toString() + " from " + r1.toString() + "...");
        result = r1.subtract(r2);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + r3.toString() + " from " + r2.toString() + "...");
        result = r2.subtract(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + r3.toString() + " from " + r1.toString() + "...");
        result = r1.subtract(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + r3.toString() + " from " + r4.toString() + "...");
        result = r4.subtract(r3);
        System.out.println("result: " + result.toString());

        System.out.print("Subtracting " + r5.toString() + " from " + r4.toString() + "...");
        result = r4.subtract(r5);
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
        Rational result;
        int compareResult;   // result of comparison

        System.out.println("Testing user input...");

        // get numerator and denominator for first Rational
        String numTemp = JOptionPane.showInputDialog("Enter a numerator for first rational: ");
        String denTemp = JOptionPane.showInputDialog("Enter a denominator for first rational: ");
        r6 = new Rational(Integer.parseInt(numTemp), Integer.parseInt(denTemp));
        System.out.println("Constructed " + r6.toString() + " from " + numTemp + " and " + denTemp);

        // get numerator and denominator for first Rational
        numTemp = JOptionPane.showInputDialog("Enter a numerator for second rational: ");
        denTemp = JOptionPane.showInputDialog("Enter a denominator for second rational: ");
        r7 =new Rational(Integer.parseInt(numTemp), Integer.parseInt(denTemp));
        System.out.println("Constructed " + r7.toString() + " from " + numTemp + " and " + denTemp);

        // run all tests
        System.out.print("Adding " + r6.toString() + " to " + r7.toString() + "...");
        result = r6.add(r7);
        System.out.println("result: " + result.toString());   

        System.out.print("Subtracting " + r7.toString() + " from " + r6.toString() + "...");
        result = r6.subtract(r7);
        System.out.println("result: " + result.toString());        System.out.println("Testing multiplication ...");

        System.out.print("Multiplying " + r6.toString() + " by " + r7.toString() + "...");
        result = r6.multiply(r7);
        System.out.println("result: " + result.toString());

        System.out.print("Dividing " + r7.toString() + " into " + r6.toString() + "...");
        result = r6.divide(r7);
        if (result != null)
        {
            System.out.println("result: " + result.toString());
        }
        else
        {
            System.out.println("result: null");   
        }

        //         compareResult = r6.compareTo(r7);
        //         System.out.print("compareTo() method reports... " + r6.toString());
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
        //         System.out.println(r7.toString());

        System.out.println("Done.\n\n");        

    }
}
