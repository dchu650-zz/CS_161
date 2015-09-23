/**
 * This a cat
 * 
 * @author 161b
 */
public class Cat
{
    //fields
    private String name;
    private String breed;
    private double weight;
    
    //Constructors
    public Cat(String newName, String newBreed, double newWeight)
    {
        name = newName;
        breed = newBreed;
        weight = newWeight;
    }

    public Cat()
    {
        name = "winston";
        breed = "persian";
        weight = 10.0;
    }

    //GETTERS AND SETTERS
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }

    public String getBreed()
    {
        return breed;
    }
    
    public void setBreed(String newBreed)
    {
        breed = newBreed;
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    public void setWeight(double newWeight)
    {
        weight = newWeight;
    }
    
    public String toString()
    {
        return "Cat: "+name+", "+ breed+", "+weight;
    }
    
    














}
