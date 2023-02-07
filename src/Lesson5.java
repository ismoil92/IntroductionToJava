import java.util.*;

public class Lesson5 {



    public static void SelectTasks(){
        System.out.println("1.Задач номер один\n2.Задача номер два\n3.Задача номер три\n" +
                "4.Задача номер четыре\n5.Задача номер пять");
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите номер задачи:");
        int selectTasks = scan.nextInt();
        switch (selectTasks){
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
            default:
                break;
        }
    }
    private static HashMap<Integer, String> Phonebook = new HashMap<>();

    private static void Add(int phoneNumber, String FullName){
        Phonebook.put(phoneNumber, FullName);
    }
    private static void Remove(int key){
        Phonebook.remove(key);
    }

    private static void Sort(int[] array){
        int n= array.length;

        for(int i=n/2-1;i>=0;i--){
            Heapify(array, n, i);
        }

        for(int i=n-1;i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            Heapify(array, i, 0);
        }
    }

    private static void Heapify(int[] array, int n, int i){
        int largest =i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && array[l]>array[largest]){
            largest=l;
        }

        if(r<n && array[r]>array[largest]){
            largest=r;
        }

        if(largest!=i){
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            Heapify(array, n, largest);
        }
    }

    private static HashMap<String, Integer> CreatePersonalHashMap(Map<String, String> personals, ArrayList<String> lists){
        HashMap<String, Integer> personalsHashMap = new HashMap<>();
        ArrayList<Integer> indexs = new ArrayList<>();
        String text = "";

        for(Map.Entry< String, String> value: personals.entrySet() ){
            int count=0;
            for(int i=0;i<lists.size();i++){
                if(Objects.equals(value.getValue(), lists.get(i))){
                    count++;
                    indexs.add(i);
                    text= value.getValue();
                }
            }
            for(int i=0;i<indexs.size();i++){
                lists.remove(indexs.get(i));
            }
            indexs.clear();
            if (count>1) {
                personalsHashMap.put(text, count);
            }
        }
        return personalsHashMap;
    }

    private static String ConvertToRomeDigitFromArabicDigit(int number){
        String romeDigit = "";
        List<Integer> lists = new ArrayList<>();
        int numb =0;
        int i=0;
        while(number>0){
            numb = number%10;
            lists.add(numb);
            number/=10;
        }
        int count=0;
        if(lists.size()==4){
            for(i=lists.size()-1;i>=0;i--){
                if(i==3){
                    count = lists.get(i);
                    while(count>0){
                        romeDigit+="M";
                        count--;
                    }
                }
                else if(i==2){
                    count = lists.get(i);
                    if(count == 5){
                        romeDigit+="D";
                    }
                    else{
                        while(count>0){
                            romeDigit+="C";
                            count--;
                        }
                    }
                }
                else if(i==1){
                    count = lists.get(i);
                    if(count == 5){
                        romeDigit+="L";
                    }
                    else if(count == 4){
                        romeDigit+="XL";
                    }
                    else{
                        while(count>0){
                            romeDigit+="X";
                            count--;
                        }
                    }
                }
                else {
                    count = lists.get(i);
                    if(count == 9){
                        romeDigit+="IX";
                    }
                    else if(count == 4){
                        romeDigit+="IV";
                    }
                    else if(count == 5){
                        romeDigit+="V";
                    }
                    else {
                        while(count>0){
                            romeDigit+="I";
                            count--;
                        }
                    }
                }
            }
        }
        else if(lists.size() == 3){
            for(i = lists.size()-1;i>=0;i--){
                if(i==2){
                    count = lists.get(i);
                    if(count == 5){
                        romeDigit+="D";
                    }
                    else{
                        while(count>0){
                            romeDigit+="C";
                            count--;
                        }
                    }
                }
                else if(i==1){
                    count = lists.get(i);
                    if(count == 5){
                        romeDigit+="L";
                    }
                    else if(count == 4){
                        romeDigit+="XL";
                    }
                    else{
                        while(count>0){
                            romeDigit+="X";
                            count--;
                        }
                    }
                }
                else {
                    count = lists.get(i);
                    if(count == 9){
                        romeDigit+="IX";
                    }
                    else if(count == 4){
                        romeDigit+="IV";
                    }
                    else if(count == 5){
                        romeDigit+="V";
                    }
                    else {
                        while(count>0){
                            romeDigit+="I";
                            count--;
                        }
                    }
                }
            }
        }
        else if(lists.size() == 2){
            for(i=lists.size()-1;i>=0;i--){
                if(i==1){
                    count = lists.get(i);
                    if(count == 5){
                        romeDigit+="L";
                    }
                    else if(count == 4){
                        romeDigit+="XL";
                    }
                    else{
                        while(count>0){
                            romeDigit+="X";
                            count--;
                        }
                    }
                }
                else {
                    count = lists.get(i);
                    if(count == 9){
                        romeDigit+="IX";
                    }
                    else if(count == 4){
                        romeDigit+="IV";
                    }
                    else if(count == 5){
                        romeDigit+="V";
                    }
                    else {
                        while(count>0){
                            romeDigit+="I";
                            count--;
                        }
                    }
                }
            }
        }
        else {
            for(i=lists.size()-1;i>=0;i--){
                count = lists.get(i);
                if(count == 9){
                    romeDigit+="IX";
                }
                else if(count == 4){
                    romeDigit+="IV";
                }
                else if(count == 5){
                    romeDigit+="V";
                }
                else {
                    while(count>0){
                        romeDigit+="I";
                        count--;
                    }
                }
            }
        }
        return romeDigit;
    }

    private static void ParseStringAndCreateTreeMap(){
        String text ="Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.";
        String[] textArray = text.split(" ");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<textArray.length;i++){
            int count = textArray[i].toCharArray().length;
            map.put(textArray[i], count);
        }

        Map<String, Integer> treeMap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (s1.length() < s2.length()) {
                            return -1;
                        } else if (s1.length() > s2.length()) {
                            return 1;
                        } else {
                            return s1.compareTo(s2);
                        }
                    }
                });

        treeMap.putAll(map);

        System.out.println(treeMap);
    }

    /* Задача номер 1. Реализуйте структуру телефонной книги с помощью HashMap,
       учитывая, что 1 человек может иметь несколько телефонов. */
    private static void Task1(){
        Add(223344, "Ivanov");
        Add(334445, "Ivanov");
        Add(111111, "Ivanov");
        Add(222222, "Petrov");
        Add(445544, "Sidorov");
        Add(7890654, "Karpov");

        System.out.println(Phonebook);
    }


    /* Задача номер 2. Пусть дан список сотрудников. Написать программу, которая найдет
       и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
     */
    private static void Task2(){

        var lists = CreateArrayList();
        var persons = CreateHashMap();

        var sortedPersonals = CreatePersonalHashMap(persons, lists);

        ArrayList<Integer> counts = new ArrayList<>();
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry: sortedPersonals.entrySet()){
            counts.add(entry.getValue());
        }

        Collections.reverse(counts);

        for(int num:counts){
            for(Map.Entry<String, Integer> entry:sortedPersonals.entrySet()){
                if(entry.getValue().equals(num)){
                    sorted.put(entry.getKey(), num);
                }
            }
        }
        System.out.println(sorted);
    }


    /* Задача номер 3. Реализовать алгоритм пирамидальной сортировки (HeapSort). */
    private static void Task3(){

        int[] array = new int[]{12,11,13,5,6,7,8,2,1,4};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
        Sort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }

    /* Задача номер 4. Написать метод, который переведёт данное целое число в римский формат. */
    private static void Task4(){
        //2022, 4, 2024
        System.out.println(ConvertToRomeDigitFromArabicDigit(2022));
        System.out.println();
        System.out.println(ConvertToRomeDigitFromArabicDigit(2024));
        System.out.println();
        System.out.println(ConvertToRomeDigitFromArabicDigit(4));
    }

    private static void Task5(){
        ParseStringAndCreateTreeMap();
    }

    private static ArrayList<String> CreateArrayList(){
        ArrayList<String> lists = new ArrayList<>();

        lists.add("Иван");
        lists.add("Светлана");
        lists.add("Кристина");
        lists.add("Анна");
        lists.add("Анна");
        lists.add("Иван");
        lists.add("Петр");
        lists.add("Павел");
        lists.add("Петр");
        lists.add("Мария");
        lists.add("Марина");
        lists.add("Мария");
        lists.add("Мария");
        lists.add("Марина");
        lists.add("Анна");
        lists.add("Иван");
        lists.add("Петр");
        lists.add("Иван");

        return lists;
    }

    private static HashMap<String, String> CreateHashMap(){

        HashMap<String, String> personals = new HashMap<>();
        personals.put("Иванов","Иван");
        personals.put("Петрова","Светлана");
        personals.put("Белова","Кристина");
        personals.put("Мусина","Анна");
        personals.put("Крутова","Анна");
        personals.put("Юрин","Иван");
        personals.put("Лыков","Петр");
        personals.put("Чернов","Павел");
        personals.put("Чернышев","Петр");
        personals.put("Федорова","Мария");
        personals.put("Светлова","Марина");
        personals.put("Савина","Мария");
        personals.put("Лыкова","Мария");
        personals.put("Лугова","Мария");
        personals.put("Владимирова","Анна");
        personals.put("Мечников","Иван");
        personals.put("Петин","Петр");
        personals.put("Ежов","Иван");

        return personals;
    }
}
