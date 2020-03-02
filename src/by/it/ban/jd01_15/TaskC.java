package by.it.ban.jd01_15;

import by.it.ban.calc.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

import static by.it.ban.jd01_15.Helper.getPath;

public class TaskC {
    static File file;
    public static void main(String[] args) {
        file = new File(getPath("", TaskC.class));
        Scanner scanner = new Scanner(System.in);
        while (true){
            String expression = scanner.next();
            if (expression.equals("end"))
                break;
            try {
                if(expression.equals("dir")) print();
                if(expression.equals("cd.."))
                    file=file.getParentFile();
                else
                    if (expression.substring(0,2).equals("cd")){
                        action(scanner.next());
                    }
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void print() {
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getName());
        }
    }

    private static void action(String expression) {
        for (File listFile : file.listFiles()) {
            if(listFile.getName().equals(expression) && listFile.isDirectory())
                file=listFile;
        }



        System.out.println(expression);

    }
}
