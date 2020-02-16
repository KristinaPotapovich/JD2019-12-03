package by.it.potapovich.jd01_12;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new LinkedHashMap<>();
        //List<String> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String text = "";
        int i = 0;
        while (sc.hasNextLine()) {
          //  System.out.println(i++);
            String str = sc.nextLine();

            //System.out.println("--------------------------------------------------------");
     //       System.out.println(str);
         //   System.out.println("--------------------------------------------------------");
       //     System.out.println();

            if (str.isEmpty()){
                continue;
            }


           // str = str.trim();
            str = str.replaceAll("[.\\-,—?\"!;:/]", " ");
            str = str.replaceAll("\n+|\r\n+", " ");
            str = str.replaceAll("[\\s]{2,}", " ");


            if (str.equals("end")){
                text = text.concat(" "+str);
                break;
            }

            text = text.concat(str + " ");

            //    String[] array = str.split(" ");


//             for (String s : array) {
//                System.out.println(s);
//             }

            //s = s.replaceAll("\\p{Punct}", " ");
            // s= s.replaceAll("\n+|\r\n+", " ");
            // s = s.replaceAll("[\\s]{2,}", " ");

            // for (int i = 0; i < words.length; i++) {
            //   for (int j = 0; j < words.length; j++) {
            //   String word = words[i];
            //  String wordSecond = words[j];
            // System.out.println(word);
            // Integer pos = 0;
            //while (!word.equals("end")) {



   /*
            for (String word : array) {
                if (!hashMap.containsKey(word)) {
                    hashMap.put(word, 1);
                } else if (hashMap.containsKey(word)) {
                    hashMap.put(word, hashMap.get(word) + 1);
              //  }else if (word.equals("end")){
                 //   break;
                }
*/




                // for ( word : hashMap.keySet();


                //}
                //  System.out.println(word);
                // System.out.println(word + "=" +hashMap.get(word));


      //      }
        }
       // System.out.println(text);

        String[] array = text.split(" ");


     //   System.out.println(words);

        for (String word : array) {
            if (word.isEmpty()) {
                continue;
            }
            System.out.println(word);
            if (!hashMap.containsKey(word)) {
                hashMap.put(word, 1);
            } else if (hashMap.containsKey(word)) {
                if (word.equals("isn't")){
                    hashMap.put("don't", hashMap.get("don't") + 1);
                    continue;
                }
                hashMap.put(word, hashMap.get(word) + 1);
                //  }else if (word.equals("end")){
                //   break;
            }
        }
        System.out.println(hashMap);
        }
}






        
 //   }
//}
