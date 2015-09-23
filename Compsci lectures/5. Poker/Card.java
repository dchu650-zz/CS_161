/**
 * A playing card in a deck
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String suit; //"hearts" "diamonds" "clubs" "spades"
    private int rank; //1 = Ace, 2-10, 11 = Jack, 12 = Queen, 13 = King

    /**
     * Constructor for objects of class Card
     */
    public Card()
    {
        suit = "spades";
        rank = 1;
    }

    public Card(String newSuit, int newRank)
    {
        suit = newSuit;
        rank = newRank;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public int getRank()
    {
        return rank;
    }
    
    public void setSuit(String s)
    {
        suit = s;
    }
    
    public void setRank(int r)
    {
        rank = r;
    }
    
    public String toString()
    {
        String r = rank+""; //default to rank, converted to a string
        if(rank==1)
        {
            r = "ace";
        }
        else if(rank==11)
        {
            r = "jack";
        }
        else if(rank==12)
        {
            r = "queen";
        }
        else if(rank==13)
        {
            r = "king";
        }
            
        return r + " of " + suit;
    }    
}
