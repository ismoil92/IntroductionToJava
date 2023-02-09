import java.util.*;

public class Lesson6 {


    public static void SelectCriterySorted(){
        Map<Integer, String> critery = new HashMap<>();
        critery.put(1,"ОЗУ");
        critery.put(2, "Объём ЖД");
        critery.put(3, "Операционная система");
        critery.put(4, "Цвет");

        System.out.println("1-ОЗУ\n2-Объём ЖД\n3-Операционная система\n4-Цвет");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите номер критерии:");
        int selectCritery = scanner.nextInt();
        for(Map.Entry<Integer, String> entry: critery.entrySet()){
            if(selectCritery == entry.getKey() && selectCritery == 1){
                sortedByRAM();
            }
            else if(selectCritery == entry.getKey() && selectCritery == 2){
                sortedByHardware();
            }
            else if (selectCritery == entry.getKey() && selectCritery == 3){
                sortedBYOperationSystem();
            }
            else if((selectCritery == entry.getKey() && selectCritery == 4)){
                sortedByColor();
            }
        }
    }
    private static void sortedByRAM(){
        Comparator<Notebook> ramComparator = new NotebokRamComparator();
        Set<Notebook> sortedRam = new TreeSet<>(ramComparator);
        Notebook notebook1 = new Notebook(1,"HP", 4, 256, "Windows 10", "White");
        Notebook notebook2 = new Notebook(2,"ACER", 16, 1024, "Windows 10", "Black");
        Notebook notebook3 = new Notebook(3,"Microsoft", 32, 2048, "Linux", "Gray");
        Notebook notebook4 = new Notebook(4,"ACER", 8, 512, "Mac OS", "Black");

        sortedRam.add(notebook1);
        sortedRam.add(notebook2);
        sortedRam.add(notebook3);
        sortedRam.add(notebook4);

        for(var value:sortedRam){
            if(value.getRam()>4)
                System.out.println(value);
        }
    }

    private static void sortedByHardware(){
        Comparator<Notebook> hardwareComparator = new NotebookHardwareComparator();

        Set<Notebook> sortedRam = new TreeSet<>(hardwareComparator);
        Notebook notebook1 = new Notebook(1,"HP", 4, 256, "Windows 10", "White");
        Notebook notebook2 = new Notebook(2,"ACER", 16, 1024, "Windows 10", "Black");
        Notebook notebook3 = new Notebook(3,"Microsoft", 32, 2048, "Linux", "Gray");
        Notebook notebook4 = new Notebook(4,"ACER", 8, 512, "Mac OS", "Black");

        sortedRam.add(notebook1);
        sortedRam.add(notebook2);
        sortedRam.add(notebook3);
        sortedRam.add(notebook4);

        for(var value:sortedRam){
            if(value.getHardware()>256)
                System.out.println(value);
        }
    }

    private static void sortedBYOperationSystem(){
        Comparator<Notebook> operationSystemComparator = new NotebookOperationSystemComparator();

        Set<Notebook> sortedRam = new TreeSet<>(operationSystemComparator);
        Notebook notebook1 = new Notebook(1,"HP", 4, 256, "Windows 10", "White");
        Notebook notebook2 = new Notebook(2,"ACER", 16, 1024, "Windows 8", "Black");
        Notebook notebook3 = new Notebook(3,"Microsoft", 32, 2048, "Linux", "Gray");
        Notebook notebook4 = new Notebook(4,"ACER", 8, 512, "Mac OS", "Black");

        sortedRam.add(notebook1);
        sortedRam.add(notebook2);
        sortedRam.add(notebook3);
        sortedRam.add(notebook4);

        for(var value:sortedRam){
            if(value.getOperationSystem().length()>5)
                System.out.println(value);
        }
    }

    private static void sortedByColor(){
        Comparator<Notebook> colorComparator = new NotebookColorComparator();

        Set<Notebook> sortedRam = new TreeSet<>(colorComparator);
        Notebook notebook1 = new Notebook(1,"HP", 4, 256, "Windows 10", "White");
        Notebook notebook2 = new Notebook(2,"ACER", 16, 1024, "Windows 10", "Black");
        Notebook notebook3 = new Notebook(3,"Microsoft", 32, 2048, "Linux", "Gray");
        Notebook notebook4 = new Notebook(4,"ACER", 8, 512, "Mac OS", "Yellow");

        sortedRam.add(notebook1);
        sortedRam.add(notebook2);
        sortedRam.add(notebook3);
        sortedRam.add(notebook4);

        for(var value:sortedRam){
            if(value.getColor().length()>4)
                System.out.println(value);
        }
    }
}
