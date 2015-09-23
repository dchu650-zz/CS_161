/**
 * A Test.
 */
public class Test
{
    /**
     * Creates a new Test object.
     */
    public Test()
    {
        int[] numbers = new int[10];

        char[] word = "________".toCharArray(); //new char[6];
                
        String tempString = "";
        for(int i=0; i<word.length; i++)
        {
            tempString = tempString + word[i]+" ";
        }
        System.out.println(tempString);
        
//            System.out.println(word[i]);

        
        
        
        for(int i=0; i<numbers.length; i++)
        {
            numbers[i] = i+1;
        }
        
        for(int i=0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        
        for(Integer n : numbers)
        {
            System.out.println(n);
        }
        
    }



}
