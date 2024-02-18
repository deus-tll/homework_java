package org.deus.tasks;

import java.util.Scanner;

public class Task_5 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 5");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner  = new Scanner(System.in);

        System.out.print("Введіть номер місяця (від 1 до 12): ");
        int month = scanner.nextInt();

        String season;

        switch (month) {
            case 1:
            case 2:
            case 12:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Autumn";
                break;
            default:
                System.out.println("Помилка: Некоректний номер місяця!");
                return;
        }

        System.out.println("Місяць " + month + " відноситься до сезону: " + season);
    }
}
