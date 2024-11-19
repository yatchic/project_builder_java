package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserExample {

    public static void main(String[] args) {
         String jsonString = "{\"name\": \"Иван\", \"age\": 30, \"isStudent\": false}";

         JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

         String name = jsonObject.get("name").getAsString();
        int age = jsonObject.get("age").getAsInt();
        boolean isStudent = jsonObject.get("isStudent").getAsBoolean();

         System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Студент: " + isStudent);
    }
}

