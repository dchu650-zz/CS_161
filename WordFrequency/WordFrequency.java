import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * Write a description of class WordFrequency here.
 * 
 * @author Darren Chu & Graham Cameron
 * @version 10/9/12
 */
public class WordFrequency
{
    private HashMap<String, Integer> wordTable;
    private StringTokenizer tokens;
    private ArrayList<String> testArray;
    private String delimiters;
    /**
     *Constructor for objects of class WordFrequency
     */
    public WordFrequency()
    {
    }

    /**
     *  Builds a hashmap of words from lines of text. 
     *  This method must be invoked before any other methods in this class can be invoked.
     *  @param lines lines of text 
     */
    public void buildWordFrequencyList(ArrayList<String> lines) 
    {
        wordTable = new HashMap<String,Integer>();
        wordTable.clear();
        delimiters = ",.;!? ";
        //garbage
        for(String s : lines)
        {
            tokens = new StringTokenizer(s, delimiters);
            while(tokens.hasMoreTokens())
            {
                String word = tokens.nextToken();
                
                if(wordTable.get(word) != null)
                {
                     int frequency = wordTable.get(word);
                     frequency = frequency + 1;
                     wordTable.put(word, frequency);
                }
                else
                {
                    int frequency = 1; 
                    wordTable.put(word, frequency);
                }
            }

        }
        
        
    }

    /**
     * Find the maximum frequency in the hashmap
     * @return the maximum frequency
     */
    public int findMaximumFrequency()
    {
        int max = 0;
        for (String s : wordTable.keySet()) 
        {
            if(wordTable.get(s) > max)
            {
                max = wordTable.get(s);
            }
        }
        return max;
    }

    /**
     * Return a list of words having the maximum frquency
     * @return a list of words having maximum frequency
     */
    public ArrayList<String> findMaximumFrequencyWords()
    {
        ArrayList<String> maxFrequencyWords = new ArrayList<String>();
        int max = findMaximumFrequency();
        for (String s : wordTable.keySet())
        {
            if(wordTable.get(s)==max)
            {
                maxFrequencyWords.add(s);
            }
        }
        return maxFrequencyWords;
    }

    /**
     * Find the frequency of a paritcular word in the hashmap
     * @param word word in the hashmap
     * @return the frequency of the word
     */
    public int findWordFrequency(String word) 
    {
        if(wordTable.get(word) != null)
        {
            int frequency = wordTable.get(word);
            return frequency;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Return a list of words having a given frequency or more
     * @param minimum list of words at a given frequency or more
     * @return a list of words
     */
    public ArrayList<String> findWords(int minimum)
    {
        ArrayList <String> findWords = new ArrayList <String> ();
        for(String s : wordTable.keySet())
        {
            if(wordTable.get(s)>=minimum)
            {
                findWords.add(s);
            }
        }
        return findWords;
    }
}
