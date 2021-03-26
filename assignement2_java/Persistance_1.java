package assignment2;

	abstract class Persistence{
	    abstract void persist();
	}
	class FilePersistence extends Persistence{
	    public void persist(){
	        System.out.println("Saved in file");
	    }
	}
	class DatabasePersistence extends Persistence{
	    public void persist(){
	        System.out.println("Saved in Database");
	    }
	}
	/**
	 * question_six
	 */
	public class Persistance_1 {
	    public static void main(String[] args) {
	        Persistence p;
	        p = new FilePersistence();
	        p.persist();
	        p = new DatabasePersistence();
	        p.persist();
	    }

	
}
