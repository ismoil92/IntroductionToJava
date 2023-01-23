import java.util.Scanner;
public class Lesson1 {


    public static void  SelectTasks(){
        System.out.println("1. Задача номер один\n 2. Задача номер два\n 3. Задача номер три\n 4. Задача номер четыре\n" +
                "5. Задача номер пять\n 6. Задача номер шесть");
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
            case 3:
                Task3();
                break;
            case 4:
                Task4();
                break;
            case 5:
                Task5();
                break;
            case 6:
                Task6();
                break;
            default:
                System.out.println("Нет такого задачи");
                break;
        }
    }

    /*
    1. Задача. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     */
    private static  void  Task1(){
        System.out.print("Введите число:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int result = Factorial(number);
        System.out.printf("Результат Факториала:%d", result);
    }

    /*
    2 Задача. Вывести все простые числа от 1 до 1000
    */
    private static void  Task2(){
        String result = PrimeNumber(1000);
        var arrays = result.split(", ");
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+", ");
            if(i %10 ==0 && i!=0) {
                System.out.println();
            }
        }
    }

    /* 3 Задача. Реализовать простой калькулятор*/
    private static void Task3(){
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
                 result = Calculating(a,b, '+');
                break;
            case 2:
                result = Calculating(a,b, '-');
                break;
            case 3:
                result = Calculating(a,b, '*');
                break;
            case 4:
                result = Calculating(a,b, '/');
                break;
            default:
                System.out.println("Ошибка");
                break;
        }
        System.out.printf("Результат Калькулятора:%f", result);
    }

    /* 4 Задача. Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
     Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.*/
    private static  void  Task4(){
        System.out.print("Введите Первое число:");
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        System.out.print("Введите Второе число:");
        int w = scan.nextInt();
        boolean isTrue = Equation(q,w);
        int result =0;
        if(isTrue){
            result = 2*10+q+ w*10+5;
            System.out.printf("Результат:%d", result);
        }
        else
            System.out.println("Выражение неверный");
    }

    /*5 Задача. Дан массив nums = [3,2,2,3] и число val = 3.
    Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.*/
    private static void  Task5(){
        int[] arrays = new int[]{2,3,4,5,6,2,3,4,5,1,2,3,};
        int value = 2;
        System.out.println("{2,3,4,5,6,2,3,4,5,1,2,3,}");
        int[] newArrays = CreateArray(arrays, value);
        for (int i=0;i<newArrays.length;i++){
            System.out.print(newArrays[i]+", ");
        }
        System.out.println();
    }

    /*
     6 Задача. Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
     Если общего префикса нет, вернуть пустую строку "".
    */
    private static void Task6(){
        String[] str ={"flower","flow","flight"};
        String result = LongPrefix((str));
        System.out.printf("Result:%s", result);
    }
    private static int Factorial(int N){
        if(N == 0 || N==1)
            return N;

        return N*Factorial(N-1);
    }

    //prime number
    private  static String PrimeNumber(int N){
        int count=0;
        StringBuilder output = new StringBuilder();
        for(int i=0;i<N;i++){
            int j=1;
            while(i>=j){
                if(i%j == 0)
                    count++;
                j++;
            }
            if(count == 2) {
                output.append(i+", ");
                count=0;
            }
            else
                count=0;
        }
        return output.toString();
    }

    private static double Calculating(int a, int b, char operation){
        if(operation =='+')
            return (double)a+b;
        else if(operation == '-')
            return (double)a-b;
        else if (operation =='*')
            return (double)a*b;
        else
            return (double)a/b;
    }

    private static boolean Equation(int q, int w){
        if(q == 4 && w == 4)
            return true;
        else
            return false;
    }

    private static int[] CreateArray(int[] arrays, int value){
        int[] newArray = new int[arrays.length];
        int j=0;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i] != value){
                newArray[j] = arrays[i];
                j++;
            }
        }

        for(int i=0;i<arrays.length;i++){
            if(arrays[i] == value) {
                newArray[j] = arrays[i];
                j++;
            }
        }

        return  newArray;
    }

    private static String LongPrefix(String[] arrays){
        if (arrays.length == 0)
            return "";
        String prefix = arrays[0];
        for (var str : arrays)
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
}
