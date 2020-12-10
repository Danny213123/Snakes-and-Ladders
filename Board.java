/** 
 * Board Generator
 *
 * @Board Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */

import java.util.Random;

public class Board extends Game{
    private String[][] Board;
    private int[][] Snakes;
    private int[][] Ladders;
    
    
    
    /** Board Constructor.
     *  
     * @Param String[][] Board - The Y size value of the board is stored in rows,
     * the X size value of the board is stored in cols.
     * 
     * @Param int[][] Snakes - The number of snakes are stored in rows, 
     * the coordinates they spawn are stored in cols.
     * 
     * @Param int[][] Ladders - The number of ladders are stored in the rows,
     * the coordinates they spawn are stored in cols.
     */
    public Board(String[][] Board, int[][] Snakes, int[][] Ladders){
        this.Snakes = Snakes;
        this.Ladders = Ladders;
        this.Board = Board;
    }
    
    
    
    
    /**
	* Randomly generates where the snakes will spawn and where they force you to land
	* @Param int Max
	* @Param int Min
	* @updates the Snakes 2d array with new coordinates
	*/
    public void SetUpSnakes(int Max, int Min){
        
        
        Random rand = new Random();
        
        
        for (int x = 0; x < this.Snakes.length; x ++){
            
            
            int SnakesYX = rand.nextInt((Max - 30) - Min) + Min;
            
            
            //System.out.println("Start: " + SnakesYX);
            
            
            this.Snakes[x][0] = (SnakesYX - ((int)(Math.floor(SnakesYX / this.Board.length)) + 1)) / this.Board.length;
            
            
            this.Snakes[x][1] = SnakesYX - ((int)(Math.floor(SnakesYX / this.Board[0].length)) * this.Board[0].length);
            
            
            int FallToYX = rand.nextInt(Max - SnakesYX) + SnakesYX;
            
            
            this.Snakes[x][2] = (FallToYX - ((int)(Math.floor(FallToYX / this.Board.length)) + 1)) / this.Board.length;
            
            
            this.Snakes[x][3] = FallToYX - ((int)(Math.floor(FallToYX / this.Board[0].length)) * this.Board[0].length);
        }
    }
    
    
    
    
    /**
	* Randomly generates where the ladders will spawn and where they force you to land
	* @Param int Max
	* @Param int Min
	* @updates the Ladders 2d array with new coordinates
	*/
    public void SetUpLadders(int Max, int Min){
        
        
        Random rand = new Random();
        
        
        for (int x = 0; x < this.Ladders.length; x ++){
            
            
            int LaddersYX = rand.nextInt(Max - (Max / 2)) + Max / 2;
            
            
            //System.out.println("Start: " + LaddersYX);
            
            
            this.Ladders[x][0] = (LaddersYX - ((int)(Math.floor(LaddersYX/  this.Board.length)) + 1)) /  this.Board.length;
            
            
            this.Ladders[x][1] = LaddersYX - ((int)(Math.floor(LaddersYX / this.Board[0].length)) * this.Board[0].length);
            
            
            try{
                
                
              this.Ladders[x][2] = rand.nextInt(this.Ladders[x][0] - 0) + 0;
              
              
              this.Ladders[x][3] = rand.nextInt(this.Ladders[x][1] - 0) + 0;
              
              
            } catch (IllegalArgumentException e){
                
                
                // Negative Exception error
                System.out.println("\nLadder generation error, trying again");
                
            }
        }
        System.out.println("\nLadder generation done");
    }
    
    
    
    
    /**
	* Returns the snakes array
	* @return the number of snakes and coordinates of the snakes
	*/
    public int[][] GetSnakes(){
        return(this.Snakes);
    }
    
    
    
    
    /**
	* Returns the ladders array
	* @return the number of ladders and coordinates of the ladders
	*/
    public int[][] GetLadders(){
        return(this.Ladders);
    }
    
    
    
    
    /**
	* Returns the board array
	* @return the board
	*/
    public String[][] GetBoard(){
        return(this.Board);
    }
    
    
    
    
    /**
	* Creates the board, printing out the end and start, putting all the snakes and ladders in
	* and updates the board with every player move.
	* @updates the board with accurate player movement
	*/
    public void PrintBoard(){
        
        this.Board[this.Board.length - 1][0] = ">";
        
        this.Board[0][this.Board[0].length - 1] = "X";
        
        // Places all the snakes
        for (int y = 0; y < this.Snakes.length; y ++){
            
            int Y = this.Snakes[y][0];
            
            int X = this.Snakes[y][1];
            
            //System.out.println(Y + ", " + X + " S");
            
            int EndY = this.Snakes[y][2];
            
            int EndX = this.Snakes[y][3];
            
            //System.out.println(EndY + ", " + EndX + " s");
            
            this.Board[Y][X] = "S";
        }
        
        // Places all the ladders
        for (int x = 0; x < this.Ladders.length; x ++){
            
            int Y = this.Ladders[x][0];
            
            int X = this.Ladders[x][1];
            
            //System.out.println(Y + ", " + X + " S");
            
            int EndY = this.Ladders[x][2];
            
            int EndX = this.Ladders[x][3];
            
            //System.out.println(EndY + ", " + EndX + " s");
            
            this.Board[Y][X] = "L";
            //Game[EndY][EndX] = "l" + Integer.toString(x);
        }
        
        // Game Border
        System.out.println();
        
        for (int l = 0; l < this.Board[0].length; l++){
            
            System.out.print("= ");
            
        }
        
        System.out.println();
        
        // Prints out the board
        
        for (int i = 0; i < this.Board.length; i++){
            
            // If the board is on an odd row, it will print it normally
            if (i % 2 == 1){
                
                for (int j = 0; j < this.Board[i].length; j++){
                    
                    System.out.print(this.Board[i][j] + " ");
                    
                }
                
                System.out.println();
                
            // If the board is on an even row, it will print it reverse
            }else{
                
                for (int j = this.Board[i].length - 1; j >= 0; j--){
                    
                    System.out.print(this.Board[i][j] + " ");
                    
                }
                
                System.out.println();
                
            }
        }
        
        // Game Border
        for (int l = 0; l < this.Board[0].length; l++){
            System.out.print("= ");
        }
        System.out.println();
    }
    
    
    
    /**
	* Sets up the board by adding values to the indexes
	* @updates the board with accurate player movement
	*/
    public String[][] SetUpBoard(){
        
        // Adds - to the array for each row and col index
        for (int x = 0; x < this.Board.length; x++){
            
            for (int y = 0; y < this.Board[x].length; y++){
                
                this.Board[x][y] = "-";
                
            }
            
        }
        
        return (this.Board);
    }
    
}
