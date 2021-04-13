package springcore_assignment5;
import javax.inject.Named;

@Named
public class Rectangle {
    private int length;
    private int breath;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreath() {
        return breath;
    }
    public void setBreath(int breath) {
        this.breath=breath;
    }
}
