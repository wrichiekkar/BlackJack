/**
 *
 * @author Wrichiek Kar
 */
package blackjack;

public class Card implements Comparable 
{
  int rank, suit;
  boolean faceUp;

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) 
  {
    this.rank = rank;
    this.suit = suit;
    this.faceUp = faceUp;
  }

  //@return the faceUp
 
  public boolean isFaceUp() 
  {
    return faceUp; 
  }

  //@param faceUp the faceUp to set
  
  public void setFaceUp(boolean faceUp) 
  {
    this.faceUp = faceUp;
  }

  //@return the rank

  public int getRank() 
  {
    return rank;
  }

  //@return the suit

  public int getSuit() 
  {
    return suit;
  }

  @Override
  public boolean equals(Object ob) 
  {
    if (!(ob instanceof Card)) 
    {
      return false;
    }
    Card c = (Card) ob;
    if (c.rank==this.rank && c.suit == this.suit)
        return true;
    else 
        return false;
  }

  @Override
  public int hashCode() 
  {
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) 
  {
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) 
  {
    if (this.rank<c.rank)
        return -1;
    else if (this.rank>c.rank)
        return 1;
    else if (this.suit<c.suit)
        return -1;
    else if (this.suit>c.suit)
        return 1;
    else 
        return 0;
  }
  
  public int value()
  {
      if(this.rank ==14)
      {
          return (1);
      }
      else if (this.rank > 10)
      {
          return(10);
      }
      else
      {
          return (this.rank);
      }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() 
  {
      if (this.rank==11)
          return "Jack";
      
      else if (this.rank==12)
          return "Queen";
      
      else if (this.rank==13)
          return "King";
      else if (this.rank==14)
          return "Ace";
    return "" +this.rank;
  }

  /**
   * Returns the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() 
  {
      if (this.suit==0) 
          return "Clubs";
      else if (this.suit==1)
          return "Diamonds";
      else if (this.suit==2)
          return "Hearts";
      else if (this.suit==3)
          return "Spades";
      else
          return "this.suits";
  }

  @Override
  public String toString() 
  {
      if (this.faceUp)
          return (this.getRankString()+" of "+this.getSuitString());
      else
        return "?";
  }
}

