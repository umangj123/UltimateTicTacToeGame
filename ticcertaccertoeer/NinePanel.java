import javax.swing.*;
import java.awt.*;
public class NinePanel extends JPanel implements SubcomponentAbleable
   {
     private int bigr,bigc;
     private PlayerController pc;
     private ThreePanel[][] panels;
     
     public NinePanel(PlayerController pc)
         {     
               this.pc = pc;
               panels = new ThreePanel[3][3];
               setLayout(new GridLayout(3,3, 30,30));
               for (bigr=0;bigr<3;bigr++)
                  {
                  
                     for (bigc=0;bigc<3;bigc++)
                        {
                           ThreePanel t = new ThreePanel(pc, bigr,bigc);
                           add(t);
                           panels[bigr][bigc] = t; 
                        }
                  
                  }         
          }
          
      public ThreePanel getThreePanel(int bigr, int bigc)
         {
            return panels[bigr][bigc];
         }
         
      public void disable()
         {
            for (bigr=0;bigr<3;bigr++)
                  {
                  
                     for (bigc=0;bigc<3;bigc++)
                        {
                           panels[bigr][bigc].disable();
                        }
                  
                  } 
         }
     // enables All Panels Without Winners 
     public void enable()
         {
            int cnt = 0;
            for (bigr=0;bigr<3;bigr++)
                  {
                  
                     for (bigc=0;bigc<3;bigc++)
                        {
                           ThreePanel p = panels[bigr][bigc];
                           if(p.getWinner().equals("-") && !p.isFilled())
                              {
                                 p.enable();
                                 cnt++;
                              }
                           
                        }
                  
                  } 
                  
            if (cnt == 0)
               { 
               
                  JOptionPane.showMessageDialog(null, "Tie!");

                
               }
         }
         
      public boolean checkNoOptions(){
         
         for(int bigR = 0; bigR < 3; bigR++)
            {
               for(int bigC = 0; bigC < 3; bigC++)
               {
                     if(!panels[bigR][bigC].isFilled()) 
                     return false;
               } 
            } 
         
         return !winEval();
      
      }
      
      public boolean winEval()
         {
            for(int bigR = 0; bigR < 3; bigR++)
               {
                  if(checkRowWin(bigR)){
                     return true;
                  }
               }  
               
             for(int bigC = 0; bigC < 3; bigC++)
               {
                  if(checkColWin(bigC)){
                     return true;
                  }
               }
               
             if(diag1())
               {
                  return true;
               }
               
             if(diag2())
               {
                  return true;
               }
              return false;
         }
            
      public void checkWin()
         {
            for(int bigR = 0; bigR < 3; bigR++)
               {
                  if(checkRowWin(bigR)){
                     ScoreSaver.addOneToScore(pc.getCurrentPlayer().getName());
                     ScoreSaver.addOneToLoss(pc.getNonPlayingPlayer().getName());
                     JOptionPane.showMessageDialog(null, pc.getCurrentPlayer().getName() + " won!");
                     System.exit(0);
                     return;
                  }
               }  
               
             for(int bigC = 0; bigC < 3; bigC++)
               {
                  if(checkColWin(bigC)){
                     ScoreSaver.addOneToScore(pc.getCurrentPlayer().getName());
                     ScoreSaver.addOneToLoss(pc.getNonPlayingPlayer().getName());
                     JOptionPane.showMessageDialog(null, pc.getCurrentPlayer().getName() + " won!");
                     System.exit(0);
                     return;
                  }
               }
               
             if(diag1())
               {
                  ScoreSaver.addOneToScore(pc.getCurrentPlayer().getName());
                  ScoreSaver.addOneToLoss(pc.getNonPlayingPlayer().getName());
                  JOptionPane.showMessageDialog(null, pc.getCurrentPlayer().getName() + " won!");
                  System.exit(0);
                  return;
               }
               
             if(diag2())
               {
                  ScoreSaver.addOneToScore(pc.getCurrentPlayer().getName());
                  ScoreSaver.addOneToLoss(pc.getNonPlayingPlayer().getName());
                  JOptionPane.showMessageDialog(null, pc.getCurrentPlayer().getName() + " won!");
                  System.exit(0);
                  return;
               }
               
             if(checkNoOptions()){
                  JOptionPane.showMessageDialog(null, "Tie!");
               }
               
               
         }
      
      public boolean checkRowWin(int bigR)
         {
            String s = panels[bigR][0].getWinner();
            if(s.equals("-"))
               {
                  return false;
               }
            for(int bigC = 0; bigC < 3; bigC++)
               {
                  if(!s.equals(panels[bigR][bigC].getWinner()))
                     {
                        return false;
                     }
               }
               
            return true;
         }
         
       public boolean checkColWin(int bigC)
         {
            String s = panels[0][bigC].getWinner();
            if(s.equals("-"))
               {
                  return false;
               }
            for(int bigR = 0; bigR < 3; bigR++)
               {
                  if(!s.equals(panels[bigR][bigC].getWinner()))
                     {
                        return false;
                     }
               }
               
            return true;
         }
         
       public boolean diag1()
         {
            String s = panels[0][0].getWinner();
            if(s.equals("-"))
               {
                  return false;
               }
            for(int bigR = 0; bigR < 3; bigR++)
               {
                  if(!s.equals(panels[bigR][bigR].getWinner()))
                     {
                        return false;
                     }
               }
               
            return true;
         }
         
       public boolean diag2()
         {
            String s = panels[2][0].getWinner();
            if(s.equals("-"))
               {
                  return false;
               }
            for(int bigR = 0; bigR < 3; bigR++)
               {
                  if(!s.equals(panels[bigR][2 - bigR].getWinner()))
                     {
                        return false;
                     }
               }
               
            return true;
         }

          
      
   }