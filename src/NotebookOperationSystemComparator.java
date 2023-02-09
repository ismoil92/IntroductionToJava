import java.util.Comparator;

public class NotebookOperationSystemComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook n1, Notebook n2) {
        return n1.getOperationSystem().compareTo(n2.getOperationSystem());
    }
}
