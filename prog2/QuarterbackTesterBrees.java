public class QuarterbackTesterBrees
{
   public static void main(String[] args)
   {
      //Testing recordPassAttempt
            
      Quarterback qb1 = new Quarterback("Drew", "Brees");
      
      //Actual stats from Superbowl XLIV - Saints win!
      //
      //(10:00 - 4th) D.Brees pass short right to P.Thomas to IND 42 for 5 yards.
      qb1.recordPassAttempt(true, 5, false, false);
      
      //(9:19 - 4th) (Shotgun) D.Brees pass short left to D.Henderson to IND 36 for 6 yards.
      qb1.recordPassAttempt(true, 6, false, false);
      
      //(5:46 - 4th) D.Brees pass short right to J.Shockey for 2 yards, TOUCHDOWN.
      qb1.recordPassAttempt(true, 2, true, false);
      
      System.out.println("\n\n*****EXPECTING QB info that includes:\n\nName: Drew Brees"  
         + "\na nickname like Bodacious BREES \nATT 3 CMP 3 YDS 13 TD 1 INT 0 \nPasser Rating 124.3\n\n");
      
       System.out.println(qb1);
             
      //P. Manning actually threw an interception, not Brees
      //but this is to test to see if your program records incompletes and interceptions
      
      qb1.recordPassAttempt(false, 0, false, true);
      
      System.out.println("\n\n*****EXPECTING QB info that includes:\n\nName: Drew Brees"  
         + "\na nickname like Bodacious BREES \nATT 4 CMP 3 YDS 13 TD 1 INT 1 \nPasser Rating 78.1\n\n");
     
      System.out.println(qb1);
      
       //After you have recordPassAttempt working, add getNickname to your class and uncomment the code below
       //Test getNickname which should NOT generate a new nickname
       //You can add code to test the setters and getters for firstName and lastName
      
      System.out.println("\n\nAnd that's why they call him " + qb1.getNickname());
      System.out.println("~~Make sure this matches the nickname that was previously printed");

   } //end main
} //end class