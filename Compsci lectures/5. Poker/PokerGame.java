import java.util.ArrayList;
import java.util.HashMap;

/**
 * A PokerGame.
 */
public class PokerGame
{
    //ArrayList<Card> deck = new ArrayList<Card>();
    private Card[] deck;
    private HashMap<Integer,String> suitsByNumber;
    
    //ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
    Card[][] hands = new Card[5][6];
    
    
    /**
     * Creates a new PokerGame object.
     */
    public PokerGame()
    {        
        deck = new Card[52];
        suitsByNumber = new HashMap<Integer,String>();
        suitsByNumber.put(0,"diamonds");
        suitsByNumber.put(1,"hearts");
        suitsByNumber.put(2,"spades");
        suitsByNumber.put(3,"clubs");
        
        
        for(int i=0; i<4; i++) //go through the suits
        {
            for(int j=1; j<=13; j++) //go through the ranks
            {
                //add a card to the deck with suit i; rank j
                Card c = new Card( suitsByNumber.get(i), j);
                deck[i*13+(j-1)] = c;
            }
        }
        
        //print out the deck
        for(int i=0; i<deck.length; i++)
        {
            System.out.println(deck[i]);
        }

        hands[0][2] = new Card(); //adds a new card in the first position of the 3rd player

    }
    
    
    
    
    
    
    
    
    
}
