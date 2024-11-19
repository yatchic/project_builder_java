package org.example;

import lombok.Setter;

public class Person {

    @Setter
    private String name;

    @Setter
    private int age;

    public static void main(String[] args) {
        Person person = new Person();

        // Используем сгенерированные сеттеры
        person.setName("Alice");
        person.setAge(25);

        // Печатаем значения
        System.out.println("Name: " + person.name); // Name: Alice
        System.out.println("Age: " + person.age);   // Age: 25
    }

    private void setAge(int i) {
        this.age=i;
    }

    private void setName(String alice) {
        this.name=alice;
    }
}
