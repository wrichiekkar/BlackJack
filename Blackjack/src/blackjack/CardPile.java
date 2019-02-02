/**
 *
 * @author Wrichiek Kar
 */
package blackjack;

import java.util.ArrayList;

public class CardPile 
{    
    public ArrayList<Card> cards = new ArrayList<Card>();
    public CardPile() 
    {
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) 
    {
        this.cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() 
    {
        int num = (int) (Math.random() * this.cards.size());
        return this.cards.remove(num);
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() 
    {
        String cardsList = "\n";
        for (Card card : this.cards)
        {
            cardsList += card.toString() + "\n";
        }
        return cardsList;
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() 
    {
        return cards;
    }
}