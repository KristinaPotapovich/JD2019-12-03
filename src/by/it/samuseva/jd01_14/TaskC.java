package by.it.samuseva.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {

    public static void main(String[] args) {
        String pathDir = Helper.getPath(TaskC.class).replace("jd01_14", "");
        printNameDirToConsole(pathDir);
        String resultFile = Helper.getPath("resultTaskC.txt", TaskB.class);
        writerToFile(resultFile, pathDir);

    }

    private static void writerToFile(String resultFile, String pathDir) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
           writerDirToFile(pathDir, pw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writerDirToFile(String resultFile, PrintWriter pw) {
        File myDir = new File(resultFile);
        File[] allDir = myDir.listFiles();
        for (File dir : allDir != null ? allDir : new File[0]) {
            pw.print("dir:" + dir.getName() + "\n");
            writerNameFileToFile(dir, pw);
        }
    }

    private static void writerNameFileToFile(File dir, PrintWriter pw) {
        File[] files = dir.listFiles();
        for (File element : files != null ? files : new File[0]) {
            if (point(element.getName())==-1) {
                pw.print("dir:" + element.getName() + "\n");
                File[] files1 = element.listFiles();
                for (File file : files1 != null ? files1 : new File[0]) {
                    pw.print("  file:" + file.getName() + "\n");
                }

            }
            else pw.print("file:" + element.getName() + "\n");
        }
    }

    private static void printNameDirToConsole(String pathDir) {
        File myDir = new File(pathDir);
        File[] allDir = myDir.listFiles();
        for (File dir : allDir != null ? allDir : new File[0]) {
            System.out.println("dir:" + dir.getName());
            printNameFileToConsole(dir);
        }
    }
    private static void printNameFileToConsole(File dir) {
        File[] files = dir.listFiles();
        for (File element : files != null ? files : new File[0]) {
            if (point(element.getName())==-1) {
                System.out.println("dir:" + element.getName());
                File[] files1 = element.listFiles();
                for (File file : files1 != null ? files1 : new File[0] ) {
                    System.out.println("  file:" + file.getName());
                }

            }
            else System.out.println("file:" + element.getName());
        }
    }
    private static int point (String element){
        String point = ".";
        for (int i = 0; i < element.length(); i++) {
            if (point.indexOf(element.charAt(i))>=0) return 1;
        }
        return -1;
    }
}

