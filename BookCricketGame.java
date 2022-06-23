import java.util.Scanner;
import java.lang.Math;
public class BookCricketGame
{
   public static void main(String[] args)
   {
     int choice;
     String p1_name,p2_name;
     Scanner sc=new Scanner(System.in);
     System.out.println("Welcome To BookCricketGame !!");
     System.out.println("Rules for the Game : ");
     System.out.println("** Assume a book of 300 pages");
     System.out.println("1. Player 1 opens the book to read a page number(example 87) (Randomly generated)");
     System.out.println("2. If the page number is 87->87%7(%7 results in scorebetween 0-6)= 3 should be added to the score");
     System.out.println("3. Player 1 continues and keeps adding to the score untill page number results in a 0 score");
     System.out.println("4. Player 2 starts the game and tries to beat the score of player 1");
     System.out.println("5. In case of a tie, check the number of turns(player with lesser turns is winner)");
     System.out.println("6. Show the winner of the game");
     while(true)
     {
           int p1_score=0,p2_score=0,points,p1_round=0,p2_round=0,pageNum;
           System.out.print("Enter 1 To Start Game And 0 For Exit : ");
           choice=sc.nextInt();
           if(choice==0)
           {
               break;
           }
           System.out.print("Enter Player 1 Name : ");
           p1_name=sc.next();
           System.out.print("Enter Player 2 Name : ");
           p2_name=sc.next();
           System.out.println("Player : "+p1_name);
           while(true)
           {
                System.out.print("Enter 1 To Open Book : ");
                int order=sc.nextInt();
                pageNum=(int)(Math.random()*(300)+1);
                points=pageNum%7;
                p1_score+=points;
                p1_round++;
                if(points==0)
                {
                     System.out.println("!!!\t\tOPPS\t\t!!!");
                }
                System.out.println("Page Number "+pageNum+"\t\t\tPoint : "+points+"\t\t\tScore : "+p1_score);
                if(points==0)
                {
                     System.out.println(p1_name+" Total Score : "+p1_score);
                     System.out.println(p1_name+" Takes "+p1_round+" Rounds ");
                     break;
                }
           }
           System.out.println("\n"+p2_name+" Needs "+(p1_score+1)+" Score In "+p1_round+" Rounds To WIN MATCH\nPlayer : "+p2_name);
           p2_round=p1_round;
           while(true)
           {
                System.out.print("Enter 1 To Open Book : ");
                int order=sc.nextInt();
                pageNum=(int)(Math.random()*(300)+1);
                points=pageNum%7;
                p2_score+=points;
                System.out.println("Page Number "+pageNum+"\t\t\tPoint : "+points+"\t\t\tScore : "+p2_score+"\t\t\tRounds Left : "+(--p2_round));
                if(points==0 || p2_round==0 || p2_score>p1_score)
                {
                      System.out.println();
                      break;
                }
           }
           if(p2_score>p1_score || ((p2_score==p1_score) && (p2_round<p1_round)))
           {
                System.out.print(p2_name+" Win Match !!\n\n");
           }
           else if(p1_score>p2_score)
           {
                System.out.print(p1_name+" Win Match !!\n\n");
           }
 	   else
	   {
	   	System.out.print("IT'S A TIE");
	   }
       }
   }
}
