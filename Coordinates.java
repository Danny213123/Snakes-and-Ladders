/** 
 * Stack data structure
 *
 * @Coordinates Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */



import java.util.ArrayList;



public class Coordinates {



    ArrayList<Integer> Coordinates = new ArrayList<>();
    
    
    
    // Empty Constructor
    public Coordinates(){}
    
    
    
    /**
	* Adds a new value into the stack
	* @adds a new value, pushes other values 1 index ahead
	*/
    public void push(int toAdd){
        Coordinates.add(0, toAdd);
    }
    
    
    
    /**
	* Returns the value removed from the stack
	* @return the value removed from the stack
	*/
    public String pop(){
        try {
            return Integer.toString(Coordinates.remove(0));
        } catch (Exception e){
            return null;
        }
    }
    
    
    
    /**
	* peeks into the stack
	* @peeks into the stack
	*/
    public String peek(){
        try {
            return Integer.toString(Coordinates.get(0));
        } catch (Exception e){
            return null;
        }
    }
    
    
    
    /**
	* Returns coordinates stored in the stack
	* @return coordinates stored in the stack
	*/
    public void PrintCoordinates(){
        int index = Coordinates.size();
        for(int element: Coordinates){
            
            double Position = element * 1.0;
            
            int YPos = (element - (int)(Math.ceil(Position / 12))) / 12;
            
            int XPos = element - (YPos * 12);
            
            System.out.print(index + ": YPos: " + YPos + " XPOS: " + XPos);
            
            index--;
            
        }
        
        System.out.println();
        
    }
    
    
    
    /**
	* Returns the size of the stack
	* @return size of stack
	*/
    public int size(){
        return Coordinates.size();
    }

}
