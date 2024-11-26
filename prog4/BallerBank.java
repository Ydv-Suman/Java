// This is driver file for BankAccount. It Reads two file named "accounts.txt" , and
// "transactions.txt". Also, it uses class file to update the driver file. It uses differnet transactional codes like "DEE, "ACH", "ATM", and so no.
// It updates the balance and Finally uses printwriter and update the perovided details.

// importing the required classes for file operation
import java.util.Scanner;  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// creating class BallerBAnk
public class BallerBank
{
   // main method
   public static void main(String[] args)  throws FileNotFoundException
   {
      // maximum numbers of account allowed
      final int MAX_ACCOUNTS = 100;
      // array to store BankAccount objects
      BankAccount[] account = new BankAccount[MAX_ACCOUNTS];
      //initializing the variables
      int numberOfAccounts = 0;
      int accountNumber;
      
      // reading data from accounts.txt file
      try
      {
         File accountFile = new File("accounts.txt");
         Scanner scan = new Scanner(accountFile);
         while (scan.hasNextLine() && numberOfAccounts < MAX_ACCOUNTS)
         {
            accountNumber = scan.nextInt();
            double balance = scan.nextDouble();
            double interestRate = scan.nextDouble();
            double interestEarned = scan.nextDouble();
            account[numberOfAccounts] = new BankAccount(accountNumber, balance, interestRate, interestEarned);
            numberOfAccounts++;
         }
         scan.close();
         }
         catch (FileNotFoundException e)
         {
            System.out.println("accounts.txt file does not exists.");
         }
      // reading data from transactions.txt
      try
      {
         File transactionFile = new File("transactions.txt");
         Scanner in = new Scanner(transactionFile);
         while (in.hasNextLine())
         {
         String transaction = in.next();
         switch(transaction)
         {
            case "DEP":  // depositing the amount to account
               accountNumber = in.nextInt();
               double depositAmount = in.nextDouble();
               for (int i =0; i < numberOfAccounts; i++)
               {
                  if(account[i].getAccountNumber() == accountNumber)
                  {
                     account[i].deposit(depositAmount);
                     System.out.println("Deposit of $" + depositAmount + " in account " + account[i].getAccountNumber());
                  } 
               }
               break;
               
            case "ATM":  // calculating the balance left after atm withdrawal
               accountNumber = in.nextInt();
               double withdraw = in.nextDouble();
               for (int i =0; i < numberOfAccounts; i++)
               {
                  if(account[i].getAccountNumber() == accountNumber)
                  {
                     if(account[i].getBalance() > withdraw)
                     {
                        account[i].withdraw(withdraw);
                        System.out.println("Withdrawal of $" + withdraw + "from account " + account[i].getAccountNumber());
                     }
                     else
                     {
                        System.out.println(account[i].getAccountNumber() + " has insufficient balance.");
                     }
                  }
              }  
              break;
              
           case "ACH":   // calculating the transfer called ACH
              accountNumber = in.nextInt();
               withdraw = in.nextDouble();
               for (int i =0; i < numberOfAccounts; i++)
               {
                  if(account[i].getAccountNumber() == accountNumber)
                  {
                     if(account[i].getBalance() > withdraw)
                     {
                        account[i].withdraw(withdraw);
                        System.out.println("Transfer of $" + withdraw +" from account " + account[i].getAccountNumber());
                     }
                     else if (withdraw > account[i].getBalance() && ((withdraw- account[i].getBalance()) < 500))
                     {
                        account[i].withdraw(withdraw);
                        account[i].withdraw(25);
                        System.out.println("ACH Transfer Failed! Insufficient funds in account $25 overdraft fee applied " + account[i].getAccountNumber());
                     }
                     else
                     {
                          System.out.println("The account " + account[i].getAccountNumber() + " has insufficient funds.");
                     }
                  }                 
               }
           break;
           
           case "BAL":  // checking balance
            accountNumber = in.nextInt();
            for (int i =0; i < numberOfAccounts; i++)
            {
               if(account[i].getAccountNumber() == accountNumber)
               {
                  System.out.printf("The account number %d has balance of $%.2f\n", account[i].getAccountNumber(),  account[i].getBalance());
               }
            }
            break;
            
            case "OVR": // checking for overdraft
            for (int i =0; i < numberOfAccounts; i++)
            {
               if (account[i].getBalance() < 0)
               {
                  System.out.println("The account Number " + account[i].getAccountNumber() + " is overdrafted.");
               }
            }
            break;
            
            case "AVG":  // calaculating the average balance of the accounts
            double totalBalance = 0;
            for (int i =0; i < numberOfAccounts; i++)
            {
               totalBalance += account[i].getBalance();
            }
               System.out.println("The average balance of all accounts is " + (totalBalance / numberOfAccounts));
            break;
            
           case "FEE":  // applying service fee
           double amount = in.nextDouble();
           for (int i =0; i < numberOfAccounts; i++)
            {
               account[i].withdraw(amount);
               if (account[i].getBalance() < 0)
               {
                  account[i].withdraw(25);
               }
            }
            System.out.println("service fee applied to all account: $2.0");
            break;
            
            case "INT":  // adding interest
            for (int i =0; i < numberOfAccounts; i++)
            {
               account[i].addInterest();
            }
            break;
            
            case "TIN":  // calculating total interest earned
            double totalInterestEarned = 0;
            for (int i =0; i < numberOfAccounts; i++)
            {
               totalInterestEarned += account[i].getInterestEarned();
            }
            System.out.println("Total Interest earned by all accounts is $" + totalInterestEarned);
            break;
            
            case "MAX": // comparing the balance of account and finds maximum balance among account
            double maxBalance = account[0].getBalance();
            int index = 0;
            for (int i =0; i < numberOfAccounts; i++)
            {
               if (account[i].getBalance() > maxBalance)
               {
                  maxBalance = account[i].getBalance();
                  index = i;
               }
            }
            System.out.printf("The account number %d has max balance of %.2f\n",account[index].getAccountNumber(), maxBalance);
            break;
         } // end switch
         } // end while loop
         in.close();
         }
         catch (FileNotFoundException e)
         {
            System.out.println("transactions  .txt file does not exists.");
         }
         // Writing file named updatedAccounts
         PrintWriter write = new PrintWriter("updatedAccounts.txt");
         for (int i = 0; i < numberOfAccounts; i++)
         {
            write.printf("%d %.2f %.3f %.2f\n", account[i].getAccountNumber(), account[i].getBalance(), account[i].getInterestRate(), account[i].getInterestEarned());
         }
         write.close();
   } // end main
} // end class