//Written by: Su Win

public class Account{
	
	private static int account_count = 0;
	private double balance = 1000;
	private int id = 0;
	
	//Constructors
	public Account() {
		Account.account_count++;
		this.id = Account.account_count;
	}
	
	public Account(double startingBalance) {
		this();
		this.balance = startingBalance;
	}

	//Methods
	/* withdraw(double amount) should subtract money to the balance 
	 * if there is enough money in the account and return true if so. 
	 * If the withdrawal exceeds the balance, 
	 * the withdraw method should return false.
	 */
	public boolean withdraw(double amount) {
		if(amount <= this.balance) {
			this.balance = this.balance - amount;
			return true;
		}else {
			return false;
		}
	}
	
	//method to get the balance money
	public double getBalance() {
		return this.balance;
	}
	
	//deposit(double amount) should add money to the balance
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
	
	//method to get id
	public int getId(){
		return this.id;
	}
	
	
}
