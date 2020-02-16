package by.it.tarasevich.jd01_06;


import java.util.Arrays;

public class TaskB2 {
    public static void main(String[] args) {
        String str = Poem.text.replace("\n", " ").replace("!",".").replace(" - "," ").
                replace("...","").replace(",","").replace(":","").trim();
        String[] res = str.split("[\\.][ ]");
        Arrays.sort(res, (o1, o2) -> o1.length() - o2.length());
        for (String sent : res) {
            System.out.println(sent);
        }
    }
}
