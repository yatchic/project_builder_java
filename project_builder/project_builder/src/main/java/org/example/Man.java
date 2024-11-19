package org.example;

import lombok.Getter;

public class Man {

    @Getter
    private String name;

    @Getter
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Man man = new Man("John", 30);

        // Вызываем геттеры, автоматически сгенерированные Lombok
        System.out.println("Name: " + man.getName()); // Name: John
        System.out.println("Age: " + man.getAge());   // Age: 30
    }

    private int getAge() {
       return age;
    }

    private String getName() {
        return name;
    }
}
