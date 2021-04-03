package lambda;
import java.util.ArrayList;

/**
 * Lambda_02
 */
class Orders {
    int orderprice;
    String orderstatus;

    Orders(int op, String os) {
        this.orderprice = op;
        this.orderstatus = os;
    }

    public int getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(int orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
}

@FunctionalInterface
interface lambdaInterface {
    boolean docheck(Orders obj);
}

/**
 * Lambda2
 */
public class Lambda_02 {

    public static void main(String[] args) {
        ArrayList<Orders> list = new ArrayList<>();
        list.add(new Orders(1, "Accepted"));
        list.add(new Orders(10000, "Accepted"));
        list.add(new Orders(10000, "Completed"));

        lambdaInterface mylambda = obj -> obj.getOrderprice() >= 10000;
        for (Orders l : list) {
            System.out.println(mylambda.docheck(l));
        }
    }
}

