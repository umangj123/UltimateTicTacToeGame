 import java.awt.event.*;
   import javax.swing.*;
   import java.awt.*;
public class Display extends JPanel
   {  
         private JPanel topPanel;
         private JTextField searchField;
         private NinePanel nine;
         private JButton button, searchButton;
         private String s1,s2; 
         private User p1,p2;
         
         public Display()
            {
              setLayout(new BorderLayout());
              
              String message = "Welcome To Ultimate Tic Tac Toe"+ "\n (TYPE 1-3)";
            message = message + "\n1. Play Game.";
            message = message + "\n2. Rules.";
            message = message + "\n3. Quit.";
            int choice = (int)Double.parseDouble(JOptionPane.showInputDialog(message));
            switch(choice)
            {

             case 1: 
               s1 = JOptionPane.showInputDialog("Player 1's name (X):");
              if(s1 == null || s1.equals(""))
              {
                  System.exit(0);
              }
               p1 = new User (s1,"x");
              
              s2 = JOptionPane.showInputDialog("Player 2's name(O): ");
              if(s2 == null || s2.equals(""))
              {
                  System.exit(0);
              }
              p2 = new User (s2,"o");
              break;
              case 2:
               int z=  (int)Double.parseDouble(JOptionPane.showInputDialog("Rules: There are nine tic tac toe boards nested into one larger board." + "\n On the very first move, player 1 may place an X anywhere on the board. Afterwards, a player's next move is determined by their opponent's previous move." + "\n For instance, if Player 1 places an X in the upper right corner of a board, then Player 2 must place an O in the upper right board."+ "\n If the board that you are designated to play in has already has 3 in a row, you may play anywhere."+"\n The See Score button at the top will allow you to see all the users' wins and losses, and the Search button lets you find a specific user. If that user does not exist, it will be created after this search." + "\n This game involves logic but is also a lot of fun. Enjoy! Type -1 to continue and play"));
                  if(z == -1)
                  {
                   //boolean player = true;
                 s1 = JOptionPane.showInputDialog("Player 1's name (X):");
              if(s1 == null || s1.equals(""))
              {
                  System.exit(0);
              }
               p1 = new User (s1,"x");
              
              s2 = JOptionPane.showInputDialog("Player 2's name(O): ");
              if(s2 == null || s2.equals(""))
              {
                  System.exit(0);
              }
               p2 = new User (s2,"o");
              

                 }
               
               break;
               
                case 3: 
                  JOptionPane.showMessageDialog(null, "Bye-bye!");
                  break;
               default: 
                  JOptionPane.showMessageDialog(null, "Not a valid selection.");
                  break;
        }
               
              
                            topPanel = new JPanel();
              topPanel.setLayout(new FlowLayout());
              
              PlayerController pc = new PlayerController(p1, p2);
              nine = new NinePanel(pc);
              add(nine,BorderLayout.SOUTH); 
              
              button = new JButton("See Scores");
              button.addActionListener(new Scores());
              topPanel.add(button);
              
              topPanel.add(new JLabel("     |     "));            
                  
              searchField = new JTextField("<Search Name Here>");
              topPanel.add(searchField);                

              searchButton = new JButton("Search (or Create) Player");
              searchButton.addActionListener(new ScoreSearch());
              topPanel.add(searchButton);
              
              add(topPanel, BorderLayout.NORTH);

                     
            }
        
          public void paintComponent(Graphics g)//JComponent and The Graphics Class are abstract classes (Graphics is the parameter and paintComponent is a method of the JComponent class)
               {
                   g.setColor(new Color(204,153,255));
                   g.fillRect(0,0,800,800); 
                   g.setColor(new Color(0,255,0));
                   g.setFont(new Font("Showcard Gothic",Font.BOLD ,55));
                   g.drawString("Ultimate Tic-Tac-Toe",50,90);
                   
                   
            
    
   
               }
      private class Scores implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         	  
              JOptionPane.showMessageDialog(null, ScoreSaver.getScoreString() );
               
          
            
          }
      }
      
      
      
      private class ScoreSearch implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         	  
              JOptionPane.showMessageDialog(null, ScoreSaver.addOrSearchPlayerAndReport(searchField.getText()));
               
          }
      }

      
      

   
   }
   

  
   
   
   