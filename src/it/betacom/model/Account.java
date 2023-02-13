package it.betacom.model;

import java.util.Scanner;

import it.betacom.util.ScheduledOutput;

public class Account {
	private String holderFullName;
	private Long balance;


	public void createAccount() {
		Scanner scanner = new Scanner(System.in);
		ScheduledOutput output = new ScheduledOutput();
		final Integer DEFAULT_TIMEOUT = 350;
		Integer timeout = DEFAULT_TIMEOUT;
		
		System.out.print("\nEnter the full name: ");
		setHolderFullName(scanner.nextLine());
		System.out.print("Enter the balance: €");
		setBalance(scanner.nextLong());
		
		output.setScheduledPrintln("\nAccount created!", timeout);
		output.setScheduledPrintln("Holder: " + getHolderFullName(), timeout);
		output.setScheduledPrintln("Balance: €" + getBalance(), timeout);
		
		scanner.close();
	}

	public void deposit() {
		Scanner scanner = new Scanner(System.in);
		ScheduledOutput output = new ScheduledOutput();
		final Integer DEFAULT_TIMEOUT = 350;
		Integer timeout = DEFAULT_TIMEOUT;
		Long amount;
		
		output.setScheduledPrint("\nEnter the amount you want to deposit: €", timeout);
		amount = scanner.nextLong();
		setBalance(getBalance() + amount);
		
		output.setScheduledPrintln("\nOperation done!", timeout);
		output.setScheduledPrintln("\nBalance after deposit: €" + getBalance(), timeout);
		
		scanner.close();
	}

	public void withdrawal() {
		Long amount;
		Scanner scanner = new Scanner(System.in);
		ScheduledOutput output = new ScheduledOutput();
		final Integer DEFAULT_TIMEOUT = 350;
		Integer timeout = DEFAULT_TIMEOUT;
		
		output.setScheduledPrint("\nEnter the amount you want to withdraw: €", timeout);
		amount = scanner.nextLong();
		
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
			
			output.setScheduledPrintln("\nOperation done!", timeout);
			output.setScheduledPrintln("\nBalance after withdrawal: €" + getBalance(), timeout);
		} else {
			output.setScheduledPrintln("\nTransaction failed! \nYour balance is less than €" + amount, timeout);
			output.setScheduledPrintln("Actual balance: €" + getBalance(), timeout);
		}
		
		scanner.close();
	}

	public String getHolderFullName() {
		return holderFullName;
	}

	public void setHolderFullName(String holderFullName) {
		this.holderFullName = holderFullName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
}
