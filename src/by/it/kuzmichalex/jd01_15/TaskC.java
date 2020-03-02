package by.it.kuzmichalex.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    static File curDir = new File(System.getProperty("user.dir") +
            File.separator + "src" + File.separator + "by" + File.separator + "it" +
            File.separator + "kuzmichalex" + File.separator + "jd01_15");

    public static void main(String[] args) {
        System.out.println("MegaHard DOS version 1.0");
        Scanner sc = new Scanner(System.in);
        while (true) {
            printCurDir();
            String next = sc.nextLine();
            if (next.toLowerCase().equals("exit")) break;
            if (next.toLowerCase().equals("end")) break;
            if (next.toLowerCase().startsWith("cd")) {
                changeDir(next);
                continue;
            }
            if (next.toLowerCase().equals("dir")) {
                showDir();
                continue;
            }
            System.out.println("Bad command or file name");
        }
    }

    private static void showDir() {
        File[] files = curDir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.printf("%-20s %5s\n", file.getName(), (file.isDirectory() ? "<DIR>" : "file"));
            }
        }

    }

    private static void changeDir(String next) {
        String[] otherDir = next.split(" ");
        if (otherDir.length < 2) return;
        if (otherDir[1].equals("..")) {
            String parent = curDir.getParent();
            curDir = new File(parent);
            return;
        }

        //Переход внутрь указанной папки
        File[] files = curDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().toUpperCase().equals(otherDir[1].toUpperCase())) {
                        curDir = new File(curDir.getAbsolutePath() + File.separator + otherDir[1]);
                        return;
                    }
                }
            }
        }
        //Не перешли :(
        System.out.println("Invalid directory name");
    }

    private static void printCurDir() {
        System.out.print(curDir.getAbsolutePath() + ">");
    }

}
