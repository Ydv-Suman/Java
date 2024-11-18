public class QuarterbackTester1
{
   public static void main(String[] args)
   {
      //start with this tester. Get the constructor and toString working
      //put in a stub for your passer rating method that just has a header with the statement return 500.0
      //after everything else seems to be working ok
      //go back and add the math to that method
      //incremental programming is your friend
      //don't try to do it all at once
      
      Quarterback qb1 = new Quarterback("Patrick", "Mahomes", 25, 20, 300, 2, 0);
      
      System.out.println("\n\n*****Expecting nicely formatted QB info that includes:\n\nName: Patrick Mahomes"  
       + "\na nickname like Masterful MAHOMES \nATT 25 CMP 20 YDS 300 TD 2 INT 0 \nPasser Rating 143.3\n\n");
            
      System.out.println(qb1);
      
      // after the above works, remove the // on the next 3 lines to check to see if generateNickname is working
      qb1.generateNickname();
      System.out.println("\n\n*****Expecting a new nickname");
      System.out.println(qb1);
      
      //got all that working, keep on going, removing the comments
      String performance = qb1.getPasserAnalysis();
      System.out.println("\nExpecting Legendary\nActual: " + performance);
         }
}