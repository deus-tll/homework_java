package org.deus.tasks;

import java.util.Scanner;

public class Task_7 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 7");
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


        System.out.println("Непарні числа у діапазоні від " + start + " до " + end + ":");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
