// This is driver file of kabaddiplayer. It allows user to input the basic input for two
// kabaddi player, including firstname, lastname, age, and number of player touched each round.
// It calculate raid attmepts, and strike using class called KabaddiPlayer. It also check the 
// eligibility to be captain based on conditions. It repeat the same thing for second player as well.


// importing Scanner
import java.util.Scanner;
public class KabaddiPlayerDriver
{
   // main body
   public static void main(String[] args)
   {
   Scanner in = new Scanner(System.in);
   
   // First player stats
   System.out.print("First Player Stats");
   System.out.println("\n==================");
   
   // creating a new object player1
   KabaddiPlayer player1 = new KabaddiPlayer();
   
   // Asking for user input of first player
   System.out.println("Enter the first name: ");
   String firstname1 = in.nextLine();
   
   System.out.println("Enter the last name: ");
   String lastname1 = in.nextLine();
   
   System.out.println("Enter the Age: ");
   int age1 = in.nextInt();
   
   // setting the firstname, lastname and age for first player
   player1.setFirstName(firstname1);
   player1.setLastName(lastname1);
   player1.setAge(age1);
   
   // input for Raid Rounds
   // usinf for nested loop for upto 7 rounds
   for (int raidRound = 1; raidRound <= 7; raidRound++)
   {
      System.out.println("\nRaid Round: " + raidRound + ".");
      System.out.print("Enter the number of player touched (0 to 7): ");
      int touch = in.nextInt();
      while(!(touch >= 0 && touch <= 7))
      {
         System.out.print("Invalid touch input: Enter a number of player touched (0 to 7): ");
         touch = in.nextInt();
      }
       
      player1.returnSafely(false, touch);
  
   } // close for loop
   
   // calling toString for first player
   System.out.println("\n" + player1 +"\n");
   
   // checking eligibility for captaincy for first player
   boolean eligibleForCaptain1 = player1.toBeCaptain();
   if (eligibleForCaptain1)
   {
      if (age1 >= 21)
      {
         System.out.println(player1.getFirstName() + " " + player1.getLastName() + " is ready to lead the team."); 
      }
      else
      {
         System.out.println(player1.getFirstName() + " " + player1.getLastName() + " meets the stats to be captain, but need atleast " + (21 - age1) + " more sdyears of Experience to lead the team.");
      }
   }
   else
   {
      System.out.println(player1.getFirstName() + " " + player1.getLastName() + " need more good stats to lead the team");
   }
   System.out.printf("%s %s has strike rate: %.2f",player1.getFirstName(), player1.getLastName(), player1.strikeRate()); // first object
   
   // Second player stats
   System.out.print("\n\nSecond Player Stats");
   System.out.println("\n===================");
   
   // creating another object player2
   KabaddiPlayer player2 = new KabaddiPlayer();
   
   // setting the firstname, lastname and age for second player
   in.nextLine();
   System.out.println("Enter the first name: ");
   String firstname2 = in.nextLine();
   
   
   System.out.println("Enter the last name: ");
   String lastname2 = in.nextLine();
   
   System.out.println("Enter the Age: ");
   int age2 = in.nextInt();
   
   //setting the input data to respecting 
   player2.setFirstName(firstname2);
   player2.setLastName(lastname2);
   player2.setAge(age2);
   
   // input for Raid Rounds
   // usinf do while nested loop for upto 7 rounds
   int nextraidRound = 1;
   do
   {
      System.out.println("\nRaid Round: " + nextraidRound + ".");
      System.out.print("Enter the number of player touched (0 to 7): ");
      int touch = in.nextInt();
      
      while(!(touch >= 0 && touch <= 7))
      {
         System.out.print("Invalid touch input: Enter a number of player touched (0 to 7): ");
         touch = in.nextInt();
      }
       
      player2.returnSafely(false, touch);
      nextraidRound++;
   }
   while(nextraidRound <= 7); // c;ose do while loop
   
   // calling toString for second player
   System.out.println("\n" + player2+ "\n");
   
   // checking eligibility for captaincy for second player
   boolean eligibleForCaptain2 = player2.toBeCaptain();
   if (eligibleForCaptain2)
   {
      if (age2 >= 21)
      {
         System.out.println(player2.getFirstName() + " " + player2.getLastName() + " is ready to lead the team."); 
      }
      else
      {
         System.out.println(player2.getFirstName() + " " + player2.getLastName() + " meets the stats to be captain, but need atleast " + (21 - age2) + " more years of Experience to lead the team.");
      }
   }
   else
   {
      System.out.println(player2.getFirstName() + " " + player2.getLastName() + " need more good stats to lead the team");
   }
   System.out.printf("%s %s has strike rate: %.2f", player2.getFirstName(), player2.getLastName(),  player2.strikeRate());
   in.close();
   } // close main
}// close class