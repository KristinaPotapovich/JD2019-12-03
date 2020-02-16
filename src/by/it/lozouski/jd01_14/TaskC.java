package by.it.lozouski.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class TaskC {

    public static void main(String[] args) {
        String dirPackageLastName = Helper.getPathPackage(TaskC.class);
        File dirMyPackage = new File(dirPackageLastName);
        StringBuilder outputText = new StringBuilder();
        
        System.out.println(printExplorer(dirMyPackage, outputText));
        //запись в файл
        String nameFileOfTask = Helper.getPath("resultTaskC.txt", TaskC.class);
        writeToFile(outputText, nameFileOfTask);
    }

    static StringBuilder printExplorer(File dirMyPackage, StringBuilder outputText) {
        try {
            File[] files = dirMyPackage.listFiles();
            if (files != null) {
                for (File item : files) {
                    if (item.isDirectory()) {
                        outputText.append("dir:").append(item.getName()).append('\n');
                    } else outputText.append("file:").append(item.getName()).append('\n');
                    if (item.isDirectory()) {
                        File dir = new File(item.getPath());
                        printExplorer(dir, outputText);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ВСЁ ПОЛОМАЛОСЬ!!!");
            e.printStackTrace();
        }
        return outputText;
    }

    static void writeToFile(StringBuilder resultTaskSb, String taskFileName) {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(taskFileName))) {
            bufferedWriter.write(String.valueOf(resultTaskSb));
        } catch (IOException e) {
            System.out.println("ВСЁ ПОЛОМАЛОСЬ!!!");
            e.printStackTrace();
        }
    }
}
