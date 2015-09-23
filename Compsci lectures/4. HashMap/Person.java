/**
 * A class representing a person
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private String email;
    private String phone;

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        name = "bob";
        email = "bob@example.com";
        phone = "555-123-4567";
    }

    public Person(String newName)
    {
        name = newName;
        email = newName+"@example.com";
        phone = "";
    }

    public Person(String newName, String newEmail, String newPhone)
    {
        name = newName;
        email = newEmail;
        phone = newPhone;
    }

    public String getName()
    {
        return name;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getEmail()
    {
        return email;
    }

    public void setName(String n)
    {
        name = n;
    }
    
    public void setPhone(String p)
    {
        phone = p;
    }
    
    public void setEmail(String e)
    {
        email = e;
    }
    
    public String toString()
    {
        return name+" ("+phone+", "+email+")";
    }
}
