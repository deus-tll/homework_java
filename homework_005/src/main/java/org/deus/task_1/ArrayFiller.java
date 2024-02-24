package org.deus.task_1;

import java.util.Arrays;
import java.util.Random;

public class ArrayFiller implements Runnable
{
    private final int[] array;

    public ArrayFiller(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Масив заповнений: " + Arrays.toString(array));
    }
}
