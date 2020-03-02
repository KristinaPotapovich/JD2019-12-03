package by.it.lozouski.jd01_15;

import by.it.lozouski.jd01_14.Helper;

import java.io.*;

class TaskB extends Helper {
    /**
     * @author Lozouski Andrei
     * @version 1.0 beta
     */
    public static void main(String[] args) {
        /* ааа
        Это
        многострочный
        комментарий. Навсякий случай добавлю всякие символы [123><?'"?.,;:{}()]
         */
        String fileName = Helper.getPath("TaskB.java", TaskB.class);
        String fileTaskName = Helper.getPath("TaskB.txt", TaskB.class);
        StringBuilder sb1 = createStrBuildFromFile(fileName);
        System.out.println(sb1);
        writeToFile(fileTaskName, sb1);
        //Однострочный комментарий номер 1.
        //Однострочный комментарий номер 2.
        //Однострочный комментарий номер 3.
        //Однострочный комментарий номер 4.
        //Однострочный комментарий номер 5.
    }

    /* Многострочный комментарий в одной строке. */
    static void writeToFile(String fileTaskName, StringBuilder sb1) {
        try (BufferedWriter writerFiles = new BufferedWriter(new FileWriter(fileTaskName))) {
            writerFiles.write(sb1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Это еще
    один многострочный
    комментарий.
    */
    static StringBuilder createStrBuildFromFile(String fileName) {
        StringBuilder outputText = new StringBuilder();
        boolean isComment = false;
        String start1 = "//";
        String start2 = "/*";
        String end2 = "*/";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName), 16384)) {
            String lineString;
            while ((lineString = reader.readLine()) != null) {
                String trimStr = lineString.trim();
                if (!isComment && trimStr.indexOf(start2) == 0) {
                    String emptyStr = lineString.substring(0, lineString.indexOf(start2));
                    outputText.append(emptyStr).append("\n");
                    isComment = true;
                } else if (!isComment && trimStr.indexOf(start1) == 0) {
                    String emptyStr = lineString.substring(0, lineString.indexOf(start1));
                    outputText.append(emptyStr).append("\n");
                } else if (!isComment && trimStr.indexOf(start1) != 0) {
                    outputText.append(lineString).append("\n");
                }
                if (isComment && lineString.contains(end2)) {
                    isComment = false;
                }
            }

            int startI = outputText.indexOf(start1);
            int endI = outputText.indexOf("\n", startI);
            outputText.delete(startI, endI);
            int startI1 = outputText.indexOf(start2);
            int endI1 = outputText.indexOf(end2, startI1);
            outputText.delete(startI1, endI1+2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputText;
    }
}