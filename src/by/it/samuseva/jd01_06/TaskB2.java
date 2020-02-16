package by.it.samuseva.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static final String symbol = ".?!";
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ ,-.:!?]+");
        Matcher m = p.matcher(Poem.text);
        StringBuilder text = new StringBuilder(800);
        while (m.find()){
            String sentence = m.group();
            if (sentence!= null && symbol.indexOf(sentence.charAt(sentence.length()-1))>=0) {
                text.append(sentence);
                text.append("\n");
            }
            if (sentence!= null && symbol.indexOf(sentence.charAt(sentence.length()-1))<0) {
                text.append(m.group());
                text.append(" ");
            }
        }
        String t = text.toString();
        String t1 = t.replaceAll("[-.,:!?]+", " ");
        t = t1.replaceAll("[ ]{2,}", " ");
        String[] arraySentence = t.split("[ ][\\\n]");
        int[] length = new int[arraySentence.length];
        // trim кождой строки + определение дленны строки

        for (int i = 0; i < length.length; i++) {
            arraySentence[i].trim();
            length[i]=arraySentence[i].length();
        }
        int[] length1 = Arrays.copyOf(length, length.length);
        Arrays.sort(length1);
       for (int i = 0; i < length.length-1; i++) {
            for (int j = 0; j < length.length; j++) {
                if (length1[i] == length[j]){
                    if (length1[i]!=length1[i+1]) {
                        System.out.println(arraySentence[j]);
                        continue;
                    }
                }
            }
            if (i+1 == length.length-1) {
                for (int j = 0; j < length.length; j++) {
                    if (length1[i+1] == length[j]){
                        System.out.println(arraySentence[j]);
                        continue;
                        }
                    }
            }
       }
    }


}
