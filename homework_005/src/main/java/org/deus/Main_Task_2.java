package org.deus;

import org.deus.task_2.FactorialCalculator;
import org.deus.task_2.FileFiller;
import org.deus.task_2.PrimeNumberFinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main_Task_2 {
    public static void main(String[] args) {
        String inputFilePath = "files_task2/input.txt";
        String primeFilePath = "files_task2/primes.txt";
        String factorialFilePath = "files_task2/factorials.txt";

        int fileSize = 10;

        FileFiller filler = new FileFiller(inputFilePath, fileSize);
        PrimeNumberFinder primeFinder = new PrimeNumberFinder(inputFilePath, primeFilePath);
        FactorialCalculator factorialCalculator = new FactorialCalculator(inputFilePath, factorialFilePath);

        Thread fillerThread = new Thread(filler);
        Thread primeFinderThread = new Thread(primeFinder);
        Thread factorialCalculatorThread = new Thread(factorialCalculator);

        fillerThread.start();

        try {
            fillerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        primeFinderThread.start();
        factorialCalculatorThread.start();

        try {
            primeFinderThread.join();
            factorialCalculatorThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Статистика:");
        System.out.println("Кількість згенерованих випадкових чисел: " + fileSize);
        System.out.println("Кількість простих чисел: " + countLines(primeFilePath));
        System.out.println("Кількість факторіалів обчислених: " + countLines(factorialFilePath));
    }

    private static int countLines(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}