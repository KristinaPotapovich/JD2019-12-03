package by.it.potapovich.jd01_14;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);

        return path + clDir;
    }

    public static void main(String[] args) {

        File f = new File(dir(TaskB.class)+ File.separator + "text.txt");
        int count = 0;
        String text;
        String textWithoutPunctual;
        int countOfMarks = 0;
        FileReader is = null;

        try(PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt")))
        {
            is = new FileReader(f);
            Scanner scanner = new Scanner(is).useDelimiter("\n");
            while (scanner.hasNextLine()) {
                text = scanner.nextLine();
                Matcher matcher = Pattern.compile("[!.,;:?]").matcher(text);
                while (matcher.find()) {
                        countOfMarks++;
                    }
                    textWithoutPunctual = text.replaceAll("\\p{Punct}", "");
                    String[] words = textWithoutPunctual.split(" ");
                    for (String word : words) {
                        if (word.isEmpty()) {
                            continue;
                        }
                        count++;
                    }
                }
                System.out.println("words=" + count + ", " + "punctuation marks=" + countOfMarks);
                out2.print(("words=" + count + ", " + "punctuation marks=" + countOfMarks));
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
         }
      }



