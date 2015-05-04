import java.util.List;
import java.util.ArrayList;
public class CompositeGraphic implements Graphic {
    private List<Graphic> childGraphics = new ArrayList<Graphic>();
    
    public void accept(GraphicVisitor visitor)
    {
        visitor.visit(this);
    }

    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
    public List<Graphic> getList() {
        return childGraphics;
    }
}
