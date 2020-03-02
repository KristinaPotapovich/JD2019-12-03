package by.it.shpakovskiy.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class TaskC {
    public static void main(String[] args) {
        String path="src/by/it/shpakovskiy";
        List<String> list= getListFilesAndDirectories(path);
        printList(list,System.out);
        try (final PrintStream printStream = new PrintStream("src/by/it/shpakovskiy/jd01_14/resultTaskC.txt")){
            printList(list,printStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param writer can be console stream (System.out) or file stream
     */
    static void printList(List<?> list, PrintStream writer) {
        list.forEach(writer::println);
    }

    /**
     * This method is recursive!!!
     * @param path is the path to the start directory.
     * @return list of all files and directories that are in the transferred directory
     */
    static List<String> getListFilesAndDirectories(String path){
        List<String> list=new ArrayList<>();
        File directory=new File(path);
        File[] files=directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()){
                list.add("file:"+file.getName());
            }else if (file.isDirectory()){
                list.add("dir:"+file.getName());
                list.addAll(getListFilesAndDirectories(file.getPath()));
            }
        }
        return list;
    }
}
