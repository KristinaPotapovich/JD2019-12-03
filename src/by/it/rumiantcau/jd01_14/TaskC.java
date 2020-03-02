package by.it.rumiantcau.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
public class TaskC {
    public static void main(String[] args) {
        //получаем массив с данными о всех пакетах в в указанной директории
        File[] packages =
                new File("F:/IntelliJ IDEA Community Edition 2019.3/JD2019-12-03/src/by/it/rumiantcau/").
                        listFiles();
        //заводим список, где будет хранится все данные о папках и файлах
        List<String> result = new LinkedList<>();
        for (int i = 0; i < packages.length; i++) {
            //добавляем в список имя пакета
            result.add("dir:" + packages[i].toString().substring(76));
            //формируем массив из файлов пакета
            File[] listFiles = new File(String.valueOf(packages[i])).listFiles();
            for (int j = 0; j < listFiles.length; j++) {
                //добавляем имя файлов в список
                result.add(("file:"+listFiles[j].toString().substring(84)));
            }
        }
        //печатаем список в консоль
        for (String s : result) {
        System.out.println(s);
        }
        //записываем список в файл
        writeTextFile(Helper.getPath("resultTaskC.txt", TaskA.class), result);
    }


    private static void writeTextFile(String fileNameB, List<String> result) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileNameB), StandardCharsets.UTF_8))){
            for (String s : result) {
                writer.write(s+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
