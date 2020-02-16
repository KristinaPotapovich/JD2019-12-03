package by.it.lozouski.jd01_15;

import by.it.lozouski.jd01_14.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class TaskC extends Helper {
    static String wayTaskPackage = Helper.getPackage(TaskC.class);
    static File file = new File(wayTaskPackage);

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            String inputText = sc1.nextLine();
            try {
                if (inputText.equals("end")) break;     //если end - то завершаем программу
                if (inputText.equals("dir")) {          //если dir - то печатаем текущую директорию в консоль.
                    printDirectoryToConsole();
                }
                if (inputText.equals("cd..")) {         //если cd.. - то возвращемся на директорию назад(родительскую)
                    file = file.getParentFile();
                } else if (inputText.contains("cd")) { //иначе если ввод содержит cd...нужно переместиться в директорию указанную после cd.
                    String destinationDirectory = inputText.substring(3); //добавим в строку кусок текста, являющийся папкой назначения
                    file = new File(file.getAbsolutePath() + File.separator + destinationDirectory); // новый файл с новой директорией.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void printDirectoryToConsole() throws IOException {
        File[] files = file.listFiles();
        if (files != null) {
            System.out.println("Содержимое папки: " + file.getPath() + '\n');
            for (File item : files) {
                String nameItem = item.getName();
                Path pathItem = Paths.get(item.getPath());
                String timeModifyItem = String.valueOf(Files.getLastModifiedTime(pathItem))
                        .replace("T", "  ").substring(0, 17);
                String typeItem = null;
                if (item.isDirectory()) typeItem = "<DIR>";
                if (item.isFile()) typeItem = String.valueOf(Files.size(pathItem));
                System.out.printf("%s %10s     %-50s \n", timeModifyItem, typeItem, nameItem);
            }
        }
    }
}
