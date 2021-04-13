package springcore_assignment3;


	
	import org.springframework.beans.BeansException;
	import org.springframework.context.ApplicationContext;
	//import org.springframework.context.ApplicationContext;
	import org.springframework.context.ApplicationContextAware;
	//import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class BankAccountServiceImpl implements BankAccountService,ApplicationContextAware {
		private ApplicationContext context = null;
		
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.context=applicationContext;
		}

		public double withdraw(long accountId, double balance) {
			BankAccountRepositoryIml bank =(BankAccountRepositoryIml) context.getBean("Accounts");	
			for(BankAccount b:bank.accounts)
				if(b.getAccountId()==accountId) {
					double newbalance= b.getAccountBalance() - balance;
					b.setAccountBalance(newbalance);
					System.out.println("Updated balance= "+b.getAccountBalance());
				}
			return 0;
		}

		public double deposit(long accountId, double balance) {
			// TODO Auto-generated method stub
			BankAccountRepositoryIml bank =(BankAccountRepositoryIml) context.getBean("Accounts");
			for(BankAccount b:bank.accounts)
				if(b.getAccountId()==accountId) {
					double newbalance= b.getAccountBalance() + balance;
					b.setAccountBalance(newbalance);
					System.out.println("Updated balance is "+b.getAccountBalance());
				}
			return 0;
		}

		public double getBalance(long accountId) {
			// TODO Auto-generated method stub
			BankAccountRepositoryIml bank =(BankAccountRepositoryIml) context.getBean("Accounts");
			for(BankAccount b:bank.accounts)
				if(b.getAccountId()==accountId) {
					System.out.println(b.getAccountBalance());
				}
			
			
			return 0;
		}

		public boolean fundTransfer(long fromAccount, long toAccount, double amount) {
			// TODO Auto-generated method stub
			BankAccountRepositoryIml bank =(BankAccountRepositoryIml) context.getBean("Accounts");
			for(BankAccount b:bank.accounts) {
				if(b.getAccountId()==fromAccount) {
					double newbalance= b.getAccountBalance() - amount;
					b.setAccountBalance(newbalance);
				}
				if(b.getAccountId()==toAccount) {
					double newbalance= b.getAccountBalance() + amount;
					b.setAccountBalance(newbalance);
				}
			}
				
			return false;
		}

		

	}


