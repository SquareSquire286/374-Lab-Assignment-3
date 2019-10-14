public class SavingsAccount
{
    private double svBalance;
    private int monthlyLimit;
    private int withdrawals;
    private double interestRate;
    private boolean hasDebitCard;

    public SavingsAccount()
    {
	svBalance = 0;
	monthlyLimit = 15; // arbitrary number picked for number of withdrawals per month
	withdrawals = 0;
	interestRate = 0;
	hasDebitCard = false;
    }

    public void deposit(double amount)
    {
	svBalance = svBalance + amount;
    }

    public void withdraw(double amount)
    {
	if (amount > svBalance)
	    System.out.println("You do not have sufficient funds to make this transaction.");
	else if (withdrawals == monthlyLimit)
	    System.out.println("You do not have any withdrawals remaining for this month.");
	else
	    {
		svBalance = svBalance - amount;
		withdrawals = withdrawals - 1;
	    }
    }

    public double getSavings()
    {
	return svBalance;
    }

    public void monthlyInterest()
    {
	double monthlyInterest = (svBalance * interestRate) / 144.0;
	svBalance = svBalance + monthlyInterest;
    }

    public void biweeklyInterest()
    {
	double biweeklyInterest = (svBalance * interestRate) / 288.0;
	svBalance = svBalance + biweeklyInterest;
    }

    public void setInterestRate(double rate)
    {
	interestRate = rate;
    }
}
