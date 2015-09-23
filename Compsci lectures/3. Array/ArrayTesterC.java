public class ArrayTesterC
{
    private int[] primes;
    private int[] wholeNumbers;
    private String[] words;
    private Song[] top5;

    private boolean[] lights;
    
    public ArrayTesterC()
    {
        primes = new int[7]; //first 5 primes
        int numWords = 12;
        words = new String[numWords+1]; //12+1 favorite words
        top5 = new Song[5];
        wholeNumbers = new int[10];

        double[] prices = new double[6];

        lights = new boolean[4];
        lights[0] = true;
        lights[1] = false;
        lights[2] = false;
        lights[3] = false;
        
        //fill primes
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        primes[5] = 13;
        primes[6] = 17;

        //fill songs
        top5[0] = new Song("Hollah Back Girl");
        top5[1] = new Song("Barbie Girl");
        top5[2] = new Song("Faithfully");
        
    }

    public void accessArray()
    {        
        for(int i=0; i<10; i++)
        {
            wholeNumbers[i] = i+1;
        }
        
    }

    public void printPrimes()
    {
        int firstPrime = primes[0];
        System.out.println(firstPrime);
        System.out.println(primes[1]);
        System.out.println(primes[2]);
        System.out.println(primes);

        for(int i=0; i< primes.length ; i++)
        {
            System.out.println(i+1+". "+primes[i]);
        }
        
    }
    
    public void changePrimes()
    {
        primes[0] = 10;
    }
    
    public void printSongs()
    {
        for(int i=0; i < top5.length; i++)
        {
            System.out.println(top5[i]);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
