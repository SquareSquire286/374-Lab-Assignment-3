public class MoneyMarketAccount
{
    private double mmBalance;
    private double interestRate;
    private double minimumBalance;
    private int chequeLimit;
    private int chequesUsed;
    private int monthlyLimit;
    private int withdrawals;
    private boolean hasDebitCard;

    public MoneyMarketAccount()
    {
	mmBalance = 0;
	interestRate = 0;
	minimumBalance = 5000; // minimum balance for the account
	chequeLimit = 10; // arbitrary number for the cheque limit per month
	chequesUsed = 0;
	monthlyLimit = 15;
	withdrawals = 0;
	hasDebitCard = false;
    }

    public void deposit(double amount)
    {
	mmBalance = mmBalance + amount;
    }

    public void withdraw(double amount)
    {
	if ((mmBalance - amount) < minimumBalance)
	    System.out.println("Your withdrawal cannot be processed because it would leave you under the minimum required balance for this account.");
	else if (withdrawals == monthlyLimit)
	    System.out.println("You do not have any withdrawals remaining for this month.");
	else
	    {
		mmBalance = mmBalance - amount;
		withdrawals = withdrawals + 1;
	    }
    }

    public double getMMBalance()
    {
	return mmBalance;
    }

    public void useCheque()
    {
	if (chequesUsed == chequeLimit)
	    System.out.println("You do not have any cheques remaining for this month.");
	else
	    {
		System.out.println("Cheque used!");
		chequesUsed = chequesUsed + 1;
	    }
    }

    public void monthlyInterest()
    {
	double monthlyInterest = (mmBalance * interestRate) / 144.0;
	mmBalance = mmBalance + monthlyInterest;
    }

    public void setInterestRate(double rate)
    {
	interestRate = rate;
    }
}
