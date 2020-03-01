package by.it.shpakovskiy.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

class TaskC {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            File currentDir = new File(System.getProperty("user.dir") + "/src/by/it/shpakovskiy/jd01_15");
            while (true) {
                String line = reader.readLine();
                if (line.equals("end")) {
                    System.out.println("All the best. Bye");
                    break;
                }
                if (line.equals("cd ..")) {
                    File parentDir = currentDir.getParentFile();
                    if (parentDir != null) {
                        currentDir = parentDir;
                    }
                } else if (line.startsWith("cd ") && line.length() > 3) {
                    String newDirName = line.substring(3);
                    String newAbsolutePath = currentDir.toString() + "/" + newDirName;
                    File newDir = new File(newAbsolutePath);
                    if (newDir.isDirectory()) {
                        currentDir = newDir;
                    } else {
                        System.err.println("Directory " + newDirName + " is not found");
                    }
                } else if (line.equals("dir")) {
                    dir(currentDir);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dir(File currentDir) throws IOException {
        File[] files = currentDir.listFiles();
        if (files != null) {
            System.out.println("Current directory " + currentDir.getName());
            int fileCount = 0;
            int dirCount = 0;
            long totalSize = 0;
            for (File file : files) {
                BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                long millis = attributes.creationTime().toMillis();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                String date = dateFormat.format(millis);
                String time = timeFormat.format(millis);
                System.out.print(date);
                System.out.print(" ");
                System.out.print(time);
                if (file.isDirectory()) {
                    System.out.print("\t\t<DIR>\t\t\t");
                    dirCount++;
                } else {
                    System.out.printf("%,18d", attributes.size());
                    fileCount++;
                    totalSize += attributes.size();
                }
                System.out.print(" ");
                System.out.println(file.getName());
            }
            System.out.format("%16d files", fileCount);
            System.out.format("%,16d bytes%n", totalSize);
            System.out.format("%16d directories ", dirCount);
            System.out.format("%,16d bytes free%n", currentDir.getFreeSpace());
            System.out.println();
        }
    }
}
