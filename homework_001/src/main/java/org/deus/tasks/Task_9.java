package org.deus.tasks;

import java.util.Random;

public class Task_9 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 9");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        int size = 20;
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        int min = array[0];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;
        for (int num : array) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Кількість негативних елементів: " + negativeCount);
        System.out.println("Кількість позитивних елементів: " + positiveCount);
        System.out.println("Кількість нулів: " + zeroCount);
    }
}
