
// This is a class called Quaterback that stores quaterback details in different instance variable called
// firstName, lastName, nickName, passingAttempts, completions, passingYards, touchdownpasses, and interceptions.
// It also perform encapsulation by making instance variable private. It also provide public method to access the quaterback details.
// This class uses random for generating the nickname. It uses method like set, get, and toString as well.
import java.util.Random;  
public class Quarterback
{ 
   // First name of quaterback
   private String firstName;
   // Last name of quaterback
   private String lastName;
   // Nick name of quaterback
   private String nickName;
   // Number of passing attempts made by quaterback
   private int passingAttempts;
   // Number of completions made by quaterback
   private int completions;
   // passing yards scored by quaterback
   private int passingYards;
   // Number of touchdown passes done by quaterback
   private int touchdownPasses;
   // Number of interceptions thrown by quaterback
   private int interceptions;
}
   
   /*
      construct a new Quaterback object with given parameters
      @param first the first name of quaterback
      @param last the last name of quaterback
      @param att the passing attempts made by quaterback
      @param cmp the number of completions made by quaterback
      @param yds the passing yards scored by quaterback
      @ param td the Number of touchdown passes done by quaterback
      @param the interceptios Number of interceptions thrown by quaterback
   */   
   public Quarterback(String first, String last, int att, int cmp, int yds, int td, int interceptions)
   {
      
      this.firstName = first;
      this.lastName = last;
      this.passingAttempts = att;
      this.completions = cmp;
      this.passingYards = yds;
      this.touchdownPasses = td;
      this.interceptions = interceptions;
      this.generateNickname();
   }
   /*
      Construct a new Quaterback object with given parameters
      @param first the first name of quaterback
      @param last the last name of quaterback
      generate a nickname of quaterback
      initialize zero to all numeric value
   */
   public Quarterback(String first, String last)
   {
      this.firstName = first;
      this.lastName = last;
      this.generateNickname();
      this.passingAttempts = 0;
      this.completions = 0;
      this.passingYards = 0;
      this.touchdownPasses = 0;
      this.interceptions = 0;
   }
   /*
      sets the first name of the quaterback
      @param first the new first name to set
   */
   public void setFirstName(String first)
   {
      this.firstName = first;
   }
   /*
      sets the last name of the quaterback
      @param last the new last name to set
   */
   public void setLastName(String last)
   {
      this.lastName = last;
   }
   /*
      gets the firstname of the quaterback
      @return the firstname of the quaterback
   */
   public String getFirstName()
   {
      return this.firstName;
   }
   /*
      gets the lastname of the quaterback
      @return the lastname of the quaterback
   */
   public String getLastName()
   {
      return this.lastName;
   }
   /*
      gets the nickname of the quaterback
      @return the nickname of the quaterback
   */
   public String getNickname()
   {
      return this.nickName;
   }
   /*
      generate a random nicknmae for the quaterback from given adjectives and the last name
      nickname is generated in the format:<adjective> <lastname>
   */
   public void generateNickname()
   {
      // implementing the details provided in the code
      String adjectives = "LightningPrimetimeSweetnessPlaymakerMusclemanBeastmodeTouchdownLightsoutNightmareTombstoneHollywoodBarbarianAcrobaticDexterousExquisiteFerociousHerculeanMatchlessMasterfulMemorableMarvelousNefariousQuickstepUnrivaledAudaciousBodacious";
      Random random = new Random();
      int slice = random.nextInt(25)*9;
   
      String adjective = adjectives.substring(slice, slice+9);
      this.nickName = adjective + " "+ this.lastName.toUpperCase();
   }
   /*
      records a passing attempts made by quaterback, updating passing variable continuously
      @param complete true if the pass was completed, otherwise
      @param yards the yards scored or attempted on the pass
      @param touchdown true if the pass resulted in a touchdown, otherwise false
      @param interception true if the pass was intercepted, otherwise false
   */
   public void recordPassAttempt(boolean complete, int yards, boolean touchdown, boolean interception)
   {
      // implementing the details provided in the code
      if (complete)
      {
         completions ++;
         passingYards += yards;
         passingAttempts ++;
      }
      else
      {
         passingAttempts ++;
      }
      if (touchdown)
      {
         this.touchdownPasses ++;
         
      } 
      if (interception)
      {
         interceptions ++;
      }  
   }
   /*
      calculating the passer ratting of the quaterback based on thier numberic values
      @return the calculated passer rating
   */
   public double calcPasserRating()
   {
      // implementing detalis providedin the code
      double a = ((this.completions/(double)this.passingAttempts)-0.3)*5;
      if (a>2.375)
      {
         a = 2.375;
      }
      else if (a<0)
      {
         a = 0;
      }
      double b = ((this.passingYards/(double)this.passingAttempts)-3)*0.25;
      if (b>2.375)
      {
         b = 2.375;
      }
      else if (b<0)
      {
         b = 0;
      }
      double c = (this.touchdownPasses/(double)this.passingAttempts)*20;
      if (c>2.375)
      {
         c = 2.375;
      }
      else if (c<0)
      {
         c = 0;
      }
      double d = 2.375-((this.interceptions/(double)this.passingAttempts)*25);
      if (d>2.375)
      {
         d = 2.375;
      }
      else if (d<0)
      {
         d = 0;
      }
      double passerRating = ((a+b+c+d)/6)*100;
      return passerRating;
   }
   /*
      provides an analysis of the quaterback's passer rating
      @return a string denoting the passer rating
   */
   public String getPasserAnalysis()
   {
      // implementing details provided in the code
      double passerRating = calcPasserRating();
      if (passerRating >= 158.3)
      {
         return "Perfect Passer";
      }
      else if (passerRating>95)
      {
         return "Legendary";
      }
      else if (passerRating>=80)
      {
         return "Average";
      }
      else
      {
         return "Practice a little dude!";
      }
   }
   /*
   return a string representation of the quaterback object , including their values including passer rating and
   @retrun a formatted string representing the quaterback object
   */
   public String toString()
   {
      // implementing details provided in the code
      String formattedDetails = String.format("FirstName: %s\nlastName: %s\nNickName: %s\nPassingAttempts: %d\nCompletions: %d\nYards: %d\nTouchdownPasses:%d\nInterceptios: %d\nPasserRatting: %.1f",this.firstName, this.lastName, this.nickName, this.passingAttempts, this.completions, this.passingYards, this.touchdownPasses, this.interceptions, calcPasserRating());
      return formattedDetails;
   }
}