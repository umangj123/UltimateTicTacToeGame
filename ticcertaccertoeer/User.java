/****************************************************************
	* A User is a person that knows how to return and set its
   wins, symbol, and losses. It also can create the new users to go into the text file. 
   
   	* @author Sophie Uy Umang Jain
	* @version 24th May 2018
****************************************************************/

import javax.swing.*;

public class User
   {
      private int myWins,myLosses;
      private String myName,mySymb;
      
      /************************************************************* 
   	* Constructs a user with a myName specified by name
      and initial symbol, x or o, and sets their number of wins and losses to 0.   	
     
      * @param name   player name
      * @param symb   initial game symbol
   	**************************************************************/

         
         public User (String name,String symb)
            {
               myWins = 0;
               myLosses = 0;
               myName = name;
               mySymb = symb; 
            }
            /*************************************************************** 
   	* Returns the Users wins
   	* @return	 myWins
   	**************************************************************/

         public int getWins()

            {
               return myWins;
            }
            /*************************************************************** 
   	* Returns the User's symbol in the game
   	* @return	 mySymb
   	**************************************************************/

         public String getSymb()
            {
               return mySymb;
            }
            /*************************************************************** 
   	* Returns the User's number of losses
   	* @return	 myLosses
   	**************************************************************/

            public int getLosses()
            {
               return myLosses;
            }
            /*************************************************************** 
   	* Returns the User's name
   	* @return	 myName
   	**************************************************************/

         public String getName()
            {
               return myName;
            }
            /*************************************************************** 
   	* sets the User's wins
   	* @param wins   assigns wins to myWins
   	**************************************************************/

            public void setWins(int wins)
            {
               myWins = wins;
            }
             /*************************************************************** 
   	* Sets the User's number of losses
   	* @param losses  assigns losses to myLosses
   	**************************************************************/
         public void setLosses(int losses)
            {
               myLosses = losses;
            }
            /*************************************************************** 
   	* Creates the two users when players are starting game
   	* @param	x String x gets assigned as player 1 name
      * @param y String Y gets assigned as player 2 name
   	**************************************************************/

              public static void putInTextFile(String x, String y) 
            {
               User playerOne = new User(x,"x");
               User playerTwo = new User(y,"o");
            }
            
            
   
   }