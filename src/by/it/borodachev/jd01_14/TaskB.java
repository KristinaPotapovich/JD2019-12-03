package by.it.borodachev.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Helper.getPath("TaskB.txt", TaskB.class);
        File inStream = new File(fileName);
        int marks=0;
        int words=0;
        try (Scanner scanner = new Scanner(inStream)) {
            scanner.useDelimiter("[^a-zA-zа-яёА-ЯЁ \\r\\n]{1,}");
            marks = 0;
            words = 0;
           while (scanner.hasNext()) {
               String strSome = scanner.next();
                marks++;
                String[] wordArr = strSome.replace("\r\n", " ").trim().split(" ");
               // words += wordArr.length; не учитывает несколько пробелов подрядю Переделаем на более медленный вариант
                for (String s : wordArr) {
                   if (s.length() >0) {words++;}
               }

            }
        }
        printConsoleAndFile(Helper.getPath(
                    "ResultTaskB.txt", TaskB.class),
                    "words=" + words + ",punctuation marks=" + marks);
          }
    private static void printConsoleAndFile(String fileName,String resultTxt) {
        System.out.println(resultTxt);
        try (PrintWriter writer = new PrintWriter(fileName)){
           writer.println(resultTxt);

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
