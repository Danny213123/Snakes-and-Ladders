/** 
 * Player sub class
 *
 * @Player Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */



public class Player extends Game{
    private int PositionRow;
    private int PositionCol;
    private int PreviousCol;
    private int PreviousRow;
    private Coordinates PastCoordinates;
    private String Name;
    
    
    
    /** Player Constructor.
     *  
     * @Param int PositionRow - Y Position of the player
     * @Param int PositionCol - X Position of the player
     * @Param int PreviousRow - Previous Y Position of the player
     * @Param int PreviousCol - Previous X position of the player
     * @Param Coordinates PastCoordinates - Stores all the coordinates the player has been
     * @Param String Name - Name of the player
     * 
     */
    public Player (int PositionRow, int PositionCol, int PreviousRow, int PreviousCol, Coordinates PastCoordinates, String Name){
        this.Name = Name;
        this.PositionRow = PositionRow;
        this.PositionCol = PositionCol;
        this.PreviousCol = PreviousCol;
        this.PreviousRow = PreviousRow;
        this.PastCoordinates = PastCoordinates;
    }
    
    
    
    /**
	* Returns the name of the player
	* @return player name
	*/
    public String GetName(){
        return this.Name;
    }
    
    
    
    /**
	* Returns the player's Y Position
	* @return the player's Y Position
	*/
    public int GetPositionRow(){
        return this.PositionRow;
    }
    
    
    
    /**
	* Returns the player's previous Y Position
	* @return the player's previous Y Position
	*/
    public int GetPreviousRow(){
        return this.PreviousRow;
    }
    
    
    
    /**
	* Returns the player's X Position
	* @return the player's X Position
	*/
    public int GetPositionCol(){
        return this.PositionCol;
    }
    
    
    
    /**
	* Returns the player's previous X Position
	* @return the player's previous X Position
	*/
    public int GetPreviousCol(){
        return this.PreviousCol;
    }
    
    
    
    /**
	* Returns the player's past positions
	* @return the player's past positions
	*/
    public void GetCoordinates(){
        this.PastCoordinates.PrintCoordinates();
    }
    
    
    
    /**
	* Sets the name of the player
	* @param String NewName - Name
	* @updates the name of the player
	*/
    public void SetName(String NewName){
        this.Name = NewName;
    }
    
    
    
    /**
	* Sets the Y Position of the player
	* @param String PositionRow - X value
	* @updates the Y Position of the player
	*/
    public void SetPositionRow(int PositionRow){
        this.PositionRow = PositionRow;
    } 
    
    
    
    /**
	* Sets the previous Y Position of the player
	* @updates the previous Y Position of the player
	*/
    public void SetPreviousRow(){
        this.PreviousRow = this.PositionRow;
    } 
    
    
    
    /**
	* Sets the previous X Position of the player
	* @updates the previous X Position of the player
	*/
    public void SetPreviousCol(){
        this.PreviousCol = this.PositionCol;
    } 
    
    
    
    /**
	* Sets the X Position of the player
	* @param String PositionCol
	* @updates the X Position of the player
	*/
    public void SetPositionCol(int PositionCol){
        this.PositionCol = PositionCol;
    }
    
    
    
    /**
	* Adds new coordinates in past coordinates
	* @param int YPos - row
	* @param int XPos - col
	* @updates the past coordinates of the player
	*/
    public void SetCoordinates(int YPos, int XPos){
        int Coordinate = (YPos * 12) + XPos;
        this.PastCoordinates.push(Coordinate);
    }



    /**
	* returns all values of the player
	* @return player values
	*/
    public String toString(){
        return("Name: " + this.Name + " PositionX: " + this.PositionRow + " PositionY: " + this.PositionCol + " PastPositionX: " + this.PreviousCol + " PastPositionY: " + this.PreviousRow);
    }
}
