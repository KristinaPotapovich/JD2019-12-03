package by.it.shulga.jd01.jd01_06;

public class  TaskB1 {
      public static void main(String[] args) {
                        String text = Poem.text;
                        text = text.trim();
                        text = text.replaceAll("\\p{Punct}", "");
                 char[] glas = {'а', 'е', 'ё', 'и', 'о',  'у', 'э', 'ы', 'я', 'ю','А', 'Е', 'Ё', 'И', 'О',  'У', 'Э', 'Ы', 'Я', 'Ю'};
                 char[] cons = {'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф', 'в', 'п', 'р', 'л', 'д', 'ж', 'ч', 'с', 'м', 'т', 'б','Ц', 'К', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ф', 'В', 'П', 'Р', 'Л', 'Д', 'Ж', 'Ч', 'С', 'М', 'Т', 'Б', };
        for (int j = 0; j < glas.length; j++) {
            for (int k = 0; k < cons.length; k++) {
                char glas1 = glas[j];
                char cons1 = cons[k];

                String[] line = text.split("\n");
                 for (String s : line) {
                    String[] words = s.split(" ");

                    for (int i = 0; i < words.length; i++) {
                        String word = words[i];
                        boolean isWordInvalid = word.trim().isEmpty() || word.length() == 1;
                        if (isWordInvalid) {
                            continue;
                        }
                        char indexStart = word.charAt(0);
                        char indexEnd = word.charAt(word.length() - 1);

                        if (indexStart == cons1 && indexEnd == glas1) {
                            System.out.println(word);
                        }


                    }


                }
            }
        }
    }
}


