
/**
 * Makes a Sliceable interface
 * 
 * @author (Darren Chu) 
 * @version (a version number or a date)
 */
public interface Sliceable
{
    public boolean isSliceable = false;
    public int numSlices = 8;
    /**
     * The method slices a piece of pizza
     * @return Returns whether the piece of pizza is sliceable or not and how many slices it can make.
     */
    public void slicePizza();
}
