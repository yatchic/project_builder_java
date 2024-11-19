package org.example;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsExample {


    public static boolean isPalindrome(String input) {
        if (StringUtils.isBlank(input)) {
            return false; // Пустая или null-строка не является палиндромом
        }

         String cleanedInput = StringUtils.normalizeSpace(input)
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ0-9]", "") // Учитываем русские буквы
                .toLowerCase();

         return StringUtils.reverse(cleanedInput).equals(cleanedInput);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("Hello, world!"));
        System.out.println(isPalindrome("А роза упала на лапу Азора"));
        System.out.println(isPalindrome("Лёша на полке клопа нашёл"));
        System.out.println(isPalindrome("Привет, мир!"));
    }
}
