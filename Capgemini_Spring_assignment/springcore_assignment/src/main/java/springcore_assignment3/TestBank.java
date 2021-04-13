package springcore_assignment3;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBank {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("springcore_assignment3/Assignment3.xml");
		BankAccountRepositoryIml bank = (BankAccountRepositoryIml) context.getBean("Accounts");
		bank.getBalance(2);
		bank.updateBalance(2, 100);
		
		BankAccountServiceImpl obj = (BankAccountServiceImpl) context.getBean("BankAccountService");
		obj.withdraw(2, 50);
		obj.fundTransfer(2, 1, 100);
		obj.getBalance(1);
	}

}

