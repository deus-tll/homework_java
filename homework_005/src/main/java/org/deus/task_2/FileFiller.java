package org.deus.task_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileFiller implements Runnable
{
    private final String filePath;
    private final int fileSize;

    public FileFiller(String filePath, int fileSize) {
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            for (int i = 0; i < fileSize; i++)
            {
                writer.write(random.nextInt(1000) + "\n");
            }

            writer.close();
            System.out.println("Файл заповнений");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
