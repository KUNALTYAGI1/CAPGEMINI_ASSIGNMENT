package springcore_assignment3;
import java.util.List;

public class BankAccountRepositoryIml implements BankAccountRepository{
	
	public List<BankAccount> accounts;

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		for(BankAccount b:accounts)
			if(b.getAccountId()==accountId) {
				System.out.println("Available balance= "+b.getAccountBalance());
			}
		return 0;
	}

	public double updateBalance(long accountId, double newBalance) {
		// TODO Auto-generated method stub
		for(BankAccount b:accounts)
			if(b.getAccountId()==accountId) {
				double balance= b.getAccountBalance()+newBalance;
				b.setAccountBalance(balance);
				System.out.println("Updated balance= "+b.getAccountBalance());
			}
		return 0;
	}

}

