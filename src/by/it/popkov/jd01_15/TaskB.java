package by.it.popkov.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

    class TaskB {
        //1
        //2
        int t;/*3
         * 3
         *
         * 3*/int a;
        /*4
         * 4
         *
         * 4*/int b;
        /**
         * 5
         * <p>
         * 5
         * <p>
         * 5
         **/int c;

    public static void main(String[] args) {
        System.out.println(read(Support.fileFullName(TaskB.class, "TaskB.java")).toString());
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(Support.fileFullName(TaskB.class, "TaskB.txt")))) {
            bufferedWriter.append(read(Support.fileFullName(TaskB.class, "TaskB.java")).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder read(String fileFullName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object[] objects = Files.lines(Paths.get(fileFullName))
                    .limit(30)
                    .map(o -> o.replace("//", "\n//"))
                    .map(o -> o.replace("/*", "\n/*"))
                    .map(o -> o.replace("*/", "*/\n"))
                    .map(o -> o.replace("/**", "\n/**"))
                    .map(o -> o.replace("**/", "**/\n"))
                    .flatMap(o -> Arrays.stream(o.split("\n"))).toArray();
            Object[] objects2 = Files.lines(Paths.get(fileFullName))
                    .skip(30)
                    .toArray();

            boolean open = false;
            for (Object object : objects) {
                String line = (String) object;
                if (line.contains("//")) continue;
                if (line.contains("/*")) open = true;
                if (line.contains("/**")) open = true;
                if (!open) stringBuilder.append("\n").append(line);
                if (line.contains("*/")) open = false;
                if (line.contains("**/")) open = false;
            }
            for (Object object : objects2) {
                String line = (String) object;
                stringBuilder.append("\n").append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}