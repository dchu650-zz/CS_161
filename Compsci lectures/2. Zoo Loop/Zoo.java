import java.util.ArrayList;
import java.util.Random;

/**
 * A zoo of awesome animals!
 * 
 * @author 161b
 */
public class Zoo
{
    //fields (attributes, instance variables)    
    ArrayList<Animal> animalList; //our list of animals
    Random generator = new Random(); //for random numbers

    /**
     * Makes a new zoo object
     */
    public Zoo()
    {
        animalList = new ArrayList<Animal>(); //make the list
        
        //add a bunch of items to the list
        animalList.add(new Animal("sea otter"));
        animalList.add(new Animal("cougar"));
        animalList.add(new Animal("tiger"));
        animalList.add(new Animal("lion"));
        animalList.add(new Animal("corgie", "male"));
        animalList.add(new Animal("bear"));
        animalList.add(new Animal("corgie", "female"));
        animalList.add(new Animal("penguin"));
        animalList.add(0, new Animal("corgie", "?")); //make the corgie the first guy (index 0) of the list

        animalList.remove(4); //remove an animal from the list
        //System.out.println(animalList.get(0));
        System.out.println(animalList);

        
    }

    /**
     * Prints a random animal from the zoo
     */
    public void randomAnimal()
    {
        int index = generator.nextInt(animalList.size());
        Animal randomAnimal = animalList.get(index);
        System.out.println(randomAnimal);
    }

    /**
     * Prints each animal in the zoo
     */
    public void printEachAnimal()
    {
        int index = 0; //counter, i
        while(index < animalList.size())
        {
            Animal currentAnimal = animalList.get(index);
            System.out.println(currentAnimal);
            index = index + 1;
        }

    }

    /**
     * Pets each animal in the zoo
     */
    public void petEachAnimal()
    {
        for(Animal thisAnimal : animalList)
        {
            if(thisAnimal.getSpecies().equals("corgie"))
            {
                thisAnimal.pet();
            }
        }
    }

    /**
     * Pets the corgies in the zoo repeatedly
     */
    public void petCorgiesAlot()
    {
        /*
         * The below code pets each corgie repeatedly, then move on to the next
         */
        //         for(Animal thisAnimal : animalList)
        //         {
        //             int i = 0;
        //             while(i < 10)
        //             {
        //                 if(thisAnimal.getSpecies().equals("corgie"))
        //                 {
        //                     thisAnimal.pet();
        //                 }
        //                 i = i + 1;
        //             }
        //         }

        /*
         * The below code repeats pets the corgies in order multiple times
         */
        int i = 0;
        while(i < 10)
        {
            for(Animal thisAnimal : animalList)
            {
                if(thisAnimal.getSpecies().equals("corgie"))
                {
                    thisAnimal.pet();
                }
            }
            i = i + 1;
        }
    }

    public void hybridizeAnimals()
    {
        for(Animal front : animalList) //columns
        {
            for(Animal back : animalList) //rows
            {
                if(front.getSpecies().equals(back.getSpecies()))
                {
                    
                }
                else
                {
                    System.out.println(front.getSpecies() + "-" + back.getSpecies());
                }
            }
        }
        
        
    }
    
    public void printNumberedList()
    {
        int i = 0;
        while(i < animalList.size())
        {
            System.out.println(i+". "+animalList.get(i));
            i = i+1;
        }
        
    }
    
    
    //book example of a while loop. In pseudo-code!
//     public void example()
//     {
//         missing = true;
//         while(missing == true)
//         {
//             //look for keys
//             if(we found keys)
//             {
//                 missing = false;
//             }
//         }
//      }
    
    
    
}
