Snakes and ladders by Danny Guan
    
    Rules:

    1. The players will roll for their turn
    
    2. Players cannot be on the same square, land on another player and you will be moved forward
       1 spot, unless you're on the last row, you will be moved backwards.
    
    3. You must roll on the finishing square to win, if you get higher, you will be moved back by
       (FinishPosition - ((XPosition + Roll) - Finish Position)
    
    4. If you land on a ladder, you will be moved up.
    
    5. If you land on a snake, you will be moved down.
    
    6. With the random snake and ladder generation, if a ladder or snake brings you to
       another ladder or snake, you will not be moved.
    
    7. Movement is the same as the game, you move right if you're on an odd row and move left
       on an even row.

Class Design

    1. I decided that for this project, it was best for me to create a player subclass, so that I could
       store all of the player's information in their very own objects so that whenever it was the player's
       turn, I could easily get their current position and set new ones. In the player class, 
       the constructor has positionX, positionY, previousX, previousY, name and pastpositions. 
       
       For my board, I decided to make a seperate board class with everything involving the board. 
       My board class contains 2d string array for board, 2d int array for snakes and a 2d int array for ladders
       This was because I wanted an ease of access to the board and make it so that updating the board with player movements
       was easy, by just getting the board, editing it and telling it to print. By having board be it's own class
       made it easier for me to impliment the snakes and ladders, I could edit the number of snakes and ladders I wanted,
       change the positions where they spawn and change the positions where they end.
    
       For the main game, I made a seperate class for the main game under the Game class. The game class has an empty constructor.
       The class contains 3 methods, the dice method, main game method and move player method. I made it like this because I wanted all the main
       game code under the same class so that all other subclasses lead to the main game, allowing me to easily edit code and add new features
       to the game with out changing everything.
    
       Under my main class, I get user input so that the user can personalize their game with ease. Designing my game
       like this allows me to easily find and edit codes. Editing one part of my code with this class design wont break
       all of my code, allowing me to easily spot and fix bugs in the code.

Data Structures

        For this game I decided to use 4 different data structures, normal arrays, 2d arrays, queues, and stacks.
        
        1. For 2d arrays, I used it to organize the game board, snakes, and ladders. I used 2d arrays to organize them
           because I found them easier to organize data, and it was the only data structure I knew which allowed me to store multiple values
           in one row which allowed me to quickly search through the array and find the data set I needed. For example, my snakes
           2d array are ordered in a way where the Y and X coordinates of where they spawned and where they ended were
           stored on each row, and the rows would be the number of snakes or ladders I wanted. So it made it easier for the game
           to automitically recognize if the player lands on a snake or ladder and where they would land up. This also made it
           easier to scale up the number of snakes or ladders I wanted with out changing all my code. And for my board,
           it was easier for me to just use a 2d array so that I could edit it using [row][col] indexes insteading of
           having a bunch of different arrays and editing each array.

        2. Queues, I used queues to store the players and their indexes would be their turn. This allowed me to
           to easily store their name and who was first to roll and who was last. This was great because I didn't need to
           code up turn handling, all I needed to do was use a for loop from 0 to the size of the queue and the game would
           handle who's turn it was.

        3. Stacks, I used stacks to store the player's positions through out the game. I used stacks for this because
           since it's abstract and dynamic, it was certainly easier to do so.
    
Improvements

        For improvements, more advanced and efficient algorithms could improve my game, making it run with
        less memory and run faster. Right now, my game uses a standard linear search algorithm which isn't very
        efficient.
