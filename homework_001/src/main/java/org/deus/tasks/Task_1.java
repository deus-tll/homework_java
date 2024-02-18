package org.deus.tasks;

public class Task_1 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 1");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        System.out.println("\"Your time is limited,");
        System.out.println("\tso don't waste it");
        System.out.println("\t\tliving someone else's life\"");
        System.out.println("\t\t\tSteve Jobs");
    }
}
