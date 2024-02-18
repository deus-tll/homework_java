package org.deus.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task_12 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 12");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        int[] array = {5, 2, 7, 1, 9, 3};

        System.out.println("Початковий масив: " + Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть 'asc' для сортування у порядку зростання або 'desc' для сортування у порядку спадання:");
        String sortOrder = scanner.nextLine();

        if (sortOrder.equalsIgnoreCase("asc")) {
            sortAscending(array);
        } else if (sortOrder.equalsIgnoreCase("desc")) {
            sortDescending(array);
        } else {
            System.out.println("Неправильне значення. Введіть 'asc' або 'desc'.");
            return;
        }

        System.out.println("Відсортований масив: " + Arrays.toString(array));
    }

    public static void sortAscending(int[] array) {
        Arrays.sort(array);
    }

    public static void sortDescending(int[] array) {
        Arrays.sort(array);
        reverseArray(array);
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
