package by.it.filipovich.jd01_15;

import java.io.*;

/*
Это многострочный коментарий  номер 1
Могу писать, что хочу.
 */

public class TaskB {
    public static void main(String[] args) throws IOException {
        String theFirstFile = Helper.pathToFile("TaskB.java", TaskB.class);
        String theFinalFile = Helper.pathToFile("TaskB.txt", TaskB.class);

        String str = readFileToStringBuilder(theFirstFile); //комментарий однострочный №1
        writeTheFile(str,theFinalFile);
        System.out.println(str);

    }

    private static void writeTheFile(String str,String theFinalFile) throws IOException {
        FileWriter print = new FileWriter(theFinalFile);
        print.write(str);
    }

    /**
     *
     * @param theFirstFile name of reading file
     * @return text from the file
     */
    private static String readFileToStringBuilder(String theFirstFile) {
        String signStart1 = "//";
        String signStart2 = "/*";
        String signFinish = "*/";
        String currentString;

        StringBuilder sb = new StringBuilder();
        boolean markOfComment = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(theFirstFile))) {

            while ((currentString = reader.readLine()) != null) {
                String trimLine = currentString.trim();
                if (!markOfComment && trimLine.indexOf(signStart2) == 0) {
                    String ourString = currentString.substring(0,currentString.indexOf(signStart2));
                    sb.append(ourString).append("\n");
                    markOfComment = true;
                } else if (!markOfComment && trimLine.indexOf(signStart1) == 0) {
                    String emptyStr = currentString.substring(0, currentString.indexOf(signStart1));
                    sb.append(emptyStr).append("\n");
                } else if (!markOfComment && trimLine.indexOf(signStart1) != 0) {
                    sb.append(currentString).append("\n");
                }
                if (markOfComment && currentString.contains(signFinish)) {
                    markOfComment = false;
                }
            }

            int startI = sb.indexOf(signStart1);
            int endI = sb.indexOf("\n", startI);
            sb.delete(startI, endI);
            int startI1 = sb.indexOf(signStart2);
            int endI1 = sb.indexOf(signFinish, startI1);
            sb.delete(startI1, endI1+2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /*
Это многострочный коментарий  номер 2
Продолжаю писать, что хочу.
 */
}

