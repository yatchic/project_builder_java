package org.example;

import org.jetbrains.annotations.NotNull;

public class NotNullExample {

     public static void printMessage(@NotNull String message) {
        System.out.println(message);
    }

     @NotNull
    public static String getGreetingMessage() {
        return "Привет, мир!";
    }

    public static void main(String[] args) {
         printMessage("Hello, World!");


        String message = getGreetingMessage();
        System.out.println(message);
    }
}

