import java.util.ArrayList;

// for Java GUI components
import javax.swing.*;
import java.awt.*;

// for listening to events
import java.awt.event.*;

// for the file chooser dialog box
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// for basic file I/O
import java.io.*;

// for image file I/O
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;

/**
 * A Java GUI for viewing images
 * 
 * @author Chuck Hommel 
 * @version 2011.11.26
 * @version 2012.09.29 Modified for CS161 Lab
 */
public class PictureViewer implements ActionListener
{
    private final int MAXX = 600;  // size of the window
    private final int MAXY = 600;

    private ArrayList<String> fileNames;
    private int currentImage; // index of image to show

    private JFrame myFrame;           // the window
    private ImagePanel imagePanel;    // for showing the image
    private JPanel buttonPanel;       // the buttons

    // make the buttons
    private JButton loadButton;
    private JButton eraseButton;
    private JButton mirrorButton;
    private JButton upsideDownButton;
    private JButton bwButton;
    private JButton negButton;
    private JButton undoButton;
    private JButton saveButton;
    private JButton quitButton;

    // Class to manipulate the image
    private PhotoShopper myPS;

    /**
     * Constructor for objects of class CS161PictureViewer
     */
    public PictureViewer()
    {
        makeViewer();
    }

    /**
     * Makes the window
     */
    private void makeViewer()
    {

        fileNames = new ArrayList<String>();
        // construct frame and set characteristics
        myFrame = new JFrame();
        myFrame.setTitle("CS161 Picture Viewer");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(MAXX, MAXY);

        // the picture
        imagePanel = new ImagePanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setPreferredSize(      // set image panel size, allow room for buttons
            new Dimension(MAXX, (int)(MAXY * 0.8))
        );  

        // the button panel
        buttonPanel = new JPanel();

        // make the buttons
        loadButton       = new JButton (" Load image ");
        eraseButton      = new JButton (" Erase image ");
        mirrorButton     = new JButton (" Mirror image ");
        upsideDownButton = new JButton (" Flip upside down ");
        bwButton         = new JButton (" Gray scale ");
        negButton        = new JButton (" Negative ");
        undoButton       = new JButton (" Undo " );
        saveButton       = new JButton (" Save image ");
        quitButton       = new JButton (" Exit ");

        // add buttons to the button panel
        buttonPanel.add(loadButton);
        buttonPanel.add(eraseButton);
        buttonPanel.add(mirrorButton);
        buttonPanel.add(upsideDownButton);
        buttonPanel.add(bwButton);
        buttonPanel.add(negButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(quitButton);
        // register this frame as a listener for the buttons
        loadButton.addActionListener(this);
        eraseButton.addActionListener(this);  
        mirrorButton.addActionListener(this); 
        upsideDownButton.addActionListener(this);
        bwButton.addActionListener(this);  
        negButton.addActionListener(this); 
        undoButton.addActionListener(this);
        saveButton.addActionListener(this);
        quitButton.addActionListener(this);

        // get the container
        Container myContainer = myFrame.getContentPane();
        myContainer.setLayout (new BorderLayout());

        // add the panels to the container
        myContainer.add(imagePanel, BorderLayout.CENTER);
        myContainer.add(buttonPanel, BorderLayout.SOUTH);

        // let's see it!
        myFrame.pack();
        myFrame.setVisible(true);
     } 

    /** 
     * retrieves a BufferedImage from a disk file
     * @return the BufferedImage, null if user cancels
     * 
     */
    public void loadImage()
    {
        BufferedImage theImage = null;
        JFileChooser chooser = new JFileChooser();     // make a file chooser
        File imageFile = null;                         // name of image file
        FileNameExtensionFilter filter = new FileNameExtensionFilter(   // filter only for album files
                "Graphic files (*.jpg)", "jpg");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("C:\\"));                  // initial directory
        int returnVal = chooser.showOpenDialog(null);                   // let the user search for an album file
        if(returnVal == JFileChooser.APPROVE_OPTION)                    // if one is selected
        {
            imageFile = chooser.getSelectedFile();
            // System.out.println("Trying to open : " + imageFile);
            try{
                //  File f = new File(imageFile);
                //File f = chooser.getSelectedFile();
                theImage = ImageIO.read(imageFile); 
                //System.out.println("Successful load.");
                // load image file names from albumFile
                //getImageNames(albumFile);  // load names of images in this album
                //currentImage = 0;          // this is the first image to show
            }
            catch (FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,  " Cannot find file: "  +imageFile);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null,  " File read error: " + e.getMessage());
            }
            myPS = new PhotoShopper(theImage);
            showImage(theImage);
        }
    }

    /** 
     * Saves a BufferedImage to a disk file
     * @param im the BufferedImage to save
     * @return true if successful, false if not
     * 
     */
    public boolean saveImage(BufferedImage im)
    {
        JFileChooser chooser = new JFileChooser();     // make a file chooser
        File imageFile = null;                         // name of image file
        FileNameExtensionFilter filter = new FileNameExtensionFilter(   // filter only for album files
                "Graphic files (*.jpg)", "jpg");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("C:\\"));                  // initial directory
        int returnVal = chooser.showSaveDialog(null);                   // let the user search for an album file
        if(returnVal == JFileChooser.APPROVE_OPTION)                    // if one is selected
        {
            imageFile = chooser.getSelectedFile();
            // System.out.println("Trying to open : " + imageFile);
            try{
                ImageIO.write(im, "JPG", imageFile); 
                return true;
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null,  " File write error: " + e.getMessage());
            }

        }
        return false;

    }

    /**
     * Handle events. We want to handle button clicks
     * The actionPerformed method is required by the ActionListener interface
     * @param evt the ActionEvent triggered by some outside event
     */
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == loadButton)
        {
            loadImage();
        }
        if (evt.getSource() == eraseButton)
        {
            showImage(myPS.eraseImage());
        }
        if (evt.getSource() == mirrorButton)
        {
            showImage(myPS.mirrorImage());
        }
        if (evt.getSource() == upsideDownButton)
        {
            showImage(myPS.upsideDownImage());
        }
        if (evt.getSource() == quitButton)
        {
            System.exit(0);
        }
        if (evt.getSource() == undoButton)
        {
            BufferedImage theImage = myPS.undo();
            if (theImage == null)
            {
                JOptionPane.showMessageDialog(null,"Can't undo. ");
            }
            else
            {
                showImage(theImage);
            }
        }
        if (evt.getSource() == negButton)
        {
            showImage(myPS.negativeImage());
        }

        if (evt.getSource() == bwButton)
        {
            showImage(myPS.grayScaleImage());
        }
        if (evt.getSource() == saveButton)
        {

            boolean saved = saveImage(myPS.getImage());
            if (saved)
            {
                JOptionPane.showMessageDialog(null, "File saved." );
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Unable to save." );
            }
        }
    }

    /** 
     * shows an image on the image panel
     */
    private void showImage(BufferedImage theImage)
    {

        imagePanel.showImage(theImage);                 // send it to the image panel
        theImage.flush();                               // empty the image buffer; seems to help with out of memory errors
        //reference: http://www.coderanch.com/t/279200/Streams/java/Exception-ImageIO-read
    }
}
