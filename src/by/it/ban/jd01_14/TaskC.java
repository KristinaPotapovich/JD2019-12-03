package by.it.ban.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//В классе TaskC нужно выполнить следующие шаги:
//         Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
//        формате file:имя_файла или dir:имя_каталога.
//         Продублировать вывод в консоль в файл resultTaskC.txt
public class TaskC {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"\\src\\by\\it\\ban");
        final File outputFile = new File(Helper.getPath("resultTaskC.txt",TaskC.class));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            printDir(file,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDir(File f,BufferedWriter writer) throws IOException {
        System.out.println("dir:"+f.getName());
        writer.write("dir:"+f.getName());
        ArrayList<File> list = new ArrayList<File>(Arrays.asList(f.listFiles()));
        for (File f1 : list) {
            if(f1.isDirectory()) printDir(f1,writer);
            else {
                System.out.println("file:" + f1.getName());
                writer.write("file:"+f.getName());
            }

        }
    }
}
