import javax.swing.JOptionPane;
/**
 * A class to test the Pig Latin Generator
 * 
 * @author Abu Zafar Shahriar 
 * @version 09/21/2012
 */
public class PigLatinTester
{
    PigLatinGenerator generator;
    /**
     * Constructor for objects of class PigLatinTester
     */
    public PigLatinTester()
    {
        generator = new PigLatinGenerator();
    }

    /**
     * A method to test the generator
     * 
     */
    public void test()
    {
        String input =  JOptionPane.showInputDialog("Enter a text:");
        String output = generator.generatePigLatinText(input);
        JOptionPane.showMessageDialog(null,"Input text:" + input + "\nPig Latin: " + output);
    }
}
