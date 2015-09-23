import java.util.ArrayList;

// for Java GUI components
import javax.swing.*;
//import java.awt.*;

// for listening to events
//import java.awt.event.*;

// for the file chooser dialog box
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// for basic file I/O
import java.io.*;



/**
 * A class to read a text files and break it into lines
 * 
 * @author Abu Shahriar
 * @version 2012.10.01
 */
public class TextFileReader
{
    /** 
     * Reads a text file and break it into lines
     * @return the lines read from the file
     * 
     */
    public ArrayList<String> readLines()
    {
        BufferedReader reader=null;
        ArrayList<String> lines = new ArrayList<String>();//An empty list of lines
        JFileChooser chooser = new JFileChooser();     // make a file chooser
        File txtFile = null;                         // name of image file
        FileNameExtensionFilter filter = new FileNameExtensionFilter(   // filter only for album files
                "Text files (*.txt)", "txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("C:\\"));                  // initial directory
        int returnVal = chooser.showOpenDialog(null);                   // let the user search for a file
        if(returnVal == JFileChooser.APPROVE_OPTION)                    // if one is selected
        {
            txtFile = chooser.getSelectedFile();
            try{
                //Open the file
                reader = new BufferedReader(new FileReader(txtFile));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    //Add the line in the list of lines
                    lines.add(line);
                }
                reader.close();
            }
            catch (FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,  " Cannot find file: "  +txtFile);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null,  " File read error: " + e.getMessage());
            }
        }
        return lines;
    }

}
