
/**
 * Write a description of class Rational here.
 * 
 * @author (Darren Chu) 
 * @version (September 17 2012)
 */
public class Rational
{
    // instance variables - replace the example below with your own

    private int numerator;
    private int denominator;
    /**
     * Create a new Rational of the form 0/1
     */
    public Rational()
    {
        numerator = 0;
        denominator = 1;
    }

    /**
     * Create a new Rational of the form numerator/denominator.
     */
    public Rational(int newNumerator, int newDenominator)
    {
        numerator = newNumerator;
        denominator = newDenominator;
    }

    /**
     *  Adds another Rational r and returns a new Rational as the result.
     */
    public Rational add(Rational r)
    {
        int comDenom = denominator * r.getDenominator();
        int newNum = numerator * r.getDenominator() + r.getNumerator() * denominator;
        Rational rational = new Rational(newNum, comDenom);
        return rational;
    }

    /**
     * Subtracts another Rational r and returns a new Rational as the result.
     */
    public Rational subtract(Rational r)
    {
        int comDenom = denominator * r.getDenominator();
        int newNum = numerator * r.getDenominator() - r.getNumerator() * denominator;
        Rational rational = new Rational(newNum, comDenom);
        return rational;
    }

    /**
     * Multiplies by another Rational r and returns a new Rational as the result.
     */
    public Rational multiply(Rational r)
    {
        int comDenom = denominator * r.getDenominator();
        int newNum = numerator * r.getNumerator();
        Rational rational = new Rational(newNum, comDenom);
        return rational;
    }

    /**
     * Divides by another Rational r and returns a new Rational as the result.
     */
    public Rational divide(Rational r)
    {
        int comDenom = denominator * r.getNumerator();
        int newNum = numerator * r.getDenominator();
        Rational rational = new Rational(newNum, comDenom);
        return rational;   
    }
    
 
    /**
     * Returns the denominator of the Rational.
     */
    public int getDenominator()
    {
        return denominator;
    }

    /**
     * Returns the numerator of the Rational.
     */
    public int getNumerator()
    {
        return numerator;
    }

    /**
     * Sets the denominator of the Rational to the given value d.
     */
    public void setDenominator(int d)
    {
        denominator = d;
    }

    /**
     * Sets the numerator of the Rational to the given value n.
     */
    public void setNumerator(int n)
    {
        numerator = n;
    }
    
     /**
     * Returns a Mixed number form of the Rational
     */
    public Mixed toMixed()
    {
        {
           int wholeNumber = numerator/denominator;
           int newNum = numerator%denominator;
           Mixed mixed = new Mixed(wholeNumber, newNum, denominator);
           return mixed;
        }
    }
    
    /**
     * Returns a String representation of the Rational
     */
    public String toString()
    {
        return numerator + "/" + denominator;
    }
}
