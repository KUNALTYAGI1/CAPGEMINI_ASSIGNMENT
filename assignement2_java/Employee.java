package assignment2;

	
	class Employee1{
	    int basesalary = 30000;
	}
	class Manager extends Employee1{
	    int incentive=0;
	    public void setIncentive(int newincentive){
	        incentive = incentive + newincentive;
	    }
	    public void display(){
	        int total = super.basesalary + incentive;
	        System.out.println(total);
	    }
	}
	class Labour extends Employee1{
	    int overtime=0;
	    public void setOvertime(int newOvertime){
	        overtime = overtime + newOvertime;
	    }
	    public void display(){
	        int total = super.basesalary + overtime*1000;
	        System.out.println(total);
	    }
	}
	/**
	 * emp
	 */
	public class Employee {

	    public static void main(String[] args) {
	        Manager m = new Manager();
	        Labour l = new Labour();
	        m.setIncentive(10000);
	        m.display();
	        l.setOvertime(3);
	        l.display();
	    }
	}

