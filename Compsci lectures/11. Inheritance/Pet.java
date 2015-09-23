/**
 * A Pet.
 */
public class Pet
{
    protected int hunger;
    private final int MAX_HUNGER = 10;
    protected int happiness;
    private final int MIN_HAPPINESS = 0;
    protected String name;
    
    /**
     * Creates a new Pet object.
     */
    public Pet(String newName)
    {
        name = newName;
        hunger = 0;
        happiness = 10;
    }
    
    public Pet()
    {
        this("sparky");
    }
    
    //includes water?
    public void feed()
    {
        hunger = hunger -1;    
    }

    public void play()
    {
        happiness += 1;   
    }
    
    //a new day occurs
    public void day()
    {
        hunger = hunger + 1;
        happiness -= 1;
        if(hunger > MAX_HUNGER)
        {
            System.out.println("Your pet is too hungry, you can't have a puppy");          
            System.out.println("Your pet has died of hungry");
        }
        if(happiness < MIN_HAPPINESS)
        {
            System.out.println("Your pet is too lonely, you can't have a puppy");          
            System.out.println("Your pet has died of depression");                
        }
    }
    
    public void speak()
    {
        if(happiness < 5)
        {
            System.out.println("I'm "+name+"! \"Play with me!\"");
        }
        else
        {
            System.out.println("I'm "+name+"! \"I just met you and I love you!\"");
        }
    }
    
    //public void walk()
    //public void groom()
    
    
    

}
