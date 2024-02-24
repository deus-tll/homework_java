package org.deus.task_2;

import java.io.IOException;

import java.io.*;

public class FactorialCalculator implements Runnable
{
    private final String filePath;
    private final String factorialFilePath;

    public FactorialCalculator(String filePath, String factorialFilePath) {
        this.filePath = filePath;
        this.factorialFilePath = factorialFilePath;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(factorialFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                int factorial = calculateFactorial(number);
                writer.write(factorial + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
