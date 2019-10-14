public class ChequingAccount
{
    private double chBalance;
    private double interestRate;
    private boolean hasDebitCard;

    public ChequingAccount()
    {
	chBalance = 0;
	hasDebitCard = true;
	interestRate = 0;
    }

    public void deposit(double amount)
    {
	chBalance = chBalance + amount; // adds to the chequing account balance
    }

    public void withdraw(double amount)
    {
	if (amount > chBalance) // if the user tries to withdraw more money than they have
	    System.out.println("You do not have sufficient funds to make this transaction.");
	else chBalance = chBalance - amount; // otherwise, the withdrawal is approved
    }

    public double getChBalance()
    {
	return chBalance; // returns the chequing account balance
    }

    public void useCheque()
    { // proof-of-concept function to show that cheques can be used with this account type
        System.out.println("Cheque used!");
    }

    public void monthlyInterest()
    { // monthly compound interest calculation
	double monthlyInterest = (chBalance * interestRate) / 144.0;
	chBalance = chBalance + monthlyInterest;
    }

    public void setInterestRate(double rate)
    {
	interestRate = rate;
    }
}
