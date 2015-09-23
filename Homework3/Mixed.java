
/**
 * Write a description of class Mixed here.
 * 
 * @author (Darren Chu) 
 * @version (September 17 2012)
 */
public class Mixed
{
    // instance variables - replace the example below with your own
    private int wholeNumber;
    private int numerator;
    private int denominator;

    /**
     * Create a new Mixed number with a form of 0 and 0/1.
     */
    public Mixed()
    {
        // initialise instance variables
        wholeNumber = 0;
        numerator = 0;
        denominator = 1;
    }

    /**
     * Create a new Mixed number of the form whole + numerator/denominator.
     */
    public Mixed(int newWholeNumber, int newNumerator, int newDenominator) 
    {
        wholeNumber = newWholeNumber;
        numerator = newNumerator;
        denominator = newDenominator;
    }
    
    /**
     * Returns the whole number part of the Mixed.
     */
    public int getWhole()
    {
        return wholeNumber;
    }
    
    /**
     * Returns the numerator part of the Mixed.
     */
    public int getNumerator()
    {
        return numerator;
    }
    
    /**
     * Returns the denominator part of the Mixed.
     */
    public int getDenominator()
    {
        return denominator;
    }
    
    /**
     * Converts mixed number into rational number.
     */
    public Rational toRational()
    {
        int newNum = wholeNumber*denominator + numerator;
        Rational rational1 = new Rational(newNum, denominator);
        return rational1;
    }
    
    /**
     * Adds another Mixed m and returns a new Mixed as the result.
     */
    public Mixed add(Mixed m)
    {
        Rational rational1 = toRational();
        Rational rational2 = m.toRational();
        Rational rationalTotal = rational1.add(rational2);
        Mixed mixed1 = rationalTotal.toMixed();
        return mixed1;
    }
    
    /**
     * Subtrats another Mixed m and returns a new Mixed as the result.
     */
    public Mixed subtract(Mixed m)
    {
        Rational rational1 = toRational();
        Rational rational2 = m.toRational();
        Rational rationalTotal = rational1.subtract(rational2);
        Mixed mixed1 = rationalTotal.toMixed();
        return mixed1;
    }
    
    /**
     * Multiplies another Mixed m and returns a new Mixed as the result.
     */
    public Mixed multiply(Mixed m)
    {
        Rational rational1 = toRational();
        Rational rational2 = m.toRational();
        Rational rationalTotal = rational1.multiply(rational2);
        Mixed mixed1 = rationalTotal.toMixed();
        return mixed1;
    }
    
    /**
     * Divide another Mixed m and returns a new Mixed as the result.
     */
    public Mixed divide(Mixed m)
    {
        Rational rational1 = toRational();
        Rational rational2 = m.toRational();
        Rational rationalTotal = rational1.divide(rational2);
        Mixed mixed1 = rationalTotal.toMixed();
        return mixed1;
    }
    
    /**
     * Sets the denominator of the mixed to the given value d
     */
    public void getDenominator(int d)
    {
        denominator = d;
    }
    
    /**
     * Sets the numerator of the mixed to the given value n.
     */
    public void setNumerator(int n)
    {
        numerator = n;
    }
    
    /**
     * Sets the whole of the mixed to the given value w.
     */
    public void setWhole(int w)
    {
        wholeNumber = w;
    }
    
    
    /**
     * Returns a String representation of the Mixed
     */
    public String toString()
    {
        return wholeNumber + numerator + "/" + denominator;
    }
}
