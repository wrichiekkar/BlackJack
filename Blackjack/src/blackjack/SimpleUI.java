/**
 *
 * @author Wrichiek Kar
 */
package blackjack;

import java.util.Scanner;

public class SimpleUI implements UserInterface 
{
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) 
    {
        this.game = game;
    }

  @Override
    public void display() 
    {
        System.out.println("House Holds:" + this.game.getHouseCards().toString());
        System.out.println("You Hold:" + this.game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() 
    {
        System.out.println("Would you like a hit? (y/n)");
        String choice = user.nextLine();
        boolean hit = true;
        do
        {
            if ("y".equals(choice))
            {
                hit = true;
            } 
            else if("n".equals(choice))
            {
                hit = false;
            }   
            else
            {
                System.out.println("You must type either 'y' or 'n'.");
                choice=user.nextLine();
            }
        }
        while(!"y".equals(choice) && !"n".equals(choice));
        return(hit);
    }    

  @Override
    public void gameOver() 
    {
        this.display();
        int yourScore = game.score (game.getYourCards());
        int houseScore = game.score (game.getHouseCards());
        System.out.println("House Score: " + houseScore);
        System.out.println("Your Score: " + yourScore);
        
        if((((yourScore > houseScore) && yourScore <=21) || houseScore > 21 && yourScore <=21))
        {
            System.out.println("You Win!");
        }
        else
        {
            System.out.println("House Wins!");
        }
        System.out.println("Thanks for playing!");
    }

}

