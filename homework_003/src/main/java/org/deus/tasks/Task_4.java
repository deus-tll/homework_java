package org.deus.tasks;

import java.util.function.Predicate;

public class Task_4 implements Runnable
{
    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 4");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        int[] numbers = {1, -2, 3, -4, 5, -6, 7, -8, 9, -10};


        int sumEqualsTo5 = sumMatching(numbers, num -> num == 5);
        System.out.println("Sum of numbers equal to 5: " + sumEqualsTo5);


        int sumNotInRange = sumMatching(numbers, num -> !(num >= -3 && num <= 3));
        System.out.println("Sum of numbers not in range from -3 to 3: " + sumNotInRange);


        int sumPositiveNumbers = sumMatching(numbers, num -> num > 0);
        System.out.println("Sum of positive numbers: " + sumPositiveNumbers);


        int sumNegativeNumbers = sumMatching(numbers, num -> num < 0);
        System.out.println("Sum of negative numbers: " + sumNegativeNumbers);
    }

    private int sumMatching(int[] numbers, Predicate<Integer> condition) {
        int sum = 0;
        for (int number : numbers) {
            if (condition.test(number)) {
                sum += number;
            }
        }

        return sum;
    }
}
