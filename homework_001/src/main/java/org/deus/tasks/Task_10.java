package org.deus.tasks;

import java.util.Arrays;
import java.util.Random;

public class Task_10 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 10");
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

        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];
        int[] negativeNumbers = new int[size];
        int[] positiveNumbers = new int[size];

        int evenIndex = 0;
        int oddIndex = 0;
        int negativeIndex = 0;
        int positiveIndex = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers[evenIndex++] = num;
            } else {
                oddNumbers[oddIndex++] = num;
            }
            if (num < 0) {
                negativeNumbers[negativeIndex++] = num;
            } else if (num > 0) {
                positiveNumbers[positiveIndex++] = num;
            }
        }

        evenNumbers = Arrays.copyOf(evenNumbers, evenIndex);
        oddNumbers = Arrays.copyOf(oddNumbers, oddIndex);
        negativeNumbers = Arrays.copyOf(negativeNumbers, negativeIndex);
        positiveNumbers = Arrays.copyOf(positiveNumbers, positiveIndex);

        System.out.println("Масив парних чисел: " + Arrays.toString(evenNumbers));
        System.out.println("Масив непарних чисел: " + Arrays.toString(oddNumbers));
        System.out.println("Масив негативних чисел: " + Arrays.toString(negativeNumbers));
        System.out.println("Масив позитивних чисел: " + Arrays.toString(positiveNumbers));
    }
}
