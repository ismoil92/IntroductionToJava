import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Lesson4 {

    public static void SelectTask(){
        System.out.println("1-Задача\n2-Задача\n3-Задача");
        System.out.print("Выберите задачи:");
        Scanner scan = new Scanner(System.in);
        int selectTask = scan.nextInt();

        switch (selectTask){
            case 1:
                Task1();
                break;
            case 2:
                Task2();
                break;
            case 3:
                Task3();
                break;
            default:
                break;
        }
    }

    /* Задача номер 1. Пусть дан LinkedList с несколькими элементами.
       Реализуйте метод, который вернет “перевернутый” список.*/
    private static void Task1(){
        LinkedList<Integer> linked = new LinkedList<>();

        linked.add(34);
        linked.add(45);
        linked.add(65);
        linked.add(3);
        linked.add(5);
        linked.add(8);
        linked.add(1);

        System.out.println(linked);
        LinkedList<Integer> linkedList = ReverseLinkedList(linked);
        System.out.println(linkedList);
    }

    /* Задача номер 2.Реализуйте очередь с помощью LinkedList со следующими методами:
       enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди
       и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.  */
    private static void Task2(){
        Enqueue(1);
        Enqueue(2);
        Enqueue(3);
        Enqueue(4);
        System.out.println(QueueLinked);
        Dequeue();
        System.out.println(QueueLinked);
        Dequeue();
        System.out.println(First());
    }

    /* Задача номер 3. В калькулятор добавьте возможность отменить последнюю операцию.  */
    private static void Task3(){
        System.out.print("Введите Первое число:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.print("Введите Второе число:");
        int b = scan.nextInt();
        //System.out.print("1. (+), 2. (-), 3. (*), 4. (/)\n");
        System.out.print("Введите символа:");
        String  opt = scan.next();
        System.out.printf("Вы уверены что хотите %s символ использовать? y/n:", opt);
        String yesOrNo = scan.next();
        if(yesOrNo == "n"){
            System.out.print("Повторите ввод символа:");
            opt = scan.next();
        }
        double result=0;
        switch (opt){
            case "+":
                result = CalculatingAndWriteToLogger(a,b, '+');
                break;
            case "-":
                result = CalculatingAndWriteToLogger(a,b, '-');
                break;
            case "*":
                result = CalculatingAndWriteToLogger(a,b, '*');
                break;
            case "/":
                result = CalculatingAndWriteToLogger(a,b, '/');
                break;
            default:
                System.out.println("Ошибка");
                break;
        }
        System.out.printf("Результат Калькулятора:%f\n", result);
    }


    private static Queue<Integer> QueueLinked = new LinkedList<>();
    private static LinkedList<Integer> ReverseLinkedList(LinkedList<Integer> linked){
        LinkedList<Integer> newLinked = new LinkedList<>();
        int i=0;
        while (0<linked.size())
            newLinked.add(linked.removeLast());

        return newLinked;
    }

    private static void Enqueue(int value){
        QueueLinked.add(value);
    }

    private static Integer Dequeue(){
        return QueueLinked.remove();
    }

    private static Integer First(){
        return QueueLinked.peek();
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
