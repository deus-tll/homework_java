package org.deus.task_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSearcher implements Runnable
{
    private String directoryPath;
    private String keyword;
    private String mergedFilePath;

    public FileSearcher(String directoryPath, String keyword, String mergedFilePath) {
        this.directoryPath = directoryPath;
        this.keyword = keyword;
        this.mergedFilePath = mergedFilePath;
    }

    @Override
    public void run() {
        try {
            List<String> filesWithKeyword = findFilesWithKeyword(directoryPath, keyword);
            mergeFiles(filesWithKeyword, mergedFilePath);
            System.out.println("Пошук та злиття файлів завершено");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mergeFiles(List<String> filesWithKeyword, String mergedFilePath) throws IOException {
    }

    private List<String> findFilesWithKeyword(String directoryPath, String keyword) {
        List<String> filesWithKeyword = new ArrayList<>();
        findFiles(directoryPath, keyword, filesWithKeyword);
        return filesWithKeyword;
    }

    private void findFiles(String directoryPath, String keyword, List<String> filesWithKeyword) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(keyword)) {
                                filesWithKeyword.add(file.getAbsolutePath());
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (file.isDirectory()) {
                    findFiles(file.getAbsolutePath(), keyword, filesWithKeyword);
                }
            }
        }
    }
}
