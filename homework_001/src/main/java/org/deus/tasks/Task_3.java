package org.deus.tasks;

import java.util.Scanner;

public class Task_3 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 3");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть першу цифру: ");
        int digit_1 = scanner.nextInt();

        System.out.println("Введіть другу цифру: ");
        int digit_2 = scanner.nextInt();

        System.out.println("Введіть третю цифру: ");
        int digit_3 = scanner.nextInt();

        int number = digit_1 * 100 + digit_2 * 10 + digit_3;

        System.out.println("Число, сформоване з введених цифр: " + number);
    }


}
