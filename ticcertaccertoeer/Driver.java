    import java.io.*;
   import javax.swing.*;
  import javax.swing.JFrame;
   public class Driver
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("ulttictactoe");
         frame.setSize(800, 800);
         frame.setLocation(150, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Display());
         frame.setVisible(true);
         
      }
   }