// This is class called HealthClubMember that stores the member's information in different instance called name, age, weight, and height.
// this program performs encapsulation principle by making the instance variable private. It also provide public methods to access and 
// modify member's details without direct contacting private variables. It uses methods like getters and setters and finally to string.

public class HealthClubMember
{
   
   // Initiating instance variables
   private String name;
   private int age;
   private int weight;
   private int height;

   //Making no argument constructors
   public HealthClubMember()
   {
      name = "Healthy Person";
      age = 21;
      weight = 150;
      height = 65;
    }
   
   // Making argument constructors
   public HealthClubMember(String name1,int age1, int weight1, int height1)
   {
      name = name1;
      age = age1;
      weight = weight1;
      height = height1; 
   }
   
   // Making getters
   public String getName()
   {
      return name;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public int getWeight()
   {
      return weight;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   // Making calcMaxHeartRate
   public double calcMaxHeartRate()
   {
      double maxHR = 206.9-(0.67*age);
      return maxHR;
   }
   
   // Making calcBMI
   public double calcBMI()
   {
      double BMI = 703*(weight/Math.pow(height,2));
      return BMI;
   }
  
   
   // Making setters
   public void setName(String newName)
   {
      name = newName;  
   }
   
   public void setAge(int newAge)
   {
      age = newAge;
   }
   
   public void setWeight(int newWeight)
   {
      weight = newWeight;
   }
   
   public void setHeight(int newHeight)
   {
      height = newHeight;
   }
   
   // Making toString
   public String toString()
   {
      String memberinfo = String.format("Name   = %s \nAge    = %d\nWeigth = %d pounds\nheight = %d inches\nmaxHR  = %.2f\nBMI    = %.2f\n", name, age, weight, height, calcMaxHeartRate(), calcBMI());
      return memberinfo;
   }
   
   
}