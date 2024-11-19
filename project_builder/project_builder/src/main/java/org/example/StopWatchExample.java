package org.example;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchExample {


    public static void performTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Задача была прервана: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Создаём и запускаем StopWatch
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.out.println("Начало выполнения задачи...");
        performTask();


        stopWatch.stop();


        System.out.println("Задача завершена за: " + stopWatch.getTime() + " миллисекунд.");
    }
}

