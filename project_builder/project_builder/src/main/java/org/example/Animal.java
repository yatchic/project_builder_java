package org.example;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Animal {

    private String name;
    private int age;

    public static void main(String[] args) {
        // Используем автоматически сгенерированный конструктор без аргументов
        Animal animal = new Animal();

        // Поля остаются неинициализированными (null или 0)
        System.out.println("Name: " + animal.name); // Name: null
        System.out.println("Age: " + animal.age);   // Age: 0
    }
}
