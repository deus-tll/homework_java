package org.deus.task_1;

public class ArrayAverageCalculator implements Runnable
{
    private final int[] array;
    private double average;

    public ArrayAverageCalculator(int[] array) {
        this.array = array;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        average = (double) sum / array.length;
        System.out.println("Середнє арифметичне значення масиву: " + average);
    }
}
