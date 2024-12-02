/**
   Description: This program extends class called SecretPhrase as subclass of PassPhrase. It override 
                method that checks it's minimum criteria like, it should contains space and minimum 
                length, as well as it should have two of either uppercase, lowercase, or digit. Also it 
                override encryptTex() method that replace the vowel with '*' and add '@' at the beginning 
                of text if minimum length required isn't met. Finally it uses toString to print formated text 
                and encryptText.
*/


/*
 * SecretPhrase class represents a secret phrase that extends the PassPhrase class
 */
public class SecretPhrase extends PassPhrase{
   /*
    * minLength the minimum length of SecretPhrase
    */
   private int minLength;
   /*
    * constructs  SecretPhrase object with specified text and minimum length
    * @param theText the text of secretphrase
    * @param minLength the minimum length of the phrase
    */
   public SecretPhrase(String theText, int minLength){
      super(theText);
      this.minLength = minLength;
   }
   
   /*
   * checks validation of SecretPhrase based on specific criteria
   * -contain at least one space
   * -must have minimum text length requirement
   * -text should have two of either
   * -uppercase letters, lowercase letters, or digits
   * @return true if the criteria is met, otherwise false
   */
   @Override
   public boolean isValid(){
      String text = super.getText();
      boolean result_1 = false;
      boolean result_2 = false;
      boolean hasUpperCase = false;
      boolean hasLowerCase = false;
      boolean hasDigit = false;
      char character;
      if(text.contains(" ") && text.length() >= minLength){
         result_1 = true;
      }
      for (int i = 0; i < text.length(); i++){
         character = text.charAt(i);
         if (Character.isUpperCase(character)){
            hasUpperCase = true;
            break;
         }
      }
      for (int i = 0; i < text.length(); i++){
         character = text.charAt(i);
         if (Character.isLowerCase(character)){
            hasLowerCase = true;
            break;
         }
      }
      for (int i = 0; i < text.length(); i++){
         character = text.charAt(i);
         if (Character.isDigit(character)){
            hasDigit = true;
            break;
         }
      }
      if ((hasUpperCase && hasDigit) || (hasLowerCase && hasDigit) || (hasUpperCase && hasLowerCase)){
         result_2 = true;
      }
      if (result_1 && result_2){
         return true;
      }
      else{
         return false;
      }
   }
   
   /*
   * Encrypts the phrase by replacing both uppercase and lowercase vowels with '*'
   * add '@' as much as needed at the beginnig of text if the text doesn't met the minimum length requirement
   * @return the updated text as encryptText of the phrase
   */
   @Override
   public String encryptText(){
      String text = super.getText();
      String updatedText = text.replaceAll("[AEIOUaeiou]", "*");
      if (text.length() < minLength){
         for (int i = 0; i < (minLength - text.length()); i++){
            updatedText = "@" + updatedText;
         }
      }
      return updatedText;
   }
   
   /*
   * @return string representation of the phrase with encypted version
   * @return toString
   */
   @Override
   
   public String toString(){
      return super.toString() + " encrypted as " + encryptText();
   } 
}