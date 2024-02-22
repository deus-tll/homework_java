package org.deus.tasks;

import org.deus.interfaces.FourParameterOperator;

public class Task_3 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 3");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------\n");
    }

    private void method() {
        FourParameterOperator<Integer> maxOfFour = (a, b, c, d) -> Math.max(Math.max(a, b), Math.max(c, d));
        int maxResult = maxOfFour.apply(10, 5, 15, 20);
        System.out.println("Max of four numbers: " + maxResult);

        FourParameterOperator<Integer> minOfFour = (a, b, c, d) -> Math.min(Math.min(a, b), Math.min(c, d));
        int minResult = minOfFour.apply(10, 5, 15, 20);
        System.out.println("Min of four numbers: " + minResult);
    }
}
