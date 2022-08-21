 import java.awt.event.*;
   import javax.swing.*;
   import java.awt.*;
public class TButton extends JButton
   {
      private int bigrow,bigcol,smallrow,smallcol;
      private PlayerController pc;
      public TButton(PlayerController pc, int bigrow,int bigcol,int smallrow, int smallcol )
         
         {
            this.pc = pc;
            setPreferredSize(new Dimension(60, 60));
            this.bigrow = bigrow;
            this.bigcol = bigcol;
            this.smallrow = smallrow;
            this.smallcol = smallcol;
            setText("-");
            addActionListener(new Handler1(pc, bigrow, bigcol, smallrow,smallcol));
         }
         
      public int getBigRow()
         {
            return bigrow;
         }
         
      public int getBigCol()
         {
            return bigcol;
         }
         
      public int getSmallRow()
         {
            return smallrow;
         }
      public int getSmallCol()
         {
            return smallcol;
         }
         
     private class Handler1 implements ActionListener
      {
         private PlayerController pc;
         private int bigr,bigc,r,c;
         public Handler1(PlayerController pc, int bigr,int bigc,int r,int c)
         {
 //using this. to not create confusion
            this.pc = pc;
            this.bigr=bigr;
            this.bigc = bigc;
            this.r =r;
            this.c=c;
         }
         public void actionPerformed(ActionEvent e)
         {
            User user = pc.getCurrentPlayer();
            TButton tb = (TButton) (e.getSource());
            if (tb.getText().equals("-"))
            
              {
               tb.setText(user.getSymb());
               //System.out.println(user.getSymb());
               ThreePanel tp = (ThreePanel) tb.getParent();
               NinePanel np = (NinePanel) tp.getParent();
               if(tp.checkWin(user.getSymb(), r, c)) // user won the smaller square
                  {
                     tp.setEnabled(false);
                     tp.disable();
                     np.checkWin();
                  } 
               ThreePanel next = np.getThreePanel(tb.getSmallRow(), tb.getSmallCol());
               if(next.getWinner().equals("-") && !next.isFilled())
                  {
                     //System.out.println("Alpha");
                     np.disable();
                     next.enable();
                  }
               else
                  {
                     //System.out.println("Beta");
                     np.disable();
                     np.enable();
                  }


               pc.changePlayer();
              }
         }
           
           
          
   
   }
   
}