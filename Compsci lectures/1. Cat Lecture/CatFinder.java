public class CatFinder
{
    //fields
    private Cat lostCat;
    
    public CatFinder()
    {
        lostCat = null;
    }

    public void setLostCat(Cat myLostCat)
    {
        lostCat = myLostCat;
    }
    
    public Cat getLostCat()
    {
        return lostCat;
    }

    //checks if the cat we found is the cat we were looking for
    public void findCat(Cat newCat)
    {
        //lostCat -- looking for
        //newCat -- thing we found
        if( (lostCat.getName()).equals((newCat.getName())) 
             && lostCat.getWeight() == newCat.getWeight()
          )
        {
            
            
            
        }
        
        
        
    }
    
    
    
    
    
}
