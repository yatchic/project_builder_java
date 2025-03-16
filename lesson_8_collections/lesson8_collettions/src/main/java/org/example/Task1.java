package org.example;

import java.util.*;
import java.util.function.Consumer;

public class Task1   {

//    В рамках выполнения задачи необходимо:
//● Создайте коллекцию мужских и женских имен с помощью интерфейса List
//● Отсортируйте коллекцию в алфавитном порядке
//● Отсортируйте коллекцию по количеству букв в слове
//● Разверните коллекцию

    public   List<String> sortListByNames(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }

    public   List<String> sortListByLength(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparingInt(String::length));
        return sortedList;
    }

    public List<String> reverseList(List<String> list) {
        List<String> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Юра");
        names.add("Лена");
        names.add("Таня");
        names.add("Михаил");
        Task1 task1=new Task1();


        System.out.println( task1.reverseList(names));
    }


}
