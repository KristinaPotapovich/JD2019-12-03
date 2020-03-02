package by.it.shulga.jd01.jd01_15;

import java.io.*;
import java.nio.charset.StandardCharsets;
public class TaskB {
    /*
    Большой прибольшой многостраничный коммент
    Большой прибольшой многостраничный коммент
    Большой прибольшой многостраничный коммент
    Большой прибольшой многостраничный коммент
    Большой прибольшой многостраничный коммент
*/
     public static void main(String[] args) {
        //создание пути файлов для чтения и записи
        String file = Helper.getPath("TaskB.java", TaskB.class);
        String Result = Helper.getPath("TaskB.txt", TaskB.class);
        //чтение содержимого  в стрингбилдер
        StringBuilder str = readTextFile(file);
        //удаление однострочных комментов
        deleteDoubleSlashComment(str);
        //удаление джавадока и многострочных комментов
        deleteStarSlashComment(str);
        System.out.println(str);
        //запись текста  без комментов в файл (тхт)
        writeTextFile(Result, str.toString());
     }
    private static void deleteDoubleSlashComment(StringBuilder str) {
        int start;
        boolean a;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                i++;
                //удаление однострочных комментов
                if (str.charAt(i) == '/') {
                    start = i-1;
                    while (str.charAt(i) != '\n') {
                        i++;
                    }
                    str.delete(start, i);
                }
            }
        }
    }


    private static void deleteStarSlashComment(StringBuilder str) {
        int start;
        boolean Comment, a = false;
        //удаление джавадока и многострочных комментов
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                start = i;
                i++;
                Comment = true;
                if (str.charAt(i) == '*'){
                    i++;
                    while (Comment){
                        if (str.charAt(i) == '*')
                            if(str.charAt(i+1) == '/') Comment = false;
                        i++;
                    }
                    str.delete(start, i+1);
                }
            }
        }
    }

    private static void writeTextFile(String fileNameB, String result) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileNameB), StandardCharsets.UTF_8))){
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
            //коммент
        }
    }

    /**
     *
     * @param file
     * @return
     */

    private static StringBuilder readTextFile(String file) {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), StandardCharsets.UTF_8))){
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception");
        }

        /*Внутри*/
        return str;
        /*еще внутри*/
    }


}