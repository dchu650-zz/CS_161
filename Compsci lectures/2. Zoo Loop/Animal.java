/**
 * An animal in a zoo
 * 
 * @author 161b
 */
public class Animal
{
    //fields
    private String species;
    private String gender;
    
    /**
     * Creates a new animal of the given species
     * @param newSpecies the species of the animal
     */
    public Animal(String newSpecies)
    {
        species = newSpecies;
        gender = "female";
    }
    
    /**
     * Creates a new animal of the given species and gender
     * @param newSpecies the species of the animal
     * @param newGender the gender of the animal
     */
    public Animal(String newSpecies, String newGender)
    {
        species = newSpecies;
        gender = newGender;
    }

    /**
     * Creates a new animal of species "snow leopard"
     */
    public Animal()
    {
        species = "snow leopard";
        gender = "female";
    }

    /**
     * Gets the animal's species
     * @return the animal's species
     */
    public String getSpecies()
    {
        return species;
    }

    /**
     * Sets the animal's species
     * @param newSpecies the animal's new species
     */
    public void setSpecies(String newSpecies)
    {
        species = newSpecies;
    }

    /**
     * Gets the animal's gender
     * @return the animal's gender
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Sets the animal's gender
     * @param newGender the animal's new gender
     */
    public void setGender(String newGender)
    {
        gender = newGender;
    }
    
    /**
     * Pets the animal
     **/
    public void pet()
    {
        System.out.println("You pet the "+gender+" "+species);
    }    
    
    /**
     * Returns a string representation of the animal
     * @return a string representation of the animal
     */
    public String toString()
    {
        return "Animal: "+gender+" "+species;
    }
    
    














}
