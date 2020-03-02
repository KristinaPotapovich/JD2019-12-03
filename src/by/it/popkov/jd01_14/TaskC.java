package by.it.popkov.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class TaskC {
    public static void main(String[] args) {
        String sep = File.separator;
        String s = System.getProperty("user.dir") + sep + "src" + sep + "by" + sep + "it" + sep + "popkov";
        File file = new File(s);
        String[] list = file.list();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            String dirFullName = s + sep + list[i];
            sb.append("dir:").append(list[i]).append("\n");
            File dir = new File(dirFullName);
            String[] listDir = dir.list();
            for (int d = 0; d < listDir.length; d++) {
                String dirName = dirFullName + sep + listDir[d];
                if (new File(dirName).isDirectory()) {
                    sb.append("dir:").append(listDir[d]).append("\n");
                    String ddirFullName = dirFullName + sep + listDir[d];
                    File ddir = new File(ddirFullName);
                    for (String s1 : ddir.list()) {
                        sb.append("file:").append(s1).append("\n");
                    }
                } else
                    sb.append("file:").append(listDir[d]).append("\n");
            }
        }
        System.out.println(sb.toString());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Support.fileFullName(TaskC.class, "resultTaskC.txt")))) {
            bufferedWriter.append(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
