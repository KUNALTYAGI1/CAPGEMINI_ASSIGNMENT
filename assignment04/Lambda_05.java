package lambda;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda_05 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb=new StringBuilder();  
        list.add("kunal");
        list.add("aman");
        list.add("raunak");
        Consumer<String> mylambda = (i) -> sb.append(i.charAt(0));

        for(String s:list){
            mylambda.accept(s);
        }
        System.out.println(sb);
    }
}
// interface firstletter{
//     void letter(String str);
// }

