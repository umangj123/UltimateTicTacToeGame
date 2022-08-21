 import java.awt.event.*;
   import javax.swing.*;
   import java.awt.*;
public class ThreePanel extends JPanel
   {
     private int bigr,bigc;
     private TButton[][] t;
     private String winner;
     private PlayerController pc;
          public ThreePanel(PlayerController pc, int bigr,int bigc)
         {  
               this.pc = pc;
               setLayout(new GridLayout(3,3));
               this.bigr = bigr;
               this.bigc = bigc;
               t = new TButton [3][3];
               winner = "-";
               for (int r = 0; r<3; r++)
                  {
                     for (int c =0; c<3;c++)
                        {
                                TButton b = new TButton(pc, bigr, bigc, r, c);
                                t[r][c]= b;
                                add(b);
                         }
                  }
         
          }
          
          public String getWinner(){
            return winner;
          }
          
          public boolean isFilled() {
            int dashCnt = 0;
            for(int r = 0; r < 3; r++)
               {
                  for(int c = 0; c < 3; c++)
                     {
                        if(t[r][c].getText().equals("-")) {
                           dashCnt++;
                        }
                     }
               }
            return dashCnt == 0;

          }
           
          public void disable(){
            for(int r = 0; r < 3; r++)
               {
                  for(int c = 0; c < 3; c++)
                     {
                        t[r][c].setEnabled(false);
                        t[r][c].setBackground(Color.GREEN);
                     }
               }
          }
          
          public void enable(){
            for(int r = 0; r < 3; r++)
               {
                  for(int c = 0; c < 3; c++)
                     {
                        t[r][c].setEnabled(true);
                        t[r][c].setBackground(Color.YELLOW);
                     }
               }
          }
          
          // returns true if the user with sym wins after inserting at r, c
          // returns false if no one wins after the insertion of sym at r, c
          public boolean checkWin(String sym, int r, int c)
            {
               if(checkRowWin(sym, r) || checkColWin(sym, c) || (r == c && diag1(sym)) || (r == 2 - c && diag2(sym)))
                  {
                     winner = sym;
                     return true;
                  }
               return false;

                        
                      
            }
         private boolean checkRowWin(String s, int r)
            {
               for (int c=0;c<3;c++)
                  {
                     if (!s.equals(t[r][c].getText()))
                        {
                           return false;
                        }
                  }
               return true;
            }
         private boolean checkColWin(String s, int c)
            {
               for (int r=0;r<3;r++)
                  {
                     if (!s.equals(t[r][c].getText()))
                        {
                           return false;
                        }
                  }
               return true;

            }
         private boolean diag1(String s)
            {
               
               for (int c=0;c<3;c++)
                  {
                     if (!s.equals(t[c][c].getText()))
                        {
                           return false;
                        }
                  }
               return true;

            
            }
         private boolean diag2(String s)
            {
               
               for (int c=0;c<3;c++)
                  {
                     if (!s.equals(t[c][2-c].getText()))
                        {
                           return false;
                        }
                  }
               return true;

            }
         
      
   }