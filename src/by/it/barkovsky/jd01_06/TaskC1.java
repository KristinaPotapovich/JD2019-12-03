package by.it.barkovsky.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        int maxline = 0;
        int lines = 0;
        String[] arrStr = Poem.text.split("\n");
        for (String s : arrStr) {
            if (maxline < s.length()) maxline = s.length();
            lines++;
        }
        int i = 0;
        for (String str : arrStr) {
            StringBuilder newStr = new StringBuilder();
            String[] words = str.split(" ");
            int wordCount = str.split(" ").length - 1;
            int wordLength = 0;
            for (String word : words) {
                wordLength += word.length();
            }
            int spaceForAll = (maxline - wordLength) / (wordCount);
            int spaceForFirst = (maxline - wordLength) % (wordCount);
            for (int j = 0; j < wordCount; j++) {
                newStr.append(words[j]);
                if (spaceForFirst > 0) {
                    newStr.append(" ");
                    spaceForFirst--;
                }
                for (int k = 0; k < spaceForAll; k++) {
                    newStr.append(" ");
                }
            }
            newStr.append(words[wordCount]);
            System.out.println(newStr);
        }
    }
}