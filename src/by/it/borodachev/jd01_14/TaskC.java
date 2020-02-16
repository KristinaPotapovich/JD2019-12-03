package by.it.borodachev.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {
    static String outFileName=Helper.getPath("resultTaskC.txt", TaskC.class);;
    private static void fileDir(String dirName)
    {
        File dir = new File(dirName); 
        File [] files=dir.listFiles();
        for (File f : files) {
          if (f.isDirectory()) {
               printConsoleAndFile("dir:"+f.getName());
               fileDir(f.getAbsolutePath());
           }
           else {printConsoleAndFile("file:"+f.getName());}
        }
    }
    private static void printConsoleAndFile(String resultTxt) {
        System.out.println(resultTxt);
        try (PrintWriter writer = new PrintWriter(outFileName)){
            writer.println(resultTxt);

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        fileDir(root);
    }
}
