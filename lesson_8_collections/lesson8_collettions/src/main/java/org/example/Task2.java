package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2 {
//    В рамках выполнения задачи необходимо:
// ● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
//    добавьте повторяющиеся значения
//● Получите уникальный список Set на основании List
//● Определите наименьший элемент (алфавитный порядок)
//● Определите наибольший элемент (по количеству букв в слове но в обратном
//            порядке)
//● Удалите все элементы содержащие букву ‘A’

Set<String> convertListToSet(List<String> list){
    Set<String>result= new HashSet<>(list);
return result;
}


    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Юра");
        names.add("Лена");
        names.add("Таня");
        names.add("Михаил");
        names.add("Юра");
        names.add("Лена");
        Task1 task1=new Task1();


        System.out.println( task1.reverseList(names));
    }

}
