package org.deus.tasks;

import java.util.Scanner;

public class Task_4 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 4");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шестизначне число: ");
        int number = scanner.nextInt();

        if (String.valueOf(number).length() != 6) {
            System.out.println("Помилка: Введене число не є шестизначним!");
            return;
        }

        int digit6 = number % 10;
        int digit5 = (number / 10) % 10;
        int digit4 = (number / 100) % 10;
        int digit3 = (number / 1000) % 10;
        int digit2 = (number / 10000) % 10;
        int digit1 = number / 100000;

        int newNumber = digit6 * 100000 + digit5 * 10000 + digit4 * 1000 + digit3 * 100 + digit2 * 10 + digit1;

        System.out.println("Змінене число: " + newNumber);
    }
}
