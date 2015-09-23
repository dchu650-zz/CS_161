import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class Canvas - a class to allow for simple graphical 
 * drawing on a canvas.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 *
 * @version 2006.03.30
 * @version 2012.09.03  CH Modified to allow window to close. 
 *                         Modified to make the Canvas visible on construction
 * @version 2012.10.15  JR Modified to make close window kill program (for external use)
 * @version 2012.11.06  JR Modified to remove extraneous erase calls (reduces flicker in animation)
 *                         Added "draw" method for circles and rectangles
 */

public class Canvas
{
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic; //Graphics2D so we can do more things if we want
    private Color backgroundColor; //remembered for repainting
    private Image canvasImage;

    /**
     * Create a Canvas with default height, width and background color 
     * (300, 300, white).
     * @param title  title to appear in Canvas Frame     
     */
    public Canvas(String title)
    {
        this(title, 300, 300, Color.WHITE, 0, 0);        
    }

    /**
     * Create a Canvas with default background color (white).
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.WHITE, 0, 0);
    }

    /**
     * Create a Canvas. Makes the Canvas visible when it is constructed
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background color of the canvas
     * @param locX x-coordinate of upper left corner of window
     * @param locY y-coordinate of upper left corner of window
     */
    public Canvas(String title, int width, int height, Color bgColor, int locX, int locY)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.setLocation(locX, locY);
        frame.pack();
        setVisible(true);
    }

    /**
     * close the window
     * This method sets the Canvas to invisible, then disposes of it.
     * Chuck Hommel  2012.09.03
     */
    public void closeCanvas()
    {
        setVisible(false);
        frame.dispose();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) 
        {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.BLACK); //pen is black by default
        }
        frame.setVisible(true);
    }

    /**
     * Provide information on visibility of the Canvas.
     * @return  true if canvas is visible, false otherwise
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Fill the internal dimensions of a given shape with the current 
     * foreground color of the canvas.
     * @param  shape  the shape object to be filled 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
    }

    /**
     * Draws the given shape with the current foreground color of the canvas.
     * @param  shape  the shape object to be drawn 
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
    }

    
    /**
     * Fill the internal dimensions of the given circle with the current 
     * foreground color of the canvas.
     */
    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }

    /**
     * Draws a circle with the current foreground color of the canvas. This circle is unfilled.
     */
    public void drawCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        draw(circle);
    }

    /**
     * Fill the internal dimensions of the given rectangle with the current 
     * foreground color of the canvas. This is a convenience method. A similar 
     * effect can be achieved with the "fill" method.
     */
    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Draws a rectangle with the current foreground color of the canvas. This rectangle is unfilled.
     */
    public void drawRectangle(int xPos, int yPos, int width, int height)
    {
        draw(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Erase the whole canvas.
     */
    public void erase()
    {
        Color original = graphic.getColor();
        Dimension size = canvas.getSize();
        graphic.clearRect(0, 0, size.width, size.height); //erase old drawings to avoid leaks
        graphic.setColor(backgroundColor);
        graphic.fill(new Rectangle(0, 0, size.width, size.height)); //repaint the background
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erases a portion of the canvas in the shape of a circle. This is a convenience method.
     * See also the "erase" method.
     */
    public void eraseCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    /**
     * Erase a portion of the canvas in the shape of a rectangle. This is a convenience method. 
     * See also the "erase" method.
     */
    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Erase a portion of the canvas with the given shape.
     * @param  shape  the shape object to be erased 
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Erases a given shape's outline on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Draws an image onto the canvas.
     * @param  image   the Image object to be displayed 
     * @param  x       x co-ordinate for Image placement 
     * @param  y       y co-ordinate for Image placement 
     * @return  returns boolean value representing whether the image was 
     *          completely loaded 
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
    }

    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
    }

    /**
     * Sets the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas 
     */
    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    /**
     * Returns the current color of the foreground.
     * @return   the color of the foreground of the Canvas 
     */
    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    /**
     * Sets the background color of the Canvas.
     * @param  newColor   the new color for the background of the Canvas 
     */
    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    /**
     * Returns the current color of the background
     * @return   the color of the background of the Canvas 
     */
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    /**
     * changes the current Font used on the Canvas
     * @param  newFont   new font to be used for String output
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    /**
     * Returns the current font of the canvas.
     * @return     the font currently in use
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * Sets the size of the canvas.
     * @param  width    new width 
     * @param  height   new height 
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Returns the size of the canvas.
     * @return     The current dimension of the canvas
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Refreshes the drawing the the canvas, to help with things that aren't showing up.
     */
    public void refresh()
    {
        canvas.repaint();
    }
    
    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    public class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /**
     * 
     */
    public CanvasPane getCanvas()
    {
        return canvas;
    }
}
