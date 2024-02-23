package org.deus.tasks;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task_1 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 1");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        List<Integer> numbers = generateRandomNumbers(100, -100, 100);
        System.out.println("Згенерований список чисел: \" + numbers");

        long positiveCount = numbers.stream().filter(num -> num > 0).count();
        long negativeCount = numbers.stream().filter(num -> num < 0).count();
        long twoDigitCount = numbers.stream().filter(num -> num >= 10 && num <= 99).count();
        long palindromeCount = numbers.stream().filter(this::isPalindrome).count();

        System.out.println("Кількість позитивних чисел: " + positiveCount);
        System.out.println("Кількість негативних чисел: " + negativeCount);
        System.out.println("Кількість двоцифрових чисел: " + twoDigitCount);
        System.out.println("Кількість дзеркальних чисел: " + palindromeCount);
    }

    private List<Integer> generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        return random.ints(count, min, max + 1).boxed().collect(Collectors.toList());
    }

    private boolean isPalindrome(int num) {
        String strNum = String.valueOf(num);
        return strNum.contentEquals(new StringBuilder(strNum).reverse());
    }
}
