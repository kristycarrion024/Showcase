import java.util.List;
import java.util.ArrayList;
public interface GraphicVisitor {
    public void visit(Ellipse ellipse);
    public void visit(CompositeGraphic graphic);
}
