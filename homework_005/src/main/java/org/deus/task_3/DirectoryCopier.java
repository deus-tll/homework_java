package org.deus.task_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DirectoryCopier implements Runnable
{
    private final String sourceDirectoryPath;
    private final String destinationDirectoryPath;

    public DirectoryCopier(String sourceDirectoryPath, String destinationDirectoryPath) {
        this.sourceDirectoryPath = sourceDirectoryPath;
        this.destinationDirectoryPath = destinationDirectoryPath;
    }

    @Override
    public void run() {
        try {
            copyDirectory(new File(sourceDirectoryPath), new File(destinationDirectoryPath));
            System.out.println("Директорія скопійована успішно");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void copyDirectory(File sourceDir, File destDir) throws IOException {
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        for (File file : files) {
            File destFile = new File(destDir, file.getName());
            if (file.isDirectory()) {
                copyDirectory(file, destFile);
            } else {
                Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
