package by.it.rumiantcau.jd01_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TaskC {
    private static StringBuilder readTextFile(String fileNameB) {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileNameB), StandardCharsets.UTF_8))){
            while ((line = reader.readLine()) != null) {
                str.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("It is a trap!");
        }
        return str;
    }

}
