import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> sortedRam = new HashSet<>();
        Notebook notebook1 = new Notebook(1,"HP", 4, 256, "Windows 10", "White");
        Notebook notebook2 = new Notebook(2,"ACER", 16, 1024, "Windows 10", "Black");
        Notebook notebook3 = new Notebook(3,"Microsoft", 32, 2048, "Linux", "Gray");
        Notebook notebook4 = new Notebook(4,"ACER", 8, 512, "Mac OS", "Black");

        sortedRam.add(notebook1);
        sortedRam.add(notebook2);
        sortedRam.add(notebook3);
        sortedRam.add(notebook4);

        for(var value:sortedRam){
            System.out.println(value);
        }



        System.out.println("==============================================");

        Lesson6.SelectCriterySorted();
    }
}