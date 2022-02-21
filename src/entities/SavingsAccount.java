package entities;

public class SavingsAccount extends Account{
	
	public SavingsAccount(Client client) {
		super(client);
	}

	@Override
	public void printStatement() {
		System.out.println("\n*** Savings Account Statement ***");
		super.printingCommonInformation();
	}
	
	@Override
	public void withdraw(double value) {
		balance -= value + (value * 0.02);
	}
}
