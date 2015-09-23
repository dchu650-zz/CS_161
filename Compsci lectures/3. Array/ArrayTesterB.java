/**
 * ArrayTesting class B
 */
public class ArrayTesterB
{
    private int[] primes;
    //private Student[] classA;
    private String[] websites;
    private Song[] top5;
    
    public ArrayTesterB()
    {
        primes = new int[7]; //first 5 primes
        //classA = new Student[24]; //class of students
        websites = new String[10]; //favorite websites
        
        //examples
        int[] wholeNumbers = new int[10];
        top5 = new Song[5];
        //String[] top5songs = new String[5];
        
        //...
        int width = 1024;
        //...
        
        int[] pixels = new int[width];        
        
        //fill primes
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        primes[5] = 13;
        primes[6] = 17;
               
        //fill songs top5
        top5[0] = new Song("Code Monkey");
        top5[1] = new Song("Halleluya");
        top5[2] = new Song("Hamster Dance");
        
        
    }

    public void accessPrimes()
    {
        int firstPrime = primes[0];
        System.out.println(firstPrime);
        System.out.println(primes[1]);
        System.out.println(primes);
        
    }
    
    public void printPrimes()
    {
        for(int i=0; i< primes.length; i++)
        {
            System.out.println(primes[i]);
        }
        
    }
    
    public void pringSongs()
    {
        for(Song song : top5)
        {
            System.out.println(song);
        }
        
        
    }
    
    
    
    
    
    
    
    

}
