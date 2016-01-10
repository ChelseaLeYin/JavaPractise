package Concurrency.ReadWriteLock;

public class Account {
	private String accountId;
	private Double balance;
	
	public Account(String accountId, Double balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Double getBalance() {
		System.out.println(Thread.currentThread().getName() +" getBalance balance="+ balance);
		return balance;
	}
	public void setBalance(Double balance) {
		System.out.println(Thread.currentThread().getName() +" setBalance balance="+ balance);
		this.balance = balance;
	}
}
