package entities;

public abstract class Account implements IAccount{
	
	private static final int DEFAULT_AGENCY = 1;
	
	private static int SEQUENTIAL = 1;
	
	protected int agency;
	protected int number;
	protected double balance;
	protected Client client;
	
	public Account(Client client) {
		this.agency = Account.DEFAULT_AGENCY;
		this.number = SEQUENTIAL++;
		this.client = client;
	}

	public int getAgency() {
		return agency;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public void withdraw(double value) {
		balance -= value;
	}

	@Override
	public void deposit(double value) {
		balance += value;
	}

	@Override
	public void transfer(double value, Account destinyAccount) {
		this.withdraw(value);
		destinyAccount.deposit(value);
	}
	
	protected void printingCommonInformation() {
		System.out.println(String.format("Holder: %s", this.client.getName()));
		System.out.println(String.format("CPF: %s", this.client.getCpf()));
		System.out.println(String.format("Agency: %d", this.agency));
		System.out.println(String.format("Number: %d", this.number));
		System.out.println(String.format("Balance: %.2f", this.balance));
	}
}