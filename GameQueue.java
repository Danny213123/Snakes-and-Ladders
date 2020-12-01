/** 
 * Queue data structure
 *
 * @GameQueues Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */

import java.util.ArrayList;

public class GameQueues {

    ArrayList<String> GameQueues = new ArrayList<>();
    
    // Empty Constructor
    public GameQueues(){}
    
    
    
    /**
	* Adds a new value into the stack
	* @adds a new value, pushes other values 1 index ahead
	*/
    public void enqueue(String toAdd){
        GameQueues.add(toAdd);
    }



    /**
	* Removes the first value added
	* @removes the first value added
	*/
    public String dequeue(int a){
        try {
            return GameQueues.remove(a);
        } catch (Exception e){
            return null;
        }
    }
    
    
    
    /**
	* Returns the size of the queue
	* @returns the size of the queue
	*/
    public int size(){
        return GameQueues.size();
    }
    
    
    
    /**
	* returns the first value added
	* @returns at the first value added
	*/
    public String peek(int a){
        try {
            return GameQueues.get(a);
        } catch (Exception e){
            return null;
        }
    }
    
    
    
    /**
	* returns the values in the queue
	* @returns the values in the queue
	*/
    public void debugPrint(){
        for(String element: GameQueues){
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
