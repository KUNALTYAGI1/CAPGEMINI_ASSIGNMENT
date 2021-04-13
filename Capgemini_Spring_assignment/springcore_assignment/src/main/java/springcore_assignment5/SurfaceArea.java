package springcore_assignment5;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SurfaceArea {
    Rectangle rectangle;
    Rectangle newRectangle;

    @Inject
    @Resource(name = "rectangle")
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    public int display() {
        return rectangle.getLength() * rectangle.getBreath();
    }


}

