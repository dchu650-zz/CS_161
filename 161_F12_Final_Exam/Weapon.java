/**
 * A weapon that may be used in a crime
 */
public class Weapon
{
    private String name;

    /**
     * Creates a new Weapon object.
     * @param name The name of the weapon
     */
    public Weapon(String name)
    {
        this.name = name;
    }

    /**
     * A getter for the weapon's name.
     * @return The weapon's name.
     */
    public String getName()
    {
        return name;
    }


}
