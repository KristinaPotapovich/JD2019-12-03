package by.it.rumiantcau.jd01_06;

public class TaskB2 {

    /*
    * Вывести через \n все предложения текста в порядке возрастания количества символов
(!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
последовательности на один пробел и выполнить trim() для каждого предложения.*/
    public static void main(String[] args) {
//подразобраться с регулярками все еще не до конца одупляю

       // System.out.println(Poem.text);


        String poem2 = ((Poem.text).replace("\n", " ").replace("!",".").
                replace(" - "," ").replace("  "," ").
                replace("...","").replace(",","").
                replace(":","")).trim();
        String a;
        String[] poemMas = poem2.split("\\.");

       // sort(poemMas);
        for (int i = 0; i < poemMas.length; i++) {
            for (int j = 0; j < poemMas.length-1; j++) {
                if (poemMas[j].length() > poemMas[j+1].length())
                { a = poemMas[j];
                    poemMas[j] = poemMas[j+1];
                    poemMas[j+1] = a;
                }
            }

        }

        for (int i = 0; i < poemMas.length; i++) {
            System.out.println(poemMas[i]);
        }

    }

}
