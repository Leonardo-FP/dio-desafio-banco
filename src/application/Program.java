package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.CheckingAccount;
import entities.Client;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.println("------------------------------------------");
		System.out.println("             Digital Bank                 ");
		System.out.println("------------------------------------------");
		
		System.out.println();
		
		System.out.print("Type your name: ");
		String name = sc.nextLine(); 
		System.out.print("Type your CPF: ");
		String cpf = sc.nextLine();
		
		Client client = new Client(name, cpf);
		
		Account savingsAccount = new SavingsAccount(client);
		Account checkingAccount = new CheckingAccount(client);
		
		System.out.println();
		System.out.println("Welcome "+name+"!");
		System.out.println();
		
		
		char n = 'y';
		while(n == 'y' || n == 'Y') {
			System.out.println("To acess your accounts, type:");
			System.out.println("[1] Checking account");
			System.out.println("[2] Savings account");
			System.out.println("[3] Accounts statement");
			int answer = sc.nextInt();
			switch(answer) {
				case 1:
					System.out.println("Options: ");
					System.out.println("[1] Deposit");
					System.out.println("[2] Withdraw");
					System.out.println("[3] Transfer to savings account");
					int answer2 = sc.nextInt();
					switch(answer2) {
						case 1:
							System.out.print("Value to deposit: ");
							double valueToDeposit = sc.nextDouble();
							checkingAccount.deposit(valueToDeposit);
							checkingAccount.printStatement();
						break;
						case 2:
							System.out.print("Value to withdraw: ");
							double valueToWithdraw = sc.nextDouble();
							if(checkingAccount.getBalance() < valueToWithdraw) {
								System.out.println("\nChecking account balance below the requested value to withdraw");
							}
							else{
								checkingAccount.withdraw(valueToWithdraw);
							}
							checkingAccount.printStatement();
						break;
						case 3:
							System.out.print("Value to transfer: ");
							double valueToTransfer = sc.nextDouble();
							if(checkingAccount.getBalance() < valueToTransfer) {
								System.out.println("\nChecking account balance below the requested value to transfer");
							}
							else{
								checkingAccount.transfer(valueToTransfer, savingsAccount);
							}
							checkingAccount.printStatement();
							savingsAccount.printStatement();
						break;
						default:
							System.out.println("Invalid Number");	
					}
				break;
				case 2:
					System.out.println("Options: ");
					System.out.println("[1] Deposit");
					System.out.println("[2] Withdraw");
					System.out.println("[3] Transfer to checking account");
					answer2 = sc.nextInt();
					switch(answer2) {
						case 1:
							System.out.print("Value to deposit: ");
							double valueToDeposit = sc.nextDouble();
							savingsAccount.deposit(valueToDeposit);
							savingsAccount.printStatement();
						break;
						case 2:
							System.out.print("Value to withdraw: ");
							double valueToWithdraw = sc.nextDouble();
							if(savingsAccount.getBalance() < valueToWithdraw) {
								System.out.println("\nSavings account balance below the requested value to withdraw");
							}
							else{
								savingsAccount.withdraw(valueToWithdraw);
							}
							savingsAccount.printStatement();
						break;
						case 3:
							System.out.print("Value to transfer: ");
							double valueToTransfer = sc.nextDouble();
							if(savingsAccount.getBalance() < valueToTransfer) {
								System.out.println("\nSavings account balance below the requested value to transfer");
							}
							else{
								savingsAccount.transfer(valueToTransfer, checkingAccount);
							}
							checkingAccount.printStatement();
							savingsAccount.printStatement();
						break;
						default:
							System.out.println("Invalid Number");	
					}
				break;
				case 3:
					checkingAccount.printStatement();
					savingsAccount.printStatement();
					break;
				default:
					System.out.println("Invalid number!");
			}
			System.out.println("\nContinue using digital bank? <y/n>");
			n = sc.next().charAt(0);
			if(n == 'n') {
				System.out.println("\nThank you for your business!");
			}
		}
		sc.close();
	}

}
