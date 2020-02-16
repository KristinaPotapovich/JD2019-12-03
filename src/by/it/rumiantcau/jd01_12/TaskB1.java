package by.it.rumiantcau.jd01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB1 {
    public static void main(String[] args) throws IOException {
        String word;
        BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
        int wordsStat = 0; //счетчик частотности слова
        String text = null; // переменная, где будет хранится введенный текст
        while(true){
            word = str.readLine();
            if(word.equals("end"))
                break;
            text += word;
        }
        //чистим текст от пробелов, точек и прочих знаков препинания
        String text2 = (text.replace("\n", "").replace("!","").
                replace(" - "," ").replace("  "," ").
                replace("...","").replace(",","").
                replace(":","").replace(".", "").
                replace(";", "").replace("—","").
                replace(")", "").replace("(","").
                replace("?","").replace("[","").
                replace("]","").replace("isn't", "don’t")
                .replace("  "," ")).trim();
        String[] textArray = text2.split(" ");
        //получаем список с уникальными словами текста для сравнения
        Set<String> unicWords = new HashSet(Arrays.asList(textArray));
        //переносим в линкед лист наш массив всех слов текста
        List<String> textList = new LinkedList<String>(Arrays.asList(textArray));
        //создаем список Хешмап, где будут хранится слова и их частотность
        Map<String, Integer> textMapStat = new HashMap<>();
        Iterator<String> iteratorHash = unicWords.iterator();


        while (iteratorHash.hasNext()){
            String a =iteratorHash.next();
            Iterator<String> iteratorList = textList.iterator();
            while(iteratorList.hasNext()){
                String b = iteratorList.next();
                if(b.equals(a)) {wordsStat++;
                iteratorList.remove();
                }
            }
            textMapStat.put(a, wordsStat);
            wordsStat = 0;
        }
        System.out.println(textMapStat);



        // List<String> text = new LinkedList<>(Arrays.asList("q", "qqq", "qq", "ddd", "cdcdg", "q", "q", "q", "qqq", "qqq", "q", "qq", "ddd", "ddd", "ddd", "d"));
    /*    Map<String, Integer> textStat = new HashMap<>();
        int wordsCount = 0;
        int wordsStat = 1;
       */

        //почистить текст от знаков припинания

/*        while(true){
            word = str.readLine();
            if(word.equals("end"))
                break;
            text.add(word);
        }
*/
/*
        Iterator<String> iterator = text.iterator();


        for (int i = 0; i < text.size(); i++) {
            word = text.get(i);

            while (iterator.hasNext()) {
                word2 = iterator.next();
                if (word2.equals(word)) {
                    wordsStat++;
                    iterator.remove();
                }
            }
            textStat.put(word, wordsStat);
            wordsStat = 1;
            wordsCount++;
        }




        System.out.println(wordsCount);
        System.out.println(textStat);
*/








    }
}
