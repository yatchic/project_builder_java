package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsExample {

    public static String generateRandomPassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина пароля должна быть больше 0");
        }

        String letters = RandomStringUtils.randomAlphabetic(length / 2);
        String digits = RandomStringUtils.randomNumeric(length / 4);
        String specialChars = RandomStringUtils.random(length - letters.length() - digits.length(), "!@#$%^&*()_+");

        String rawPassword = letters + digits + specialChars;
        return RandomStringUtils.random(length, rawPassword.toCharArray());
    }

    public static void main(String[] args) {
        System.out.println("Случайный пароль: " + generateRandomPassword(12));
        System.out.println("Случайный пароль: " + generateRandomPassword(8));
        System.out.println("Пример с русскими словами: Привет, мир!");
    }
}
