package atmMachine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingsBalance = 0;
	
	// Set the customer number
	
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	
	// Get the customer number
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	// Set the Pin Number
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	
	// Get the Pin Number
	public int getPinNumber() {
		return pinNumber;
	}
	
	// Get Checking Account Balance
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	// Get Savings Account Balance
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	// Calculate Checking Account Withdrawal
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
	
	// Calculate Savings Account Withdrawal
	public double calcSavingsWithdraw(double amount) {
		savingsBalance = (savingsBalance - amount);
		return savingsBalance;
	}
	
	// Calculate Checking Account Deposit
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	
	// Calculate Savings Account Deposit
	public double calcSavingsDeposit(double amount) {
		savingsBalance = (savingsBalance + amount);
		return savingsBalance;
	}
	
	// Customer Checking Account Withdraw input
	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		if ((checkingBalance - amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}else {
			System.out.println("Balance cannot be negative.\n");
		}
	}
	
	// Customer Savings Account Withdraw Input
	public void getSavingsWithdrawInput() {
		System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
		System.out.print("Amount you want to withdraw from Savings Account: ");
		double amount = input.nextDouble();
		
		if ((savingsBalance - amount) >= 0) {
			calcSavingsWithdraw(amount);
			System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance));
		}else {
			System.out.println("Balance cannot be negative.\n");
		}
	}
	
	// Customer Checking Account Deposit input
	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to deposit in your Checking Account: ");
		double amount = input.nextDouble();
	
		if ((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}else {
			System.out.println("Balance cannot be negative.\n");
		}
	}
	
	// Customer Savings Account Deposit input
	public void getSavingsDepositInput() {
		System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
		System.out.print("Amount you want to deposit in your Savings Account: ");
		double amount = input.nextDouble();
		
		if ((savingsBalance + amount) >= 0) {
			calcSavingsDeposit(amount);
			System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance));
		}else {
			System.out.println("Balance cannot be negative.\n");
		}
	}
}
