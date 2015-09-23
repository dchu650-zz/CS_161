/**
 * A class to test our Cat example program
 */
public class CatTester
{
    //fields
    private Cat cat1;
    private Cat cat2;
    private Cat cat3;
    
    /**
     * The constructor for the CatTester. Runs our tests directly.
     */
    public CatTester()
    {
        cat1 = new Cat("Fluffy", "long", 7.0);
        cat2 = new Cat("Kitty", "short", 6.0);
        cat3 = new Cat("Tiger", "tabby", 11.0);

        //print the cats
        System.out.println(cat1); 
        System.out.println(cat2);
        System.out.println(cat3);
        

        
    }


}
