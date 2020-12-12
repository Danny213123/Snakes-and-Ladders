/** 
 * Snakes and Ladders Game
 *
 * @Main Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        
        Player[] PlayersStorage;
        
        int NumberOfPlayers = 0;
        
        int NumberOfSnakes = 7;
        
        int NumberOfLadders = 7;
        
        int YSize = 10;
        
        int XSize = 10;
        
        boolean error = true;
        
        String Name;
        
        System.out.println("Snakes and ladders by Danny\n");
        
        // Gets the total number of players
        while (error){
            try {
                
                System.out.println("How many players? ");
                
                System.out.print(">");
                
                NumberOfPlayers = sc.nextInt();
                
                error = false;
                
                break;
                
            } catch (Exception e){
                
                System.out.println("\nERROR input must be an integer!\n");
                
                sc.next();
                
            }
        }
        
        error = true;
        
        
        // Gets the number of snakes and ladders
        while (error){
            try {
                System.out.println("\nHow many snakes do you want? ");
                
                System.out.print(">");
                
                NumberOfSnakes = sc.nextInt();
                
                System.out.println("\nHow many ladders do you want?");
                
                System.out.print(">");
                
                NumberOfLadders = sc.nextInt();
                
                error = false;
                
                break;
                
            } catch (Exception e){
                
                System.out.println("\nERROR input must be an integer!\n");
                
                sc.next();
                
            }
        }
        
        
        Board Game = new Board(new String[YSize][XSize], new int [NumberOfSnakes][4], new int [NumberOfLadders][4]);
        
        String[][] SnakesAndLadders = Game.GetBoard();
        
        SnakesAndLadders = Game.SetUpBoard();
        
        GameQueues Turn = new GameQueues();
        
        Coordinates PastCoordinates = new Coordinates();
        
        sc.nextLine();
        
        PlayersStorage = new Player[NumberOfPlayers];
        
        // Creates new player objects
        for (int x = 0; x < NumberOfPlayers; x ++){

            System.out.println("\nName of player " + x + ": ");
            
            System.out.print(">");
            
            Name = sc.nextLine();
            
            Turn.enqueue(Name);
            
            PlayersStorage[x] = new Player (SnakesAndLadders.length - 1, 0, 1, 1, PastCoordinates, Name);
            
        }
        
        // Begins the game
        Game.MainGame(PlayersStorage, SnakesAndLadders, Game, Turn);
    }
}
