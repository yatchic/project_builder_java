package org.example;

import java.util.*;

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

    public String minLengthName(List<String> list) {

        return convertListToSet(list).stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public List<String> minAndMaxLengthNames(List<String> list) {
        Set<String> namesSet = convertListToSet(list);
        List<String> result = new ArrayList<>();
        result.add(namesSet.stream().min(Comparator.comparing(String::length)).orElse(null));
        result.add(namesSet.stream().max(Comparator.comparing(String::length).reversed()).orElse(null));
        return result;
    }

    public Set<String> removeNamesByString(List<String> list, String symbol) {
        Set<String> namesSet = convertListToSet(list);
        namesSet.removeIf(s -> s.contains(symbol));
        return namesSet;
    }

    public Set<String> removeNamesByChar(List<String> list, char symbol) {
        Set<String> namesSet = convertListToSet(list);
        namesSet.removeIf(s -> s.indexOf(symbol) != -1);
        return namesSet;
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Юра");
        names.add("Лена");
        names.add("Таня");
        names.add("Михаил");
        names.add("Юра");
        names.add("Лена");
        Task2 task2=new Task2();


        System.out.println( task2.removeNamesByChar(names,'а'));
    }

}
