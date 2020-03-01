package by.it.filipovich.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String fileNameOne = Helper.pathToFile("text.txt", TaskB.class);
        String fileNameTwo = Helper.pathToFile("resultTaskB.txt", TaskB.class);

        List<String> lines = Files.readAllLines(Paths.get(fileNameOne), StandardCharsets.UTF_8);
        for(String line: lines){
            sb.append(line).append(" ");
        }

        int symbols = getSymbols(sb.toString());
        int words = getWords(sb.toString());
        System.out.println("words="+words+", punctuation marks="+symbols);
        try (PrintWriter writer = new PrintWriter(fileNameTwo)){
            writer.print("words="+words+", punctuation marks="+symbols);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    private static int getWords(String s) {
        int countWord = 0;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            countWord++;
        }
        return countWord;
    }

    private static int getSymbols(String s) {
        int countSymbol = 0;
        s=s.replaceAll("\n"," ").replaceAll(" +","");
        Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            countSymbol++;
        }
        return countSymbol;
    }


}
