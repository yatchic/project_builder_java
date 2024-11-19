package org.example;

import com.google.common.base.Strings;

public class StringsExample {

    public static void main(String[] args) {

        String str1 = null;
        String str2 = "";
        String str3 = "Hello, Вася!";

        System.out.println("Является ли str1 null или пустой? " + Strings.isNullOrEmpty(str1)); // true
        System.out.println("Является ли str2 null или пустой? " + Strings.isNullOrEmpty(str2)); // true
        System.out.println("Является ли str3 null или пустой? " + Strings.isNullOrEmpty(str3)); // false

         String str4 = "   ";
        System.out.println("Является ли str4 null, пустой или пробельной? " + Strings.isNullOrEmpty(str4)); // false
        System.out.println("Является ли str4 пробельной? " + Strings.isNullOrEmpty(str4.trim())); // true

         String str5 = "Guava";
        String paddedString = Strings.padEnd(str5, 10, '-');
        System.out.println("Строка с дополнением в конец: " + paddedString); // "Guava-----"

         String paddedStringStart = Strings.padStart(str5, 10, '-');
        System.out.println("Строка с дополнением в начало: " + paddedStringStart); // "-----Guava"

         String str6 = null;
        String defaultStr = Strings.nullToEmpty(str6);
        System.out.println("Заменённая строка: " + defaultStr); // ""
    }
}

