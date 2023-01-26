import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Lesson2 {


    public static void SelectTask(){
        System.out.println("1. Задача про Пузырковой сортировки, и каждую итерацию записать в файл логгер\n 2. Создать Калькулатор и записать в логгер файл\n");
        Scanner scan = new Scanner((System.in));
        System.out.print("Выберите задачу:");
        int selectNumb = scan.nextInt();
        switch (selectNumb){
            case 1:
                Task1();
                break;
            case 2:
                Task2();
                break;
            default:
                System.out.println("Нет такого задачи");
                break;
        }
    }



    /* 1 Задача. Реализуйте алгоритм сортировки пузырьком числового массива,
     результат после каждой итерации запишите в лог-файл. */
    private static void Task1(){
        int[] arrays = new int[]{8,9,1,5,7,2,4,3,0,6};
        BubbleSortAndWriteToLogger(arrays);
    }


    /* 2 Задача. К калькулятору из предыдущего дз добавить логирование. */
    private static void Task2(){
        System.out.print("Введите Первое число:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.print("Введите Второе число:");
        int b = scan.nextInt();
        System.out.print("1. (+), 2. (-), 3. (*), 4. (/)\n");
        System.out.print("Введите номер символа:");
        int opt = scan.nextInt();
        double result=0;
        switch (opt){
            case 1:
                result = CalculatingAndWriteToLogger(a,b, '+');
                break;
            case 2:
                result = CalculatingAndWriteToLogger(a,b, '-');
                break;
            case 3:
                result = CalculatingAndWriteToLogger(a,b, '*');
                break;
            case 4:
                result = CalculatingAndWriteToLogger(a,b, '/');
                break;
            default:
                System.out.println("Ошибка");
                break;
        }
        System.out.printf("Результат Калькулятора:%f\n", result);
    }


    private  static void  BubbleSortAndWriteToLogger(int[] arrays){
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try{
            fh = new FileHandler("C:/Users/User/IdeaProjects/IntroductionToJava/BubbleSort.txt");

            logger.addHandler(fh);
            SimpleFormatter simple = new SimpleFormatter();
            fh.setFormatter(simple);
            for(int i=0;i<arrays.length;i++){
                for(int j=0;j<arrays.length-1-i;j++){
                    if(arrays[j]>arrays[j+1]){
                        int temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                    }
                }
                logger.info("Шаг "+i+", "+Arrays.toString(arrays));
            }
        }
        catch(Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    private static double CalculatingAndWriteToLogger(int a, int b, char operation) {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try {
            fh = new FileHandler("C:/Users/User/IdeaProjects/IntroductionToJava/Calculating.txt");

            logger.addHandler(fh);
            SimpleFormatter simple = new SimpleFormatter();
            fh.setFormatter(simple);
            if (operation == '+') {
                logger.info(Double.toString(a + b));
                return (double) a + b;
            } else if (operation == '-') {
                logger.info(Double.toString(a - b));
                return (double) a - b;
            } else if (operation == '*') {
                logger.info(Double.toString(a * b));
                return (double) a * b;
            } else {
                logger.info(Double.toString((double)a / (double) b));
                return (double) a / b;
            }
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return 0;
    }

}
