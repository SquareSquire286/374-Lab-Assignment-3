import java.util.Scanner;

/*
    This class represents the overall application account that a user would have, which serves as a portal for the different types of specific bank accounts.
 */

public class Account
{ 
    private static Scanner scanner = new Scanner(System.in);
    private String username;
    private double balance;
    public SavingsAccount savingsAct = new SavingsAccount();
    public ChequingAccount chequingAct = new ChequingAccount();
    public MoneyMarketAccount moneyMarketAct = new MoneyMarketAccount();

    public Account()
    {
	username = "Guest"; // the user is initialized as a guest until a "login" occurs, represented by the setUser() method
	balance = 0;
    }

    public void setUsername(String name)
    {
	username = name; // updates the user's username
    }

    public void setBalance(double amount)
    {
	balance = amount; // update's the user's total balance
    }

    public void setInterest()
    {
	System.out.println("Press [1] to adjust the interest rate in your chequing account, [2] to adjust the interest rate in your savings account, and [3] to adjust the interest rate in your money market account.");
	int choice = scanner.nextInt();

	if (choice == 1) // the user indicates that they want to access their chequing account
	    chequingAct.setInterestRate(0.05);

	else if (choice == 3) // the user indicates that they want to access their money market account
	    moneyMarketAct.setInterestRate(0.05);
	
	else
	    {
		savingsAct.setInterestRate(0.05);
		if (choice != 2)
		    System.out.println("Invalid entry. Your savings account interest rate will be adjusted by default.");
	    }
    }

    public String getUsername()
    {
	return username; // retrieves the username string value (Guest by default)
    }
		    
    public double getBalance()
    {
	return balance; // retrieves the balance value
    }

    public void chooseAccount() // this is the algorithm that allows each individual user to determine his / her ideal bank account
    {
	System.out.println("Do you intend to use this account primarily for long-term savings and investments? (Y / N)");
	String q1 = scanner.nextLine();
	System.out.println("Are you interested in an account with access to cheques? (Y / N)");
	String q2 = scanner.nextLine();
	System.out.println("Are you interested in an account with a high interest rate, and willing to comply with a higher minimum balance? (Y / N)");
	String q3 = scanner.nextLine();
	System.out.println("Is a debit card essential to you? (Y / N)");
	String q4 = scanner.nextLine();

	if (q1.equals("Y")) // chequing becomes less viable, and more analysis is required
	    {
		if (q3.equals("N")) // this rules out a money market account
		    System.out.println("You should consider a savings account.");
		else if (q2.equals("Y")) // this rules out a savings account
		    System.out.println("You should consider a money-market account.");
	    }

	else
	    {
		if (q4.equals("Y") || q2.equals("Y")) // this makes chequing clearly the most viable option, since a debit card or cheques is necessary
		    System.out.println("You should consider a chequing account.");
		else if (q4.equals("N")) // if a debit card is not essential, the user likely cares more about the interest rate
		    {
			if (q3.equals("N"))
			    System.out.println("You should consider a savings account.");
			else System.out.println("You should consider a money-market account.");
		    }
		else System.out.println("Any account (chequing, savings, money-market) has its benefits and drawbacks.");
	    }
    }

    public void deposit(double amount)
    {		      
        System.out.println("Press [1] to adjust the balance of your chequing account, [2] to adjust the balance of your savings account, and [3] to adjust the balance of your money market account.");

	int choice = scanner.nextInt();

	if (choice == 1)
	   chequingAct.deposit(amount);

	else if (choice == 3)
	    moneyMarketAct.deposit(amount);

	else
	    {
		if (choice != 2)
		    System.out.println("Invalid entry. Your savings account balance  will be adjusted by default.");
		savingsAct.deposit(amount);
	    }
	balance = chequingAct.getChBalance() + savingsAct.getSavings() + moneyMarketAct.getMMBalance();
    }
}
