package by.it.plugatar.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String point = File.separator;
        path = path + point + "src" + point + "by" + point + "it" + point + "plugatar";
        StringBuilder listOfFiles = getFilesList(path);
        System.out.println(listOfFiles);
        writeFilesList(listOfFiles);
    }

    private static StringBuilder getFilesList(String path) {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        if (file.isFile()) sb.append("file:").append(file.getName()).append("\n");
        else {
            sb.append("dir:").append(file.getName()).append("\n");
            File[] files = file.listFiles();
            if (files != null)
                for (File file1 : files) {
                    sb.append(getFilesList(file1.getPath()));
                }
        }
        return sb;
    }

    private static void writeFilesList(StringBuilder sb) {
        String path = TaskB.getPath(TaskC.class, "resultTaskC.txt");
        try (
                FileWriter fw = new FileWriter(new File(path))
        ){
            fw.append(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}