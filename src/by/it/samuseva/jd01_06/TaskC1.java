package by.it.samuseva.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        StringBuilder[] textEnd = new StringBuilder[1];
        String str = "Там русский дух... там ";
        Pattern pat = Pattern.compile("[А-ЯЁ]{1}[ БЯКа-яё!?,.:-]+");
        Matcher mat = pat.matcher(Poem.text);
      //  System.out.println(Poem.text);
       // int[] length = new int[1];
        int i=0;
       /* while (mat.find()){
            if (!mat.equals(str)) {
                textEnd[i] = textEnd[i].append(mat);
                textEnd = Arrays.copyOf(textEnd,textEnd.length+1);
                System.out.println(textEnd[i]);
                i++;
            } else {textEnd[i] = textEnd[i].append(mat);}
            }
          /*  int startIndex = mat.start();
            int endIndex = mat.end();
            length[i] = endIndex - startIndex;
            length = Arrays.copyOf(length,length.length+1);

            System.out.println(length[i] + " " + mat);
            i++;*/





    }
}
