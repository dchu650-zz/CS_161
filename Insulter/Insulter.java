import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.StringTokenizer;
/**
 * Write a description of class Insulter here.
 * 
 * @author Chris Spalding, and Darren Chu 
 * @version 10/24/12
 */
public class Insulter
{
    private ArrayList<String> firstList;
    private ArrayList<String> secondList;
    private ArrayList<String> thirdList;
    private int response;
    private String theInsult;
    /**
     * This is the constructor. It is really the 'mainline' for the program. 
     * It initializes data members and then calls the other methods to load the data,
     * generate insults and exit.
     */
    public Insulter()
    {
        firstList = new ArrayList<String>();
        secondList = new ArrayList<String>();
        thirdList = new ArrayList<String>();
        loadData();
        int response1 = showGreeting();
        while (response1 == JOptionPane.YES_OPTION)
        {
            response1 = showInsult();
        }
        goodBye();
    }

    /**
     * This loads the vocabulary from a text file into the three lists of words
     */
    public void loadData()
    {
        BufferedReader br; // for reading vocabulary text file
        try
        {
            br = new BufferedReader(new FileReader("Shakespeare.txt"));
            br.close();
            br = new BufferedReader(new FileReader("Shakespeare.txt"));
            String theLine = br.readLine();
            while (theLine != null)
            {
                StringTokenizer s = new StringTokenizer(theLine, ",");
                theLine = br.readLine();
                String first = s.nextToken().trim();
                firstList.add(first);
                String second = s.nextToken().trim();
                secondList.add(second);
                String third = s.nextToken().trim();
                thirdList.add(third);
            }
        }
        catch (IOException e)
        {
            System.out.println ("Error loading file: " + e.getMessage());
        }

    }

    /**
     * This displays an insult
     */
    public int showInsult()
    {
        String theInsultThou = "Thou";
        Random generator = new Random();
        int firstWord = generator.nextInt(firstList.size());
        String word = firstList.get(firstWord);
        int secondWord = generator.nextInt(secondList.size());
        String word2 = secondList.get(secondWord);
        int thirdWord = generator.nextInt(thirdList.size());
        String word3 = thirdList.get(thirdWord);
        theInsult = theInsultThou +" "+ word +" "+ word2 +" "+ word3;
        int response = JOptionPane.showConfirmDialog(null,
                theInsult + "\n\nWant more?",
                "Behold!",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.PLAIN_MESSAGE);
        return response;
    }

    /**
     * This is a little greeting to the user when the program starts
     */
    private int showGreeting()
    {
        return JOptionPane.showConfirmDialog(null,
            "Welcome to the Shakespearean Insult Generator. Shall we proceed?",
            "Welcome", 
            JOptionPane.YES_NO_OPTION);          
    }

    /**
     * This says good-bye when the program ends
     */
    private void goodBye()
    {
        String theInsultThou = "Thou";
        Random generator = new Random();
        int firstWord = generator.nextInt(firstList.size());
        String word = firstList.get(firstWord);
        int secondWord = generator.nextInt(secondList.size());
        String word2 = secondList.get(secondWord);
        int thirdWord = generator.nextInt(thirdList.size());
        String word3 = thirdList.get(thirdWord);
        theInsult = theInsultThou +" "+ word +" "+ word2 +" "+ word3;
        JOptionPane.showMessageDialog(null,
            "Goodbye " + theInsult, "Begone!", 
            JOptionPane.PLAIN_MESSAGE);
    }
}
