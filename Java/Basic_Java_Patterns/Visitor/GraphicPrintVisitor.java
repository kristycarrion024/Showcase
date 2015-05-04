import java.util.List;
import java.util.ArrayList;
public class GraphicPrintVisitor implements GraphicVisitor {
    public void visit(Ellipse ellipse) {
        System.out.println("Ellipse");
    }
    public void visit(CompositeGraphic graphic) {
        List<Graphic> list = graphic.getList();
        for (Graphic i: list) {
            i.accept(this);
        }
    }
}
