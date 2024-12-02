/**
   Program to test the basic functionality of the SecretPhrase class.
*/

public class Prog1Test
{
   public static void main(String [] args)
	{
		SecretPhrase sp1 = new SecretPhrase("The Beatles", 12);
		System.out.println("Valid? " + sp1.isValid());
		System.out.println(sp1.encryptText());
      System.out.println(sp1);

		SecretPhrase sp2 = new SecretPhrase("The Rolling Stones", 12);
		System.out.println("Valid? " + sp2.isValid());
		System.out.println(sp2.encryptText());
      System.out.println(sp2);
	}
}
