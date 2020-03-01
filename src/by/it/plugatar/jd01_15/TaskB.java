package by.it.plugatar.jd01_15;
/*
Файл восприниать как колбасу!
*/
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

//bla bla bla bla
/*bla bla bla bla*/
//bla bla bla bla */
public class TaskB {
    public static void main(String[] args) {
        String path = Helper.getPath("TaskB.java", TaskB.class);
        StringBuilder sb = deleteComments(path);
        System.out.println(sb);
        String path2 = Helper.getPath("TaskB.txt", TaskB.class);
        stringBuilderToFile(sb, path2);
    }

    private static void stringBuilderToFile(StringBuilder sb, String path2) {
        try (FileWriter fw = new FileWriter(path2)) {
            fw.append(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder deleteComments(String path) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            for (long i = 0; i < file.length(); ) {
                file.seek(i);
                char ch = (char) file.read();
                if (ch != '/') sb.append(ch);
                else {
                    i++;
                    char c = (char) file.read();
                    if (c == '/') {
                        while ((char) file.read() != '\n') {
                            i++;
                        }

                    } else if (c == '*') {
                        char b, d;
                        do {
                            do{
                                i++;
                                b = (char) file.read();
                            } while (b != '*');
                            i++;
                            d = (char) file.read();
                        } while (d !='/');
                    } else {
                        i--;
                        file.seek(i);
                        sb.append((char) file.read());
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}