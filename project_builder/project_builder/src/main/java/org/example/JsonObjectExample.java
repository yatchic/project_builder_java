package org.example;

import com.google.gson.JsonObject;

public class JsonObjectExample {

    public static void main(String[] args) {

        JsonObject jsonObject = new JsonObject();


        jsonObject.addProperty("name", "Иван");
        jsonObject.addProperty("age", 30);
        jsonObject.addProperty("isStudent", false);


        System.out.println("Созданный JSON-объект: " + jsonObject);


        String name = jsonObject.get("name").getAsString();
        int age = jsonObject.get("age").getAsInt();
        boolean isStudent = jsonObject.get("isStudent").getAsBoolean();


        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Студент: " + isStudent);
    }
}

