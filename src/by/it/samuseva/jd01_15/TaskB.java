package by.it.samuseva.jd01_15;

import java.io.*;

public class TaskB {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // тело программы
        String fileRead = Helper.getPath("TaskB.java",TaskB.class);
        String fileWriter = Helper.getPath("TaskB.txt",TaskB.class);
        StringBuilder  text = new StringBuilder(); // StringBilder для сохранения текста
        try (BufferedReader reader = new BufferedReader(new FileReader(fileRead));
             PrintWriter writer = new PrintWriter(new FileWriter(fileWriter))) {
                 String line;
                 while ((line = reader.readLine()) != null) {
                     /*   считывает стоку из файла и добавлляет  в StringBilder
                      */ text.append(line).append("\n");
                 }
                 int begin = 0, end = 0;
                 while (begin>=0){
                    if ((begin = text.indexOf("/*", begin))>=0){
                         end = text.indexOf("*/", begin);
                         if (end>0) if (begin<end) text.delete(begin, end+2);
                    }
                    if ((begin = text.indexOf("//"))>=0){
                        end = text.indexOf("\n", begin);
                        if (end>0) if (begin<end) text.delete(begin, end);
                    }
                 }
                 System.out.println(text);
                 writer.print(text.toString());
        } catch (IOException e) {
            /*
            если случиться исключение что файл не найден
             */
            e.printStackTrace();
        }


    }
}
