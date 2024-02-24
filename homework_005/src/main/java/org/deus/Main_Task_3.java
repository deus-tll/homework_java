package org.deus;

import org.deus.task_3.DirectoryCopier;

import java.util.Scanner;

public class Main_Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до вихідної директорії:");
        String sourceDirectoryPath = scanner.nextLine();

        System.out.println("Введіть шлях до цільової директорії:");
        String destinationDirectoryPath = scanner.nextLine();

        scanner.close();

        DirectoryCopier copier = new DirectoryCopier(sourceDirectoryPath, destinationDirectoryPath);

        Thread copierThread = new Thread(copier);

        copierThread.start();

        try {
            copierThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Статистика:");
        System.out.println("Вихідна директорія: " + sourceDirectoryPath);
        System.out.println("Цільова директорія: " + destinationDirectoryPath);
    }
}
