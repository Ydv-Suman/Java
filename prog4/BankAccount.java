// This is a class file named BankAccount thats store details like account number, balance, interest rate, interest earned.
// It also perform encapsulation by making instance variable private. It uses method like setter and getter to update the details.


/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount
{  
   private int accountNumber;
   private double balance;
   private double interestRate;
   private double interestEarned;
   
   /**
      Add a constructor
      @ @param acctNum the account number
      @param balance the initial balance
      @param intRate the interest rate
      @param intEarned the cumulative interest earned
   */
   public BankAccount(int acctNum, double balance, double intRate, double intEarned)
   {
      this.accountNumber = acctNum;
      this.balance = balance;
      this.interestRate = intRate;
      this.interestEarned = intEarned;
   }
   
  
  
  
   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public void setRate(double newRate)
   {
      this.interestRate = newRate;
   }
   /*
    Gets the current balance of the bank account.
    @return the current balance 
    */
   public double getBalance()
   {   
      return balance;
   }
   /**
      Gets the account number of the bank account.
      @return the account number
     */
   public int getAccountNumber()
   {
      return this.accountNumber;
   }
   /**
      Gets the interest rate of the bank account.
      @return the interest rate
     */
   public double getInterestRate()
   {
      return this.interestRate;
   }
   /**
      Gets the cumulative interest earned by the bank account.
      @return the cumulative interest earned
     */
   public double getInterestEarned()
   {
      return this.interestEarned;
   }
   /**
      Adds interest to the balance and updates the cumulative interest earned.
     */
   public void addInterest()
   {
      double interest = this.balance * this.interestRate;
      this.balance += interest;
      this.interestEarned += interest;
   }
   /**
      Returns a string representation of the bank account.
      @return a string representation of the bank account
     */
   public String toString()
   {
      return "Balance is " + balance;
   }
}
