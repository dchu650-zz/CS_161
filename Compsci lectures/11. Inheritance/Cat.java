/**
 * A Cat.
 */
public class Cat extends Pet
{
    /**
     * Creates a new Cat object.
     */
    public Cat(String newName)
    {
        super(newName+" the cat");
    }

    public void day()
    {
        hunger++;
        super.day();
        
    }
     
    public void speak()
    {
        System.out.println("meow!");
    }

}
