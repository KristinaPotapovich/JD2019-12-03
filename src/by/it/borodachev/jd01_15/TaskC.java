package by.it.borodachev.jd01_15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    private static String currentDir;
   private static String changecurrentDir(String dirName)
   {
       String newDirName;
       File dir = new File(currentDir);
       if (dirName.equals("..") ){
        newDirName=dir.getParentFile().getAbsolutePath();
        }
       else {
           try {
               newDirName=currentDir+File.separator+dirName;
               File tmpdir = new File(newDirName);
               if (!tmpdir.isDirectory())
               {throw new IOException ("Path not Found " + dirName);}
           }
           catch (IOException e)
        {
            System.out.println(e);
            newDirName = currentDir;
        }
       }
       return newDirName;
   }
   private static void fileDirInfo(String dirName)
    {
        int dirCount=0;
        int filesLength=0;
        int fileCount=0;
        File dir = new File(dirName);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        StringBuilder rowFile=new StringBuilder();
        File [] files=dir.listFiles();
        for (File f : files) {

            rowFile.append(sdf.format(f.lastModified())).append("\t");
            if (f.isDirectory()) {
                dirCount++;
                rowFile.append("DIR\t\t").append(f.getName()).append("\n");
            }
            else {
                fileCount++;
                filesLength+=f.length();
                rowFile.append("\t").append(f.length()).append("\t").append(f.getName()).append("\n");
            }
        }
        rowFile.append("\t").append(fileCount).append(" files ").append(filesLength).append("\n");
        rowFile.append("\t").append(dirCount).append(" Dirs").append("\n");
        System.out.println(rowFile);
    }
    public static void main(String[] args) {
        currentDir=Helper.getPath("", TaskC.class);
        try (Scanner scanner = new Scanner(System.in)) {

            String strCommand = "";
            while (!strCommand.toLowerCase().equals("end")) {
                System.out.print(currentDir+File.separator+">");
                strCommand = scanner.next();
              if (strCommand.toLowerCase().equals("cd") )
              {
                  //смена каталога
                  String newDir=scanner.next();
                  newDir=changecurrentDir(newDir.trim());
                   currentDir=newDir;
              }
              if (strCommand.toLowerCase().equals("dir") )
              {
                  // вывод каталога
                  fileDirInfo(currentDir);
              }

            }

            }
        }
    }

