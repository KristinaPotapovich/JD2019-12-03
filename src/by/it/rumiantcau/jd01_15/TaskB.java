package by.it.rumiantcau.jd01_15;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class TaskB {
    /*
    * В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”) и внутри комментария тоже
*/
    public static void main(String[] args) {
        //
        //генерация пути файлов для чтения и записи
        String fileNameB = Helper.getPath("TaskB.java", TaskB.class);
        String fileResultB = Helper.getPath("TaskB.txt", TaskB.class);
        //чтение содержимого программы в стрингбилдер
        StringBuilder str = readTextFile(fileNameB);
        //удаление однострочных комментариев
        deleteDoubleSlashComment(str);
        //удаление джавадока и многострочных комментариев
        deleteStarSlashComment(str);
        System.out.println(str);
        //запись текста программы без комментариев в файл тхт
        writeTextFile(fileResultB, str.toString());
    }
    //проверить алгоритм еще раз, что то не очень отрабатывает
    private static void deleteDoubleSlashComment(StringBuilder str) {
        int start;
        boolean a;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '/') {
                    i++;
                    //удаление однострочных комментариев
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
        boolean starComment;
        //удаление джавадока и многострочных комментариев
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                start = i;
                i++;
                starComment = true;
                if (str.charAt(i) == '*'){
                    i++;
                    while (starComment){
                        if (str.charAt(i) == '*')
                            if(str.charAt(i+1) == '/') starComment = false;
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
            //efokepokfopekofkefopke
        }
    }

    /**
     *
     * @param fileNameB
     * @return
     */
    private static StringBuilder readTextFile(String fileNameB) {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileNameB), StandardCharsets.UTF_8))){
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("It is a trap!");
        }
        /*ffefefefeffeef*/
        return str;
        /*dvdvdvdvvdvdvdvdvdvdv*/
    }


}
