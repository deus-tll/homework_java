package org.deus.tasks;

public class Task_11 implements Runnable
{

    @Override
    public void run() {
        System.out.println("--------------------------------");
        System.out.println("Task 11");
        System.out.println("--------------------------------");
        method();
        System.out.println("--------------------------------");
    }

    private void method() {
        lineDrawer(5, 'h', '#');
    }

    public static void lineDrawer(int length, char direction, char symbol) {
        if (direction == 'h') {
            drawHorizontalLine(length, symbol);
        } else if (direction == 'v') {
            drawVerticalLine(length, symbol);
        } else {
            System.out.println("Неправильний напрямок. Використовуйте 'h' для горизонтальної лінії або 'v' для вертикальної.");
        }
    }

    private static void drawHorizontalLine(int length, char symbol) {
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    private static void drawVerticalLine(int length, char symbol) {
        for (int i = 0; i < length; i++) {
            System.out.println(symbol);
        }
    }
}
