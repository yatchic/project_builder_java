package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {


    public String findByMinPhoneNumber(Map<String, String> phonebook) {
        Set<Long> numbers = phonebook.keySet().stream()
                .map(el -> Long.valueOf(el))
                .collect(Collectors.toSet());

        long number = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();

        return String.format("Наименьший номер: %s, владелец: %s",
                number, phonebook.get(String.valueOf(number)));
    }

    public String findByMaxAlphabetName(Map<String, String> phonebook) {
        Set<Map.Entry<String, String>> elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream()
                .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .get();
        return String.format("Наибольшее имя в алфавитном порядке: %s, номер телефона %s",
                name.getValue(), name.getKey());
    }


    public static void main(String[] args) {
        Task3 task3=new Task3();
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("89186268788", "Иван");
        phonebook.put("89115825252", "Сергей");
        phonebook.put("89114785787", "Александр");
        phonebook.put("89035824574", "Петр");

        System.out.println( task3.findByMaxAlphabetName(phonebook));
    }
}
