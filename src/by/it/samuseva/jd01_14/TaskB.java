package by.it.samuseva.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {
        String fileName = Helper.getPath("text.txt", TaskB.class);
        readInFileToStringBuilder(fileName);
        System.out.println("words=" + getWords()+ ", punctuation marks=" + getPunctuationMarks());
        String resultFile = Helper.getPath("resultTaskB.txt", TaskB.class);
        writerToFile(resultFile);
    }

    private static void readInFileToStringBuilder(String fileName) {
        try (BufferedReader fileText = new BufferedReader (new FileReader(fileName))
        ){
            String line;
            while ((line = fileText.readLine()) != null){
               text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("File cannot be read!!!");
        }
    }

    private static int getWords() {
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mat = pat.matcher(text);
        int words = 0;
        while (mat.find()){
            words++;
        }
        return words;
    }

    private static int getPunctuationMarks() {
        int punctuationMarks = 0;
        String marks = "-.,:;?!";
        for (int i = 0; i < text.length()-1; i++) {
            if ((marks.indexOf(text.charAt(i))>=0)&&(marks.indexOf(text.charAt(i+1))<0)) punctuationMarks++;
        }
        return punctuationMarks;
    }

    private static void writerToFile(String resultFile) {
        try (PrintWriter pw = new PrintWriter(resultFile)) {
            pw.print("words=" + getWords()+ ", punctuation marks=" + getPunctuationMarks());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
