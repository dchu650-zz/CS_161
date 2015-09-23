import java.util.ArrayList;
import java.util.Random;

/**
 * A Mystery class!
 * This class simulates a murder mystery
 */
public class Mystery
{
    private final int LIST_SIZE = 6;//(size)
    private ArrayList<Suspect> suspectList; //a list of potential suspects
    private Suspect victim; //the victim of this most heinous crime
    private Suspect murderer;
    private Weapon murderWeapon; //the weapon used to commit the crime
    /**
     * Creates a new Mystery object, simulating a murder mystery.
     * This sets up a list of suspects, has the crime get committed, then finds and reveals the criminal.
     */
    public Mystery()
    {
        //create the list of characters   
        
        suspectList = new ArrayList<Suspect>(); //(Darren)the arrayList was being declared twice therefore making the null error.
        suspectList.add(new Suspect("Bob", new Weapon("a sword")));
        suspectList.add(new Suspect("Alice", new Weapon("a gun")));
        suspectList.add(new Suspect("the Butler", new Weapon("dry wit")));
        suspectList.add(new Suspect("Joel", new Weapon("overly-long exams")));
        suspectList.add(new Suspect("Chuck", new Weapon("time bomb")));
        suspectList.add(new Suspect("Abu", new Weapon("gernade")));
        suspectList.add(new Suspect("the Detective", new Weapon("pencil")));
        
        commitCrime();
        
        Suspect murderer = findMurderer();
        System.out.println("The murderer is... " + murderer.getName() + "!");
    }

    /**
     * A crime occurs!
     * This method chooses the murder and the victim. It tracks the weapon used, and reports the crime.
     */
    public void commitCrime()
    {        
        Random gen = new Random();  
 
        Suspect murderer = suspectList.get(gen.nextInt(LIST_SIZE)); //choose the murderer
        victim = suspectList.get(gen.nextInt(LIST_SIZE)); //choose the victim
        murderWeapon = murderer.getWeapon(); //remember the weapon
        System.out.println(victim.getName() + " has been murdered with " + murderWeapon.getName() + "!");
    }
    
    /**
     * Figure out who committed the crime!
     * This finds a suspect who had the murder weapon, and returns that suspect.
     * @return The suspect who committed the crime.
     */
    public Suspect findMurderer()
    {
        Suspect murderer = null;
        for(Suspect suspect : suspectList)
        {
            if(suspect.getWeapon() == murderWeapon)
            {
                murderer = suspect;
            }
        }
        return murderer;
    }


}