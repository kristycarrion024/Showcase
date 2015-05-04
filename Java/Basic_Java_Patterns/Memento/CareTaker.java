import java.util.List;
import java.util.ArrayList;
public class CareTaker {
    private List<Object> savedStates = new ArrayList<Object>();
    public void addMemento(Object m) {
        savedStates.add(m);
    }
    public Object getMemento(int index) {
        return savedStates.get(index);
    }
}
