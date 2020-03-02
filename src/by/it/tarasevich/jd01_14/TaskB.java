package by.it.tarasevich.jd01_14;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        String p = System.getProperty("user.dir") + "/src/by/it/tarasevich/";
        String file1 = p + "jd01_14/text.txt";

        try (BufferedReader fr = new BufferedReader(new FileReader(file1))) {
            String s = "";
            while ((s = fr.readLine()) != null) {
                String[] str = s.split("\\s");
                for (int i = 0; i < str.length; i++) {
                    System.out.println(str[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}