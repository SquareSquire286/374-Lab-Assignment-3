import java.util.Scanner;

public class Bank
{
    private static Scanner scanner = new Scanner(System.in);
    public static Account user1 = new Account();
    public static Account user2 = new Account();

    public static void main(String[] args)
    {
	Bank bank = new Bank();
	bank.user1.chooseAccount();
	bank.user1.deposit(5000); // set an initial balance of $5000
	bank.user2.deposit(5000); // set an initial balance of $5000
	bank.user1.setInterest(); // defines the interest rate, though the account type is undertermined at this point
	bank.user2.setInterest(); // defines the interest rate, though the account type is undertermined at this point

	for (int i = 0; i < 12; i++)
	    {
		bank.user1.savingsAct.deposit(500);
		bank.user1.savingsAct.monthlyInterest();
		// $500 per month is deposited into the account of the user's choice
		System.out.println("After month #" + (i + 1) + ", the monthly compound interest account balance is $" + bank.user1.savingsAct.getSavings() + ".");
	    }

	for (int i = 0; i < 12; i++)
	    {
		bank.user2.savingsAct.deposit(500);
		bank.user2.savingsAct.biweeklyInterest();
		// $500 per month is deposited into the account of the user's choice
		System.out.println("After month #" + (i + 1) + ", the biweekly compound interest account balance is $" + bank.user2.savingsAct.getSavings() + ".");
	    }
    }
}
	
