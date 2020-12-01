import java.util.Scanner;

abstract class Game {
    
    // Empty constructor
    public Game(){}
    
    
    
    /**
	* Returns a dice roll
	* @param int Min - Minimum dice roll
	* @param int Max - Maximum dice roll
	* @return a dice roll
	*/
    public int DiceRoll(int Min, int Max){
        int Die = (int) (Math.random() * Max) + Min;
        return (Die);
    }
    
    
    
    /**
	* Main game
	* @param Player[] PlayersStorage - Array containing all player objects
	* @param String[][] SnakesAndLadders - Contains the actual Board
	* @param Board GameBoard - Board class
	* @param GameQueues Turn - Contains all the players in the queue
	* @returns the board with player movements
	*/
    public void MainGame(Player[] PlayersStorage, String[][]SnakesAndLadders, Board GameBoard, GameQueues Turn){
        
        Scanner sc = new Scanner (System.in);
        
        int Max = SnakesAndLadders.length * SnakesAndLadders.length;
        
        int DiceMin = 1;
        
        int DiceMax = 6;
        
        String DiceResponse = "";
        
        GameBoard.SetUpSnakes(Max, 0);
        
        GameBoard.SetUpLadders(Max, 0);
        
        int[][] Snakes = GameBoard.GetSnakes();
        
        int[][] Ladders = GameBoard.GetLadders();
          
        boolean GameEnded = false;
        
        String Response;
        
        int PreviousRow;
        
        int PreviousCol;
        
        int Rounds = 0;
        
        // While the game is active
        while (GameEnded == false){
            
            
            // Game turn
            for (int o = 0; o < Turn.size(); o++){
                
                int Roll = 0;
                
                int CoordinatesFix = 0;
                
                String Name = PlayersStorage[o].GetName();
                
                Name.substring(0, 1);
            
                Rounds += 1;
                
                int YPos = PlayersStorage[o].GetPositionRow();
                
                int XPos = PlayersStorage[o].GetPositionCol();
                
                String PlayerName = PlayersStorage[o].GetName();
                
                PlayersStorage[o].SetCoordinates(YPos, XPos);
                
                Response = "l";
                
                // The player decides to roll or quit
                while (!Response.equals("yes") || !Response.equals("no")){
                    
                    System.out.println("============");
                    
                    System.out.println("\nPlayer: " + o + "'s Turn!");
                    
                    System.out.println("\nRoll? (yes to roll, no to quit)");
                    
                    System.out.print(">");
                    
                    Response = sc.nextLine();
                    
                    // Roll
                    if (Response.equals("yes")){
                        
                        Roll = GameBoard.DiceRoll(DiceMin, DiceMax);
                        
                        break;
                        
                    // Quit the game
                    } else if (Response.equals("no")){
                        
                        if (Rounds >= 10){
                            
                            System.out.println(Turn.dequeue(o));
                            
                            System.out.println(PlayerName + " has quit the game.");
                            
                            SnakesAndLadders[YPos][XPos] = "Q";
                            
                            if (Turn.size() == 1){
                                
                                GameEnded = true;
                                
                                System.out.println("Everybody quit, " + PlayersStorage[o].GetName() + " wins!");
                                
                                break;
                                
                            } else {
                                
                                break;
                                
                            }
                        } else {
                            
                            System.out.println("\n10 rounds or more must be played");
                            
                            Response = "";
                        }
                    
                    // See past coordinates
                    } else if (Response.equals("past")){
                        
                        PlayersStorage[o].GetCoordinates();
                    
                    // Invalid Response
                    } else {
                        
                        System.out.println("\nInvalid Response\n");
                        
                    }
                }
                
                // If the Player is on the last row
                if (YPos == 0){
                    
                    // If the Player's roll will make him win
                    if (XPos + Roll == SnakesAndLadders[0].length - 1){
                        
                        System.out.println("\nPlayer " + o + ", rolled an " + Roll);
                        
                        XPos += Roll;
                        
                        System.out.println ("Player: " + o + ", wins in " + Rounds + " rounds!");
                        
                        GameEnded = true;
                        
                        break;
                    
                    // If the Player's roll will push him over the end
                    } else if (XPos + Roll > SnakesAndLadders[0].length - 1){
                        
                        System.out.println("\nPlayer " + o + ", rolled an " + Roll);
                        
                        Roll = Roll - ((SnakesAndLadders[0].length) - XPos);
                        
                        System.out.println("You moved past the finish line, so you moved back " + (Roll + 1) + " spaces!");
                        
                        XPos = (SnakesAndLadders[0].length - 1) - (Roll + 1);
                        
                        // If there is the position is already occupied, the player will be moved back
                        while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                            
                            // Moves Player backwards
                            
                            XPos -= 1;
                            
                            CoordinatesFix =(SnakesAndLadders[0].length - 1) - XPos;
                            
                            if (YPos % 2 == 1){
                                System.out.println("You've landed on a player, so you moved backwards to, " + YPos + ", " + XPos);
                            } else {
                                System.out.println("You've landed on a player, so you moved backward to, " + YPos + ", " + CoordinatesFix);
                            }
                        }
                    
                    } else {
                        
                        System.out.println("\nPlayer " + o + ", rolled an " + Roll);
                        
                        XPos += Roll;
                        
                        // If there is the position is already occupied, the player will be moved back
                        while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                            
                            // Moves Player backwards
                            
                            XPos -= 1;
                            
                            CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                            
                            if (YPos % 2 == 1){
                                System.out.println("You've landed on a player, so you moved backward to, " + YPos + ", " + XPos);
                            } else {
                                System.out.println("You've landed on a player, so you moved backward to, " + YPos + ", " + CoordinatesFix);
                            }
                        }
                    }
                    
                // Moves the player down 1 row if the player will go out of the limits
                } if (XPos + Roll >= SnakesAndLadders[0].length & YPos != 0){
                    
                    System.out.println("\nPlayer " + o + ", rolled an " + Roll);
                    double NumA = Roll * 10.0;
                    double NumB = SnakesAndLadders[0].length * 10.0;
                    
                    // Moves the player down by Roll / size of board col
                    YPos -= (int) (Math.ceil(NumA / NumB));
                    Roll = Roll - ((SnakesAndLadders[0].length) - XPos);
                    
                    // Resets Player XPos to 0
                    XPos = 0;
                    XPos += Roll;
                    
                    // If there is the position is already occupied, the player will be moved forward
                    while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                        
                        // Moves Player forwards
                        
                        XPos += 1;
                        
                        CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                        
                        if (YPos % 2 == 1){
                            System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + XPos);
                        } else {
                            System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + CoordinatesFix);
                        }
                        
                        if (XPos == SnakesAndLadders[0].length){
                            YPos -= 1;
                            XPos = 0;
                        }
                    }
                
                // If the Player's YPos isn't on the last row
                } else if (YPos != 0){
                    
                    System.out.println("\nPlayer " + o + ", rolled an " + Roll);
                    
                    XPos += Roll;
                    
                    // If there is the position is already occupied, the player will be moved forward
                    while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                        
                        // Moves Player forwards
                        
                        XPos += 1;
                        
                        CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                        
                        if (YPos % 2 == 1){
                            System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + XPos);
                        } else {
                            System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + CoordinatesFix);
                        }
                                
                        if (XPos == SnakesAndLadders[0].length){
                            YPos -= 1;
                            XPos = 0;
                        }
                    }
                }
                
                // If the player lands on a snake
                if (SnakesAndLadders[YPos][XPos] == "S"){
                    
                    System.out.println("You've landed on a snake!");
                    
                    // Moves the player down to the end of the snake
                    for (int x = 0; x < Snakes.length; x ++){
                        
                        if (Snakes[x][0] == YPos & Snakes[x][1] == XPos){
                            
                            YPos = Snakes[x][2];
                            
                            XPos = Snakes[x][3];
                            CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                            
                            if (YPos % 2 == 1){
                                System.out.println("You've been moved to " + YPos + ", " + XPos);
                            } else {
                                System.out.println("You've been moved to " + YPos + ", " + CoordinatesFix);
                            }
                            
                            while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                                XPos += 1;
                                CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                                
                                if (YPos % 2 == 1){
                                    System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + XPos);
                                } else {
                                    System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + CoordinatesFix);
                                }
                                
                                if (XPos == SnakesAndLadders[0].length){
                                    YPos -= 1;
                                    XPos = 0;
                                }
                            }
                            
                            break;
                        }
                    }
                }
                
                
                // If the player lands on a ladder
                if (SnakesAndLadders[YPos][XPos] == "L"){
                    
                    System.out.println("You've landed on a Ladder!");
                    
                    // Moves the player up to the end of the ladder
                    for (int x = 0; x < Snakes.length; x ++){
                        
                        if (Ladders[x][0] == YPos & Ladders[x][1] == XPos){
                            
                            YPos = Ladders[x][2];
                            
                            XPos = Ladders[x][3];
                            
                            CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                            
                            if (YPos % 2 == 1){
                                
                                System.out.println("You've been moved to " + YPos + ", " + XPos);
                                
                            } else {
                                
                                System.out.println("You've been moved to " + YPos + ", " + CoordinatesFix);
                                
                            }
                            
                            while (SnakesAndLadders[YPos][XPos] != "-" & SnakesAndLadders[YPos][XPos] != "S" & SnakesAndLadders[YPos][XPos] != "L" & SnakesAndLadders[YPos][XPos] != Name){
                                
                                XPos += 1;
                                
                                CoordinatesFix = (SnakesAndLadders[0].length - 1) - XPos;
                                
                                if (YPos % 2 == 1){
                                    
                                    System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + XPos);
                                    
                                } else {
                                    
                                    System.out.println("You've landed on a player, so you moved forward to, " + YPos + ", " + ((SnakesAndLadders[0].length - 1) - XPos));
                                
                                }
                                
                                if (XPos == SnakesAndLadders[0].length){
                                    
                                    YPos -= 1;
                                    
                                    XPos = 0;
                                    
                                }
                            }
                            
                            break;
                        }
                    }
                }
                
                // Updates the player's YPos and XPos
                
                PlayersStorage[o].SetPositionRow(YPos);
                PlayersStorage[o].SetPositionCol(XPos);
                
                // Gets the player's previous YPos and XPos
                
                PreviousRow = PlayersStorage[o].GetPreviousRow();
                PreviousCol = PlayersStorage[o].GetPreviousCol();
                
                // Resets the player's past position on the board
                
                SnakesAndLadders[PreviousRow][PreviousCol] = "-";
                
                // Updates the player's previous YPos and XPos
                
                PlayersStorage[o].SetPreviousRow();
                PlayersStorage[o].SetPreviousCol();
                
                // Moves the player
                GameBoard.MovePlayer (XPos, YPos, SnakesAndLadders, PlayerName, GameBoard);
                
                System.out.println("\nRound: " + Rounds);
                
                // Prints the board
                GameBoard.PrintBoard();
                
                System.out.println("\nPlayers: ");
                
                // Prints the players in the game and their turn number
                for (int q = 0; q < Turn.size(); q ++){
                    if (YPos % 2 == 1){
                        System.out.println(q + ": " + Turn.peek(q) + ": " + PlayersStorage[q].GetPositionRow() + ", " + PlayersStorage[q].GetPositionCol());
                    } else {
                        System.out.println(q + ": " + Turn.peek(q) + ": " + PlayersStorage[q].GetPositionRow() + ", " + ((SnakesAndLadders[0].length - 1) - XPos));
                    }
                }
                
                System.out.println("\n");
                
            }     
        }
    }
    
    /**
	* Moves the player
	* @param int Col - X position of the player
	* @param int Row - Y position of the player
	* @param String[][] Game - Board
	* @param String Name - Name of the player
	* @param Board GameBoard - Board object
	* @updates the name of the player
	*/
    public String[][] MovePlayer (int Col, int Row, String[][] Game, String Name, Board GameBoard){
        
        // Puts the first letter of the player's name on their current position
        Game[Row][Col] = Name.substring(0, 1);

        return (Game);
    }
}
