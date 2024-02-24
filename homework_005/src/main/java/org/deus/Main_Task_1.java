package org.deus;

import org.deus.task_1.ArrayAverageCalculator;
import org.deus.task_1.ArrayFiller;
import org.deus.task_1.ArraySumCalculator;

public class Main_Task_1 {
    public static void main(String[] args) {
        int[] array = new int[10];

        ArrayFiller filler = new ArrayFiller(array);
        ArraySumCalculator sumCalculator = new ArraySumCalculator(array);
        ArrayAverageCalculator averageCalculator = new ArrayAverageCalculator(array);

        Thread fillerThread = new Thread(filler);
        Thread sumCalculatorThread = new Thread(sumCalculator);
        Thread averageCalculatorThread = new Thread(averageCalculator);

        fillerThread.start();

        try {
            fillerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        sumCalculatorThread.start();
        averageCalculatorThread.start();

        try {
            sumCalculatorThread.join();
            averageCalculatorThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}