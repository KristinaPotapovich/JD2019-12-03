package by.it.popkov.jd01_14;

import java.io.*;
import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        String result = textFileAnalysis(Support.fileFullName(TaskB.class, "text.txt"));
        System.out.println(result);
        textToFile(result, Support.fileFullName(TaskB.class, "resultTaskB.txt"));
    }

    static void textToFile(String result, String fileFullName) {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFullName))) {
            bufferedWriter.write(result);
        } catch (IOException e) {
            System.out.println("ERROR textToFile");
        }
    }

    static String textFileAnalysis(String fileFullName) {
        File file = new File(fileFullName);
        int wordCounter = 0;
        int markCounter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.matches("[А-Яа-яЁё]+")) wordCounter++;
                else if (next.matches("[А-Яа-яЁё]+\\p{Punct}{1,3}([А-Яа-яЁё]+)?")) {
                    wordCounter++;
                    markCounter++;
                } else if (next.matches("\\p{Punct}")) markCounter++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "words=" + wordCounter + ", punctuation marks=" + markCounter;
    }
}
