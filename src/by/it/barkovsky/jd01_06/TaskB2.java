package by.it.barkovsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("\n+", " ");
        text = text.replaceAll("[.]{2,}", " ");
        //text = text.replaceAll("[^а-яА-ЯёЁ\\.]+", " ").trim();

        Pattern sent = Pattern.compile("[А-ЯЁё][^.?!]+[.!?]");
        Matcher matcher = sent.matcher(text);
        int count = 0;
        while (matcher.find()) count++;

        String[] arrSent = new String[count];
        matcher.reset();
        int i = 0;
        while (matcher.find()){
            arrSent[i++] = matcher.group().replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        sort(arrSent);

        for (String s : arrSent) {
            System.out.println(s);
        }



    }
    static void sort(String[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(String[] arr, int start, int stop) {
        if (arr.length == 0) return;
        if (start >= stop) return;
        // выбрать опорный элемент
        String opora = arr[(start + (stop - start) / 2)];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = start, j = stop;
        while (i <= j) {
            while (arr[i].length() < opora.length()) {
                i++;
            }
            while (arr[j].length() > opora.length()) {
                j--;
            }
            if (i <= j) {//меняем местами
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quickSort(arr, start, j);
        if (stop > i) quickSort(arr, i, stop);

    }
}