package by.it.borodachev.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * @author igor.borodachev
 * @exception TaskB IOexception
 */
public class TaskB {

    public static void main(String[] args) throws IOException{
        String lineComment= "/"+"/";
        String startComment= "/"+"*";
        String endComment= "*"+"/";
         // входной файл
        String filenameIn = Helper.getPath("TaskB.java", TaskB.class);
        // файл для сохранения результата
        String filenameOut = Helper.getPath("TaskB.txt", TaskB.class);
/* начало многострочного комента
        вторая строка комента
        окончание многострочного комента */
        StringBuilder javatext =new StringBuilder();
        boolean multiLineComment =false;
        try (BufferedReader inLines = new BufferedReader(new FileReader(filenameIn))){
            String inputLine;
            while ((inputLine=inLines.readLine())!=null) {
              if (inputLine.indexOf(lineComment) >=0) {
                  if (inputLine.indexOf(lineComment) >0) {
                      inputLine=inputLine.substring(0,inputLine.indexOf(lineComment));
                    }
                  else {inputLine=null;}
                }
              else
                if (inputLine.indexOf(startComment) >=0) {
                    if (inputLine.indexOf(startComment) >0) {
                      inputLine = inputLine.substring(0, inputLine.indexOf(startComment));
                  }
                  else {inputLine=null;}
                    multiLineComment = true;
                }
                else
                if (inputLine.indexOf(endComment) >=0) {
                   if (inputLine.indexOf(endComment) >0) {
                    inputLine = inputLine.substring(inputLine.indexOf(endComment) + 2);
                  }
                  else {inputLine=null;}
                    multiLineComment=false;
                }
               if (multiLineComment) {inputLine=null;}
                if (inputLine!=null)   {
                  javatext.append(inputLine).append("\n");
              }
            }
        } catch (IOException e) {throw new IOException("Ошибка чтения файла "+filenameIn,e);}
/* начало многострочного комента
        выводим результат
        окончание многостровного комента */
        try (PrintWriter writer = new PrintWriter(filenameOut)){
            writer.print(javatext);
        }
        Files
                .lines(Paths.get(filenameOut))
                .forEach(System.out::println);
    }

    }


