/**
	
	PassPhrase is a superclass for subclasses that implement special authentication requirements.
	It includes a constructor that stores the PassPhrase text, as well as accessor and toString methods.
*/

public abstract class PassPhrase
{
    private String text;
   
    /** 
	 	 Creates a new instance of PassPhrase 
		 @param textIn the PassPhrase text
	 */
    public PassPhrase (String textIn) 
	{
        this.text = textIn;
    }
   
 	 /** 
	 	Accessor for the PassPhrase text 
	 	@return the PassPhrase text
	 */	
	 public String getText() 
	 {
        return text;
     }

 	 /** 
	 	 Returns a formatted string containing the PassPhrase text 
		 @return a formatted String
	 */
	 public String toString()
	 {
			return String.format("Text: %s", getText());	 
	 }
    
    /** 
	 	 Method to determine if the PassPhrase is valid according to organization standards  
		 @return whether the PassPhrase text is valid (true) or not (false)
	*/	    
	 public abstract boolean isValid();
	 
	/** 
	 	 Method to transform the PassPhrase according to organization standards  
		 @return the encrypted version of the PassPhrase text
	*/
	 public abstract String encryptText();
}
