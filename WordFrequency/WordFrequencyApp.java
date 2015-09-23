import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * A class to test the WordFrequency class
 * 
 * @author Abu Shahriar
 * @version 10/01/2012
 */
public class WordFrequencyApp
{
    // instance variables
    private WordFrequency wordTable;

    /**
     * Constructor for objects of class WordFrequencyTester
     */
    public WordFrequencyApp()
    {
        //Create an object of type WordFrequency
        wordTable = new WordFrequency();
        //read words from a file and build the hash table
        TextFileReader fileReader = new TextFileReader();
        ArrayList<String> lines = fileReader.readLines();
        wordTable.buildWordFrequencyList(lines);
    }

    /**
     * take a word input from keyboard and print its frequency
     */

    public void showFrequencyofWord(){
        
        //
        String word = JOptionPane.showInputDialog("Enter a word:");
        if(word != null){
            int frequency = wordTable.findWordFrequency(word);
            System.out.println("\"" + word + "\" appears " + frequency + " times.");
        }
    }
    /**
     * find the maximum frequency of any word
     */

    public void showMaxFrequency(){
        
        int max = wordTable.findMaximumFrequency();
        System.out.println("Maximum frequency of any word is " + max);
    }

    /**
     * Show the list of words having maximum frequency
     */
    public void showMaxFrequencyWords(){
        //get the maximum frequnecy words
        ArrayList<String> words = wordTable.findMaximumFrequencyWords();
        //print the header
        System.out.println("Following words appear most:");
        //print the words
        for(String word:words){
            System.out.println(word);            
        }
    }
}
