import java.util.Comparator;

public class NotebokRamComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook n1, Notebook n2) {
        if(n1.getRam()>n2.getRam())
            return 1;
        else if(n1.getRam()<n2.getRam())
            return -1;
        else
            return 0;
    }
}
