package org.deus.task_1;

public class ArraySumCalculator implements Runnable
{
    private final int[] array;
    private int sum;

    public ArraySumCalculator(int[] array) {
        this.array = array;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int num : array) {
            sum += num;
        }
        System.out.println("Сума елементів масиву: " + sum);
    }
}
