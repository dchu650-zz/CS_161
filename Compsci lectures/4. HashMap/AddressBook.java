import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * An address book
 */
public class AddressBook
{

    //private ArrayList<Person> friends;
    private HashMap<String,Person> friends;
    
    /**
     * Builds an AddressBook
     */
    public AddressBook()
    {
        friends = new HashMap<String,Person>();
        friends.put("Bob", new Person("Bob"));
        friends.put("Alice", new Person("Alice"));
        friends.put("Chuck", new Person("Chuck"));

//         friends = new ArrayList<Person>();
//         friends.add(new Person("Bob"));
//         friends.add(new Person("Alice"));
//         friends.add(new Person("Chuck"));

    }

    public void printBobEmail()
    {
        System.out.println(friends.get("bob").getEmail());
    }
    
    public void printAllFriends()
    {
        Set<String> names = friends.keySet();
        
        for(String name : names)
        {
            System.out.println(friends.get(name));
        }
        
    }
    
    
    /**
     * Dictionary: HashMap<String,String>
     * Visual Dictionary: HashMap<String, BufferedImage>
     * ImagesBySize: HashMap<BufferedImage, Integer>
     */
    
    
    
    
    
    
    
    
    
    
    
}
