import java.util.Comparator;

public class NotebookHardwareComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook n1, Notebook n2) {
        if(n1.getHardware()>n2.getHardware())
            return 1;
        else if(n1.getHardware()<n2.getHardware())
            return -1;
        else
            return 0;
    }
}
