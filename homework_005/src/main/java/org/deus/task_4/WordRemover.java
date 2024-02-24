package org.deus.task_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordRemover implements Runnable
{
    private String mergedFilePath;
    private String forbiddenWordsFilePath;

    public WordRemover(String mergedFilePath, String forbiddenWordsFilePath) {
        this.mergedFilePath = mergedFilePath;
        this.forbiddenWordsFilePath = forbiddenWordsFilePath;
    }


    @Override
    public void run() {
        try {
            removeForbiddenWords(mergedFilePath, forbiddenWordsFilePath);
            System.out.println("Видалення заборонених слів завершено");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeForbiddenWords(String mergedFilePath, String forbiddenWordsFilePath) throws IOException {
        List<String> forbiddenWords = readForbiddenWords(forbiddenWordsFilePath);
        File tempFile = new File("temp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(mergedFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            for (String word : forbiddenWords) {
                line = line.replaceAll(word, "");
            }
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        tempFile.renameTo(new File(mergedFilePath));
    }

    private List<String> readForbiddenWords(String forbiddenWordsFilePath) throws IOException {
        List<String> forbiddenWords = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(forbiddenWordsFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            forbiddenWords.add(line);
        }
        reader.close();
        return forbiddenWords;
    }
}
