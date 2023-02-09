import java.util.Comparator;

public class NotebookColorComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook n1, Notebook n2) {
        return n1.getColor().compareTo(n2.getColor());
    }
}
