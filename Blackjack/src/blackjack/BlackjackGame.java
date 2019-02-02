/**
 *
 * @author Wrichiek Kar
 */

package blackjack;

import java.util.Scanner;

public class BlackjackGame 
{

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;
  private static String playagain = new String();

  public BlackjackGame(UserInterface ui) 
  {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) 
    {
      for (int j = 0; j < 4; j++) 
      {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() 
  {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() 
  {
    while (!houseDone || !playerDone) 
    {
      if (!houseDone) 
      {
        if (score(getHouseCards()) <= 17) 
        {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } 
        else 
        {
          houseDone = true;
        }
      }
      if (!playerDone) 
      {
        if (ui.hitMe()) 
        {
            getYourCards().add(deck.removeRandom());
            ui.display();
        } 
        else 
        {
            playerDone = true;
        }
        
      }
    }
  }

  public void end() 
  {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  public int score(CardPile p) 
  {
      int scoreSum=0;
        for (Card card:p.getCards())
        {
            scoreSum +=card.value();
        }
    return scoreSum;
  }

  public CardPile getHouseCards() 
  {
    return houseCards;
  }

  public CardPile getYourCards() 
  {
    return yourCards;
  }

  public static void main(String[] args) 
  {
    do
    {
    BlackjackGame game = new BlackjackGame(new SimpleUI());  
    game.start();
    game.play();
    game.end();

    System.out.println("Would you like to play again? (y/n)");
    Scanner scan = new Scanner(System.in);
    playagain = scan.nextLine();
    }
    while(playagain.equals("y"));   
  }
}
