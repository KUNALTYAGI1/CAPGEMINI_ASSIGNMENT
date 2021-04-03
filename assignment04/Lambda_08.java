package lambda;
import java.util.ArrayList;
import java.util.function.Consumer;
public class Lambda_08 extends Thread{

    public void run(int l){
        Consumer<Integer> mylambda = i -> System.out.println(i);
        mylambda.accept(l);
    }
    public static void main(String[] args) {
        Lambda_08 thread=new Lambda_08();  
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for(Integer l:list){
            thread.run(l);
        }     
    }
    
}


