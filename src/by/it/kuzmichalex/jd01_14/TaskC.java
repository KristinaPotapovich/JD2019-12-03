package by.it.kuzmichalex.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    private static List<String> listFiles = new ArrayList<>();

    public static void main(String[] args) {
        File startDir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "kuzmichalex");
        listDirAndFiles(startDir);
        saveAndPrintList(FHelper.getFileName("resultTaskC.txt", TaskA.class));
    }

    private static void listDirAndFiles(File startDir) {
        File[] files = startDir.listFiles();
        assert files != null;
        for (File file : files) {
            listFiles.add((file.isDirectory() ? "dir:" : "file:") + file.getName());
            if (file.isDirectory()) {
                File subDir = new File(file.getAbsolutePath());
                listDirAndFiles(subDir);
            }
        }
    }

    private static void saveAndPrintList(String sFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sFileName))
        ) {
            for (String next : listFiles) {
                bw.write(next + "\n");
                System.out.println(next);
            }
        } catch (IOException e) {
            System.out.println("Output error. File:" + sFileName);
        }
    }
}
