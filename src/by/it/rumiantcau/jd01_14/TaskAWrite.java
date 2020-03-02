package by.it.rumiantcau.jd01_14;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskAWrite {

    public static void writeInt(String fileName) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            //  dos.writeInt('Я'+'Ё'*256*256+'D'*256*256*256);
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 100);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            System.out.println("Ниасилил");
        }
    }


}
