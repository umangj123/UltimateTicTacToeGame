import java.io.File;
import java.util.Scanner;
 import java.util.*;    //the Scanner class
    import java.io.*;  

public class ScoreSaver {

   public static void saveToFile(String[] names, int[] scores, int[] losses, int cnt){
      PrintStream ps = System.out;
      try{
      System.setOut(new PrintStream(new FileOutputStream("scores.txt")));
       for(int k = 0; k < cnt; k++)
          {
             System.out.println(names[k].toString());
             System.out.println(scores[k] + "");
             System.out.println(losses[k] + "");
          }
        System.setOut(ps);
      } catch (Exception e){
         System.err.println("issue writing scores");
      }
      
   }
   
   public static void addOneToScore(String nName){
      String[] names = new String[1000];
      int[] scores = new int[1000];
      int[] losses = new int[1000];
      int cnt = 0;
      
      try {
            
            File file = new File("scores.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String name = input.nextLine();
                int score = Integer.parseInt(input.nextLine().trim());
                int loss = Integer.parseInt(input.nextLine().trim());
                names[cnt] = name;
                scores[cnt] = score;
                losses[cnt] = loss;
                cnt++;
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
      int target = 0;
      boolean found = false;
      for(int i = 0; i < cnt; i++){
         if(nName.equals(names[i]))
            {
               found = true;
               target = i;
               break;
            }
      }
      
      if(found)
         {
            scores[target]++;
            saveToFile(names, scores, losses, cnt);
         }
      else
      {
         scores[cnt] = 1;
         losses[cnt] = 0;
         names[cnt] = nName;
         saveToFile(names, scores, losses, cnt + 1);
      }
   
   }
   
   public static void addOneToLoss(String nName){
      String[] names = new String[1000];
      int[] scores = new int[1000];
      int[] losses = new int[1000];
      int cnt = 0;
      
      try {
            
            File file = new File("scores.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String name = input.nextLine();
                int score = Integer.parseInt(input.nextLine().trim());
                int loss = Integer.parseInt(input.nextLine().trim());
                names[cnt] = name;
                scores[cnt] = score;
                losses[cnt] = loss;
                cnt++;
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
      int target = 0;
      boolean found = false;
      for(int i = 0; i < cnt; i++){
         if(nName.equals(names[i]))
            {
               found = true;
               target = i;
               break;
            }
      }
      
      if(found)
         {
            losses[target]++;
            saveToFile(names, scores, losses, cnt);
         }
      else
      {
         scores[cnt] = 0;
         losses[cnt] = 1;
         names[cnt] = nName;
         saveToFile(names, scores, losses, cnt + 1);
      }
   
   }

   
   
   public static String addOrSearchPlayerAndReport(String nName){
      String[] names = new String[1000];
      int[] scores = new int[1000];
      int[] losses = new int[1000];
      int cnt = 0;
      
      try {
            
            File file = new File("scores.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String name = input.nextLine();
                int score = Integer.parseInt(input.nextLine().trim());
                int loss = Integer.parseInt(input.nextLine().trim());
                names[cnt] = name;
                scores[cnt] = score;
                losses[cnt] = loss;
                cnt++;
            }
            input.close();

        } catch (Exception e) 
        {
          System.out.println("error");  
        }
        
      int target = 0;
      boolean found = false;
      for(int i = 0; i < cnt; i++){
         if(nName.equals(names[i]))
            {
               found = true;
               target = i;
               break;
            }
      }
      
      if(found)
         {
            return "Already Existing: " + names[target] + ": Wins = " + scores[target] + "; Losses: " + losses[target];
          }
      else
      {
         scores[cnt] = 0;
         losses[cnt] = 0;
         names[cnt] = nName;
         saveToFile(names, scores, losses, cnt + 1);
         return "Created New: " + names[cnt] + ": Wins = " + scores[cnt] + "; Losses: " + losses[cnt];
      }
      
      
   
   }

   
   public static String getScoreString(){
      String[] names = new String[1000];
      int[] scores = new int[1000];
      int[] losses = new int[1000];
      int cnt = 0;
      
      try {
            
            File file = new File("scores.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String name = input.nextLine();
                int score = Integer.parseInt(input.nextLine().trim());
                int loss = Integer.parseInt(input.nextLine().trim());
                names[cnt] = name;
                scores[cnt] = score;
                losses[cnt] = loss;
                cnt++;
            }
            input.close();

        } catch (Exception e) {
            
        }
      
      String fin = "";

      for(int i = 0; i < cnt; i++){
         fin += names[i] + "'s wins:" + scores[i] + "; losses: " + losses[i] + "\n";
      }
      
      return fin;
   
   }



}