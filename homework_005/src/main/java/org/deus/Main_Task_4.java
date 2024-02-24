package org.deus;

import org.deus.task_4.FileSearcher;
import org.deus.task_4.WordRemover;

import java.io.*;
import java.util.Scanner;

public class Main_Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до директорії:");
        String directoryPath = scanner.nextLine();

        System.out.println("Введіть слово для пошуку:");
        String keyword = scanner.nextLine();

        System.out.println("Введіть шлях до файлу з забороненими словами:");
        String forbiddenWordsFilePath = scanner.nextLine();

        System.out.println("Введіть шлях до файлу, куди буде злито вміст файлів:");
        String mergedFilePath = scanner.nextLine();

        scanner.close();

        FileSearcher searcher = new FileSearcher(directoryPath, keyword, mergedFilePath);
        WordRemover remover = new WordRemover(mergedFilePath, forbiddenWordsFilePath);

        Thread searcherThread = new Thread(searcher);
        Thread removerThread = new Thread(remover);

        searcherThread.start();
        try {
            searcherThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        removerThread.start();
        try {
            removerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Статистика:");
        System.out.println("Кількість файлів, що містять ключове слово: " + countFilesWithKeyword(directoryPath, keyword));
        System.out.println("Вміст файлу після видалення заборонених слів:");
        printFileContent(mergedFilePath);
    }

    private static int countFilesWithKeyword(String directoryPath, String keyword) {
        int count = 0;
        File dir = new File(directoryPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(keyword)) {
                                count++;
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (file.isDirectory()) {
                    count += countFilesWithKeyword(file.getAbsolutePath(), keyword);
                }
            }
        }
        return count;
    }

    private static void printFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
