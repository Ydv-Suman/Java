// Suman Yadav
// CSCI 2003   Date: February 6, 2024
// This program is tester for HealthClubMmber class. It uses the getters and setters method from class and
// provide information based on that. There are three different constructors  used in this code: one with no 
//arguments, another with no argumnets with different parameters, and last one with arguments. It also use to
// string to print the member's information.

public class HealthClubMemberTest
{
   public static void main(String[] args)
   {
      // Testing no arguments in constructor
      System.out.println("##Testing no arguments in constructor\n");
      HealthClubMember member =   new HealthClubMember();
       
      // Testing getters     
      System.out.println("Expected:   Name: Healthy Person");
      System.out.println("Actual:     Name: " + member.getName());
      
      System.out.println("Expected:    Age: 21");
      System.out.println("Actual:      Age: " + member.getAge());
      
      System.out.println("Expected: Weight: 150 pounds");
      System.out.println("Actual:   Weight: " + member.getWeight()+" pounds");
      
      System.out.println("Expected: Height: 65 inches");
      System.out.println("Actual:   Height: " + member.getHeight()+" inches");
      
      // Testing calcMaxHeartRate method
      System.out.println("Expected:  MaxHR: 192.83");
      System.out.printf("Actual:    MaxHR: %.2f\n", member.calcMaxHeartRate());
      
      //Testing calcBMI method
      System.out.println("Expected:    BMI: 24.96");
      System.out.printf("Actual:      BMI: %.2f\n", member.calcBMI());
      
      
      // Testinig with no arguments constructor with new parameters
      System.out.println("\n##Testinig with no arguments constructor with new parameters");
      HealthClubMember ironman =   new HealthClubMember("Ironman", 50, 163, 80);
            
      
      System.out.println("\nExpected:   Name: Ironman");
      System.out.println("Actual:    Name : " + ironman.getName());
      
      System.out.println("Expected:    Age: 50");
      System.out.println("Actual:      Age: " + ironman.getAge());
      
      System.out.println("Expected: Weight: 163 pounds");
      System.out.println("Actual:   Weight: " + ironman.getWeight()+" pounds");
      
      System.out.println("Expected: Height: 80 inches");
      System.out.println("Actual:   Height: " + ironman.getHeight()+" inches");
      
      System.out.println("Expected:  MaxHR: 173.40");
      System.out.printf("Actual:    MaxHR: %.2f\n", ironman.calcMaxHeartRate());
      
      System.out.println("Expected:    BMI: 17.90");
      System.out.printf("Actual:      BMI: %.2f\n", ironman.calcBMI());
      
      // Testing the arguments constructors
      System.out.println("\n##Testing the arguments constructors");
      HealthClubMember captainAmerica =   new HealthClubMember();
      
      //Testing setters     
      captainAmerica.setName("Captain America");
      captainAmerica.setAge(52);
      captainAmerica.setWeight(160);
      captainAmerica.setHeight(78);
      
      
      System.out.println("\nExpected:   Name: Captain America");
      System.out.println("Actual:     Name: " + captainAmerica.getName());
      
      System.out.println("Expected:    Age: 52");
      System.out.println("Actual:      Age: " + captainAmerica.getAge());
      
      System.out.println("Expected: Weight: 160 pounds");
      System.out.println("Actual:   Weight: " + captainAmerica.getWeight()+" pounds");
      
      System.out.println("Expected: Height: 78 inches");
      System.out.println("Actual:   Height: " + captainAmerica.getHeight()+" inches");
      
      System.out.println("Expected:  MaxHR: 172.06");
      System.out.printf("Actual:    MaxHR: %.2f\n", captainAmerica.calcMaxHeartRate());
      
      System.out.println("Expected:    BMI: 18.49");
      System.out.printf("Actual:      BMI: %.2f\n", captainAmerica.calcBMI());
      
      //Checking the tostring  Method
      System.out.println("\n##Checking the tostring  Method");
      System.out.println("________________________________\n");
      System.out.println(member);
      System.out.println(ironman);
      System.out.println(captainAmerica);

      
      }



}