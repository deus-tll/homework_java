package org.deus.tasks;

import java.util.Scanner;

public class Task_2 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 2");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть число: ");
        double number = scanner.nextDouble();

        System.out.println("Введіть відсоток: ");
        double percentage = scanner.nextDouble();

        double result = (number * percentage) / 100;

        System.out.println("Відсоток " + percentage + "% від числа " + number + " становить: " + result);
    }
}
