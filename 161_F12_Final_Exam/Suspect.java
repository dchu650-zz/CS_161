/**
 * A suspect in the mystery
 */
public class Suspect
{
    private String name;
    private Weapon weapon;

    /**
     * Creates a new Suspect object who has the given weapon.
     * @param name The name of the suspect.
     * @param weapon The suspect's weapon.
     */
    public Suspect(String name, Weapon weapon)
    {
        this.name = name;
        this.weapon = weapon;
    }

    /**
     * Creates a new Suspect object with no weapon.
     * @param name The name of the suspect.
     */
    public Suspect(String name)
    {
        this.name = name;
        this.weapon = null; //no weapon
    }

    /**
     * A getter for the suspect's name.
     * @return The suspect's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * A getter for the suspect's weapon.
     * @return The suspect's weapon.
     */
    public Weapon getWeapon()
    {
        return weapon;
    }
}
