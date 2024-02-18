package org.deus.tasks;

import java.util.Scanner;

public class Task_6 implements Runnable
{
    public static final double METERS_TO_MILES = 0.000621371;
    public static final double METERS_TO_INCHES = 39.3701;
    public static final double METERS_TO_YARDS = 1.09361;

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 6");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість метрів: ");
        double meters = scanner.nextDouble();

        System.out.println("Оберіть одиниці для переведення:");
        System.out.println("1. Милі");
        System.out.println("2. Дюйми");
        System.out.println("3. Ярди");

        int choice = scanner.nextInt();
        double result;

        switch(choice) {
            case 1:
                result = meters * METERS_TO_MILES;
                System.out.println("Результат: " + result + " миль");
                break;
            case 2:
                result = meters * METERS_TO_INCHES;
                System.out.println("Результат: " + result + " дюймів");
                break;
            case 3:
                result = meters * METERS_TO_YARDS;
                System.out.println("Результат: " + result + " ярдів");
                break;
            default:
                System.out.println("Помилка: Некоректний вибір!");
        }
    }
}
