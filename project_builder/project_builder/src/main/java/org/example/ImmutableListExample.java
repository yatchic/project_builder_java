package org.example;

import com.google.common.collect.ImmutableList;

public class ImmutableListExample {

    public static void main(String[] args) {

        ImmutableList<String> list = ImmutableList.of("Java", "Python", "JavaScript", "C++");


        System.out.println("Список языков программирования: " + list);



         ImmutableList<String> anotherList = ImmutableList.<String>builder()
                .add("HTML")
                .add("CSS")
                .add("TypeScript")
                .build();

         System.out.println("Список языков веб-разработки: " + anotherList);


    }
}

