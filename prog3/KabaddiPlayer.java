// this is class called KabaddiPlayer that stores player's details using different instance variable which 
// performs encapsulation by making instance variable private. It aslo uses method like like retrunSafely, strikeRate
// toBeCaptain as an additional method.It uses method like set, get, and toString as well.

/**
 * The KabaddiPlayer class represents a player in a Kabaddi game.
 * It stores information such as the player's name, age, raid attempts, successful attempts, unsuccessful attempts,
 * bonus points, total score, and provides methods to manipulate and access this information.
 */
public class KabaddiPlayer
{
   /** The first name of the player */
   private String firstName;
   /** The last name of the player */
   private String lastName;
   /** The age of the player */
   private int age;
   /** The raid attempts of the player */
   private int raidAttempts;
   /** The successfull attempts of the player */
   private int successfullAttempts;
   /** The unsuccessfull attempts of the player */
   private int unsuccessfullAttempts;
   /** The bonus point gained by the player */
   private int bonusPoint;
   /** The Total bonus point of a player */
   private int totalBonusPoints;
   /** The total score of the player */
   private int totalScore;
   /**
    * Constructs a new KabaddiPlayer object with default values.
    */
   public KabaddiPlayer()
   {
      this.firstName = "Lee";
      this.lastName = "jang-kun";
      this.age = 0;
      this.raidAttempts = 0;
      this.successfullAttempts = 0;
      this.unsuccessfullAttempts = 0;
      this.bonusPoint = 0;
      this.totalBonusPoints = 0;
      this.totalScore = 0;
   }
    /**
     * Constructs a new KabaddiPlayer object with specified values.
     * @param first the first name of the player
     * @param last the last name of the player
     * @param age the age of the player
     * @param raidAttempts the number of raid attempts made by the player
     * @param successfullAttempts the number of successful raid attempts made by the player
     * @param unsuccessfullAttempts the number of unsuccessful raid attempts made by the player
     * @param bonusPoint the bonus points earned by the player
     * @param totalBonusPoints the bonus points earned by the player
     * @param totalScore the total score earned by the player
     */
   
   public KabaddiPlayer(String first, String last, int age, int raidAttempts, int successfullAttempts, int unsuccessfullAttempts, int bonusPoint, int totalBonusPoint, int totalScore)
   {
      this.firstName = first;
      this.lastName = last;
      this.age = age;
      this.raidAttempts = raidAttempts;
      this.successfullAttempts = successfullAttempts;
      this.unsuccessfullAttempts = unsuccessfullAttempts;
      this.bonusPoint = bonusPoint;
      this.totalBonusPoints = totalBonusPoint;
      this.totalScore = totalScore;
   }
    /**
     * Sets the first name of the player.
     * @param first the first name of the player
     */
   public void setFirstName(String first)
   {
      this.firstName = first;
   }
    /**
     * Sets the last name of the player.
     * @param last the last name of the player
     */
   public void setLastName(String last)
   {
      this.lastName = last;
   }
   /**
     * Sets the age of the player.
     * @param age the age of the player
     */
   public void setAge(int age)
   {
      this.age = age;
   }
    /**
     * Gets the first name of the player.
     * @return the first name of the player
     */
   public String getFirstName()
   {
      return this.firstName;
   }
    /**
     * Gets the last name of the player.
     * @return the last name of the player
     */
   public String getLastName()
   {
      return this.lastName;
   }
   /**
     * Gets the age of the player.
     * @return the age of the player
     */
   public int getAge()
   {
      return this.age;
   }
    /**
     * Updates the player's statistics after a raid.
     * @param isTackled a boolean indicating whether the player was tackled during the raid
     * @param touch the number of players touched by the player during the raid
     */
   public void returnSafely(boolean isTackled, int touch)
   {
      if (!isTackled && touch >=3)
      {
         
         this.raidAttempts++;
         this.successfullAttempts++;
         this.bonusPoint=+2;
         
      }
      else if (!isTackled &&touch > 0)
      {
         this.raidAttempts++;
         this.successfullAttempts++;
      }
      else
      {
         this.raidAttempts++;
         this.unsuccessfullAttempts++;       
      }
      this.totalScore = (this.totalScore + touch) + this.bonusPoint;
      this.totalBonusPoints+=this.bonusPoint;
      
   }
  
    /**
     * Calculates the strike rate of the player.
     * @return the strike rate of the player
     */
   
   public double strikeRate()
   {
      if (this.raidAttempts == 0)
      {
         return 0.0;
      }
      else
      {
         double strikeRate = ((double)(this.totalScore)/raidAttempts)*100;
         return strikeRate;
      }
   }
   /**
     * Determines whether the player is eligible to be a captain based on strike rate and successful attempts.
     * @return true if the player is eligible to be a captain, otherwise false
     */
   public boolean toBeCaptain()
   {
      if (strikeRate() >= 200 && successfullAttempts >= 4)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
    /**
     * Returns a string representation of the player's details.
     * @return a string containing the player's details
     */
   public String toString()
   {
      String playerDetails = String.format("Firstame: %s\nLastname: %s\nAge: %d\nTotal Raid Attempts: %d\nTotal Successfull Attempts: %d\nTotal Unsuccessfull Attempts: %d\nBonus point each %d\nTotal Bonus Point: %d\nTotal Score: %d\nStrike Rate: %.2f\nCaptain: %s", this.firstName,  this.lastName, this.age, this.raidAttempts, this.successfullAttempts, this.unsuccessfullAttempts, this.bonusPoint, this.totalBonusPoints, this.totalScore, strikeRate(), toBeCaptain());
      return playerDetails;
   }
}