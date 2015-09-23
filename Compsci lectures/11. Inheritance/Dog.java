/**
 * A Dog.
 */
public class Dog extends Pet implements Comparable<Dog>, Carnivore
{
    protected int weight;

    /**
     * Creates a new Dog object.
     */
    public Dog(String newName)
    {
        super(newName+" the dog");
        weight = 10;
    }

    public void speak()
    {
        super.speak();
        System.out.println("Bark");
    }

    public void fetch()
    {
        System.out.println("fetches the stick!");
    }

    public int getWeight()
    {
        return weight;
    }
        
    public int compareTo(Dog d)
    {
        //this and d
        if(weight > d.getWeight()) 
        {
            return 1;
        }
        else if(weight < d.weight)
        {
            return -1;
        }
        else
        {
            return 0;
        }
        
        
        
        //fill this in!
    }
    
    public void eatMeat()
    {
        System.out.println("I eat meat!");   
    }
}
