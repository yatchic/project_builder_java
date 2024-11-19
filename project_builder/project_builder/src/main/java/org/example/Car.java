package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {

    private String brand;
    private String model;
    private int year;

    public static void main(String[] args) {
        // Используем автоматически сгенерированный конструктор
        Car car = new Car("Toyota", "Camry", 2020);

        // Печатаем значения полей
        System.out.println("Brand: " + car.brand); // Brand: Toyota
        System.out.println("Model: " + car.model); // Model: Camry
        System.out.println("Year: " + car.year);   // Year: 2020
    }
}
