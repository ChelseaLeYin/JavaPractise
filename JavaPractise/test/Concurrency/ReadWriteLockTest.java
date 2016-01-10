package Concurrency;

import Concurrency.ReadWriteLock.Account;
import Concurrency.ReadWriteLock.User;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		Account myAccount1 = new Account("456321", 100.2);
		final User allen = new User("Allen", myAccount1);
		allen.queryAccount();//thread 0
		allen.updateAccountBalance(200.2); //thread 1
		allen.queryAccount(); //thread 2
		allen.updateAccountBalance(300.2); // thread 3
		
		// thread 0 and thread 2 could read the account together
		// thread 1 and thread 3 have to update the account balance seperately. 
	}
}
