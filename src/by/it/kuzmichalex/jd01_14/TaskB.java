package by.it.kuzmichalex.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        int countOfWords = 0;
        int countOfPuncts = 0;
        boolean wordReading = false;
        int intByte;
        String sFileName = FHelper.getFileName("text.txt", TaskB.class);

        try (BufferedReader br = new BufferedReader(new FileReader(sFileName))) {
            while ((intByte = br.read()) != -1) {
                int charType = Character.getType(intByte);
                switch (charType) {
                    case 1:
                    case 2:
                        if (!wordReading) countOfWords++;
                        wordReading = true;
                        break;
                    case 24:
                        wordReading = false;
                        countOfPuncts++;
                        break;
                    default:
                        wordReading = false;
                }
                //System.out.println((char) readed + " " + Character.getType (readed));
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + sFileName);
        }
        //Хвастоство результатами
        System.out.println("words=" + countOfWords + ", punctuation marks="+countOfPuncts);
        sFileName = FHelper.getFileName("resultTaskB.txt", TaskA.class);
        printResultToFile(countOfWords,countOfPuncts,sFileName);
    }
    /**
     * Вывод важной информации о результаттах подсчёта
     * */
    private static void printResultToFile(int countOfWords, int countOfPuncts, String sFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sFileName))
        ) {
            bw.write("words=" + countOfWords + ", punctuation marks="+countOfPuncts);
        } catch (IOException e) {
            System.out.println("Output error. File:" + sFileName);
        }

    }


}
