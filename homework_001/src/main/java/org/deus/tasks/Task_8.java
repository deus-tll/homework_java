package org.deus.tasks;

import java.util.Scanner;

public class Task_8 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 8");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть початок діапазону: ");
        int start = scanner.nextInt();
        System.out.print("Введіть кінець діапазону: ");
        int end = scanner.nextInt();

        // Нормалізація діапазону
        if (start > end) {
            System.out.println("Діапазон некоректний. Проводимо нормалізацію...");
            int temp = start;
            start = end;
            end = temp;
            System.out.println("Початок діапазону: " + start + ", Кінець діапазону: " + end);
        }

        System.out.println("Таблиця множення від " + start + " до " + end + ":");

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d * %d = %d   ", i, j, i * j);
            }
            System.out.println();
        }
    }
}
