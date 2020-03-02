package by.it.tarasevich.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static String dir(Class<?> cl) {
        String p = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String w = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return p + w;
    }
    public static void main(String[] args) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (java.lang.Math.random()*100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter pr = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))) {
            double count = 0;
            double sum = 0;
            List<Integer> list = new ArrayList<>();
            while (dis.available() > 0) {
                Integer i = dis.readInt();
                list.add(i);
                    System.out.print(i + " ");
                    pr.print(i + " ");
                    sum = i + sum;
                    count++;
                            }
            System.out.println("\navg=" + sum / count);
            pr.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



