/**
 * Write a description of class PigLatinGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PigLatinGenerator
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PigLatinGenerator
     */
    public PigLatinGenerator()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean isVowel(char letter)
    {
        boolean isVowel = false;
        String vowels = "AEIOUaeiou"; // create a string type object first
        int index = vowels.indexOf(letter); // index will be 5
        if(index > -1)
        {
            isVowel = true;
            return isVowel;
        }
        return isVowel;
    }

    /**
     * 
     */
    public String generatePigLatinWord(String word)
    {
        char charLetter1 = word.charAt(0); //gets the first letter of word through index.
        if(isVowel(charLetter1)==false)
        {
            String subword = word.substring(1); //gives the word without first index.
            boolean result = Character.isLetter(charLetter1);//determines if the first character is a letter or not.
            if(Character.isLetter(charLetter1)==false)
            {
                return word;
            }
            else
            {
                String firstLetter = Character.toString(charLetter1); //
                String newWord = subword + firstLetter; //creates word where the first letter is at the end of the word.
                return newWord + "ay";
            }
        }

        else
        {
            String subword = word.substring(1); //gives the word without first index.
            boolean result = Character.isLetter(charLetter1);//determines if the first character is a letter or not.
            String firstLetter = Character.toString(charLetter1); //
            String newWord = firstLetter + subword; //creates word where the first letter is at the end of the word.
            return newWord + "way";
        }
    }

    /**
     * 
     */
    public String generatePigLatinText(String text)
    {
        int beginIndex = 0;
        int index = 0;
        String finalText = new String();
        while(index > -1)
        {
            index = text.indexOf(' ',beginIndex);
            String word;
            if(index != -1)
            {
                word = text.substring(beginIndex,index);
            }
            else
            {
                word = text.substring(beginIndex);
            }
            String word1 = generatePigLatinWord(word);
            finalText = finalText + " " + word1;
            beginIndex = index+1;
        }
        return finalText;
    }
}
