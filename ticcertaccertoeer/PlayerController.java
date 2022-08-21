public class PlayerController 
   {
      private int current;
      private User p1, p2;
      
      public PlayerController(User u1, User u2)
         {
            current = 0;
            p1 = u1;
            p2 = u2;
         }
      public User getCurrentPlayer() {
         if(current == 0)
            {
               return p1;
            }
         return p2;
      }
      
      public User getNonPlayingPlayer() {
         if(current == 1)
               {
                  return p1;
               }
            return p2;      
      }
      
      public void changePlayer() {
         current = 1 - current;  
      }
      
   } 