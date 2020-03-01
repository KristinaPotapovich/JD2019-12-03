package by.it.filipovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Helper {

    static String pathToFile(String fileName, Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String strPackage = aClass.getName().replace(aClass.getSimpleName(), "");
        String path = root + File.separator + "src" + File.separator + strPackage.replace(".", File.separator);
        fileName = path + fileName;
        return fileName;
    }

    static void insertNumbers(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)))
        ){
            for (int i = 0; i < 20; i++) {
                int number = (int) (Math.random() * 100);
                dos.writeInt(number);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readAndWrite(String fileNameOne, String fileNameTwo) {
        List<Integer> list = new ArrayList<>();
        double sum = 0;

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileNameOne)));
             PrintWriter writer = new PrintWriter(fileNameTwo)){

            while (dis.available() > 0){
                int i = dis.readInt();
                writer.print(i+" ");
                sum = sum+i;
                list.add(i);
                System.out.print(i+" ");

            }
            writer.print("\n"+sum/list.size());
            System.out.println("\navg="+sum/list.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
