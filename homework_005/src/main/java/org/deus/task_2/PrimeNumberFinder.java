package org.deus.task_2;

import java.io.*;

public class PrimeNumberFinder implements Runnable
{
    private final String filePath;
    private final String primeFilePath;

    public PrimeNumberFinder(String filePath, String primeFilePath) {
        this.filePath = filePath;
        this.primeFilePath = primeFilePath;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(primeFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (isPrime(number)) {
                    writer.write(number + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
