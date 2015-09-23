import java.util.ArrayList;

/**
 * A PetTester.
 */
public class PetTester
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("jake");
        dog.fetch();
        //pet.speak();
        Cat c = new Cat("Cake");
        

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(new Cat("Cake"));
        pets.add(new Dog("Jake"));
        pets.add(new Pet());
        
        Pet thePet = new Dog("Fido");
        Dog d = (Dog)thePet;
        Pet newPet = new Pet();
        d = (Dog)newPet;
        d.fetch();
        
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        //sort the dogs
          
        
        for(Pet p : pets)
        {
            p.speak();
            System.out.println(p);
        }
        
//         for(int i=0; i<11; i++)
//         {
//             c.speak();
//             c.day();
//         }
    }
    
    public static void castTest()
    {
        int x = 3;
        int y = 4;
        double d = x / (double)y;
        System.out.println(d);
        System.out.println((int)d);
        
    }
}
