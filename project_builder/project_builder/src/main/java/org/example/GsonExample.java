package org.example;

import com.google.gson.Gson;

class Person2 {
    private String name;
    private int age;


    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class GsonExample {

    public static void main(String[] args) {

        Person2 person = new Person2("Иван", 30);


        Gson gson = new Gson();


        String json = gson.toJson(person);
        System.out.println("Сериализованный объект в JSON: " + json);


        Person2 deserializedPerson = gson.fromJson(json, Person2.class);
        System.out.println("Десериализованный объект: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());
    }
}
