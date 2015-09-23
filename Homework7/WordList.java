import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * A wrapper class for dealing with wordlists (text files of words)
 * 
 * @author Joel
 * @version 2012.09.28
 */
public class WordList
{
    private ArrayList<String> list;

    /**
     * Creates a new word list from the given file
     */
    public WordList(String filename)
    {
        list = new ArrayList<String>();        
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/"+filename)));            
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line!=null) //while is a line to read
            {
                list.add(line); //add the line to the list
                line = reader.readLine(); //grab the next line
            }
        }
        catch(Exception e)
        {
            System.out.println("error parsing file:"+e);
        }
    }

    /**
     * Creates a new word list from the default file ("words1500.txt");
     */
    public WordList()
    {
        this("words1500.txt");                
    }

    /**
     * Gets the words from the WordList
     * 
     * @return an ArrayList of the words (each represented as a String)
     */
    public ArrayList<String> getWords()
    {
        return list;
    }
}
