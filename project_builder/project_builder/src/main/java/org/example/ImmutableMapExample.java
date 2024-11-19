package org.example;

import com.google.common.collect.ImmutableMap;

public class ImmutableMapExample {

    public static void main(String[] args) {

        ImmutableMap<String, Integer> languages = ImmutableMap.of(
                "Java", 1995,
                "Python", 1991,
                "JavaScript", 1995,
                "C++", 1985
        );


        System.out.println("Год создания языков программирования:");
        languages.forEach((language, year) -> System.out.println(language + ": " + year));


         ImmutableMap<String, String> countries = ImmutableMap.<String, String>builder()
                .put("USA", "Washington, D.C.")
                .put("Russia", "Moscow")
                .put("France", "Paris")
                .put("Japan", "Tokyo")
                .build();

         System.out.println("\nСтраны и их столицы:");
        countries.forEach((country, capital) -> System.out.println(country + ": " + capital));
    }
}

