/**
 * A cat owner.
 */
public class CatOwner
{
    private Cat cat;

    /**
     * Constructor for CatOwner object. Takes in a Cat param
     */
    public CatOwner(Cat myCat)
    {
        cat = myCat;
    }

    /**
     * Getter for Cat
     */
    public Cat getCat()
    {
        return cat;
    }

    
    /**
     * Setter for Cat
     */
    public void setCat(Cat newCat)
    {
        cat = newCat;
    }

}
