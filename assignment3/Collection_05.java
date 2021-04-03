package collection_a;
import java.util.Hashtable;

class Employee {
    // int number=1;
    String name;

    Employee(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return true;
        if (getClass() != obj.getClass())
            return true;
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null)
                return true;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}

/**
 * Collections_05
 */
public class Collection_05 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Kunal");
        Employee emp2 = new Employee("Kunal");

        Hashtable<Employee, String> dict = new Hashtable<Employee, String>();
        
        dict.put(emp1, "Developer");
        dict.put(emp2, "DS");
       
        System.out.println(dict.hashCode());
        System.out.println(emp2.equals(emp1));
    }
}

