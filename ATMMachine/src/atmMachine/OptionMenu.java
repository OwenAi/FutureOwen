package atmMachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat monyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<>();
	
	int selection;
	// Validates Login information: customer number and pin number
	
	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(987654321, 8675);
				data.put(123456789, 1234);
			
				System.out.println("Welcome to the ATM Project!");
			
				System.out.println("Enter Your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.print("Enter Your Pin Number: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x = 2;
			}
			for (@SuppressWarnings("unused") Entry<Integer, Integer> entry : data.entrySet()) {
				getAccountType();
			}
			System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
		} while (x == 1);
	}
	
	// Display Account Type Menu with selection 
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		
		selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSavings();
			break;
		case 3:
			System.out.println("Thank You for using this ATM, bye.");
			menuInput.close();
			break;
		default:
				System.out.println("\nInvalid Choice.\n");
				getAccountType();
		}	
	}
	
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM. Bye.");
			menuInput.close();
			break;
		default:
			System.out.println("\nInvalid choice.\n");
			getChecking();
		}
	}
	
	// Display Savings Account Menu with selections. 
	
	public void getSavings() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
			getAccountType();
			break;
		case 2:
			getSavingsWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingsDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for using this ATM. Bye.");
			menuInput.close();
			break;
		default:
			System.out.println("\nInvalid choice.\n");
			getChecking();
			
		}
	}
}
