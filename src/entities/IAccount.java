package entities;

public interface IAccount {
	void withdraw(double value);
	
	void deposit(double value);

	void transfer(double value, Account destinyAccount);
	
	void printStatement();
}
