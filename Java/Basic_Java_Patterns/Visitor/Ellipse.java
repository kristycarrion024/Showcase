import java.util.List;
import java.util.ArrayList;
public class Ellipse implements Graphic {
    public void accept(GraphicVisitor visitor) {
        visitor.visit(this);
    }
}
