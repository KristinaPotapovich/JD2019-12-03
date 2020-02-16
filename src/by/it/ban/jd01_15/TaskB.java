package by.it.ban.jd01_15;

import java.io.*;
import java.sql.Array;
import java.util.stream.IntStream;

import static by.it.ban.jd01_15.Helper.*;

/**
 * В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 *  Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 *  Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 *  Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 */
public class TaskB {
    public static void main(String[] args) {
        /*А никто не просил рисовать многосрочные комментарии
         *с незначащими звёздами как джавадок
         */

        String filename = getPath("TaskB.java", TaskB.class);
        StringBuilder stringBuilder = new StringBuilder();
        //Трай с ресурсом
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)); //Ладно не будем халтурить, коммент в коде
             BufferedWriter writer = new BufferedWriter(new FileWriter(getPath("TaskB.txt", TaskB.class)))) {
            //Читаем до посинения
            while (reader.ready()) {
                stringBuilder.append(reader.readLine() + "\n");
            }
            int beg=0;
            int end;
            while (beg>=0) {
                beg = stringBuilder.indexOf("/*", beg);
                if (beg >= 0) {
                    end = stringBuilder.indexOf("*/", beg);
                    if (end > 0)
                        if (end > beg) stringBuilder.delete(beg, end+2);
                }
            }
            beg=0;
            while (beg>=0) {
                beg = stringBuilder.indexOf("//", beg);
                if (beg >= 0) {
                    end = stringBuilder.indexOf("\n", beg);
                    if (end > 0)
                        if (end > beg) stringBuilder.delete(beg, end);
                }
            }


            /*аппенд хочет чарсиквенс
            первый попавшийся в билдере метод возвращающий сиквенс оф час
            впрочем и единственный
            */
            writer.append(stringBuilder.subSequence(0,stringBuilder.length()));






        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}