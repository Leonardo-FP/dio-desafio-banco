package entities;

public class CheckingAccount extends Account{

	public CheckingAccount(Client client) {
		super(client);
	}

	@Override
	public void printStatement() {
		System.out.println("\n*** Checking Account Statement ***");
		super.printingCommonInformation();
	}
	
	@Override
	public void transfer(double value, Account destinyAccount) {
		this.withdraw(value);
		destinyAccount.deposit(value + (value * 0.02));
	}
	
	
}