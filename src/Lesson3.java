import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {


    public static void SelectTasks(){
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

    /*    Задача номер 1. Реализовать алгоритм сортировки слияние   */
    private static void Task1(){

        int[] arrays = new int[]{45, 18, 49, 38, 90, 43, 21, 45, 37, 29, 17 };
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+", ");
        }
        System.out.println();
        int[] result = MergeSort(arrays);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+", ");
        }
        System.out.println();
    }


    /* Задача номер 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа   */
    private static void Task2(){
        Random random = new Random();
        ArrayList<Integer> lists = new ArrayList<>();

        for(int i=0;i<10;i++)
            lists.add(random.nextInt(20));

        System.out.println(lists.toString());

        ArrayList<Integer> result = RemoveEvenElementByList(lists);

        System.out.println(result.toString());
    }


    /* Задача номер 3. Задань целочисленный список ArrayList. Найти минимальное, максимальное и
       среднее из этого списка.    */
    private static void Task3(){
        Random random = new Random();
        ArrayList<Integer> lists = new ArrayList<>();

        for(int i=0;i<10;i++)
            lists.add(random.nextInt(20));

        System.out.println(lists.toString());
        int minElement = MinElement(lists);
        int maxElement = MaxElement(lists);
        double middle = MiddleArifmethic(lists);

        System.out.printf("Максимальный:%d, Минимальный:%d, Среднее:%.2f", maxElement, minElement, middle);

    }
    private static int MaxElement(ArrayList<Integer> lists){

        int max= lists.get(0);

        for(int i=1;i<lists.size();i++){
            if(max<lists.get(i))
                max = lists.get(i);
        }
        return max;
    }

    private static int MinElement(ArrayList<Integer> lists){

        int min= lists.get(0);

        for(int i=1;i<lists.size();i++){
            if(min>lists.get(i))
                min = lists.get(i);
        }
        return min;
    }

    private static double MiddleArifmethic(ArrayList<Integer> lists){
        int totalSum=0;

        for(var value: lists)
            totalSum+=value;

        return (double)totalSum/lists.size();
    }

    private  static ArrayList<Integer> RemoveEvenElementByList(ArrayList<Integer> lists){
        ArrayList<Integer> even = new ArrayList<Integer>();
        for(var value:lists){
            if(value%2==0)
                even.add(value);
        }
        for(int i=0;i<even.size();i++){
            lists.remove(even.get(i));
        }

        return lists;
    }


    private static int[] Merge(int[] array, int lowIndex, int middleIndex, int highIndex)
    {
        int left = lowIndex;
        int right = middleIndex+1;
        int[] tempArray = new int[highIndex - lowIndex + 1];
        int index = 0;
        while((left<=middleIndex) && (right<=highIndex))
        {
            if (array[left] < array[right])
            {
                tempArray[index] = array[left];
                left++;
            }
            else
            {
                tempArray[index] = array[right];
                right++;
            }
            index++;
        }

        for(int i=left;i<=middleIndex;i++)
        {
            tempArray[index] = array[i];
            index++;
        }

        for(int i = right; i <= highIndex; i++)
        {
            tempArray[index] = array[i];
            index++;
        }
        for (int i = 0; i < tempArray.length; i++)
            array[lowIndex + i] = tempArray[i];

        return tempArray;
    }

    private static int[] MergeSort(int[] array, int lowIndex, int highIndex)
    {

        if (lowIndex < highIndex)
        {
            int middle = (lowIndex + highIndex) / 2;

            MergeSort(array, lowIndex, middle);
            MergeSort(array, middle+1, highIndex);
            Merge(array, lowIndex, middle, highIndex);
        }
        return array;
    }

    private static int[] MergeSort(int[] array){
        return  MergeSort(array, 0, array.length-1);
    }
}
