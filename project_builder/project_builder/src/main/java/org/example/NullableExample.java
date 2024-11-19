package org.example;

import org.jetbrains.annotations.Nullable;

public class NullableExample {

     public static void printMessage(@Nullable String message) {
        if (message != null) {
            System.out.println(message);
        } else {
            System.out.println("Сообщение не предоставлено");
        }
    }

     @Nullable
    public static String getGreetingMessage(boolean isMorning) {
        if (isMorning) {
            return "Доброе утро!";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
         printMessage("Hello, World!");
        printMessage(null);

         String greeting = getGreetingMessage(true);
        System.out.println(greeting);

        greeting = getGreetingMessage(false);
        System.out.println(greeting);
    }
}

