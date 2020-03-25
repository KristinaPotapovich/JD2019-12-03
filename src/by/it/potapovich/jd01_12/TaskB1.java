package by.it.potapovich.jd01_12;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String text = "";
        int i = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.isEmpty()) {
                continue;
            }
            str = str.replaceAll("[.\\-,—?\"!;:/]", " ");
            str = str.replaceAll("\n+|\r\n+", " ");
            str = str.replaceAll("[\\s]{2,}", " ");
            if (str.equals("end")) {
                text = text.concat(" " + str);
                break;
            }
            text = text.concat(str + " ");
        }
        String[] array = text.split(" ");
        for (String word : array) {
            if (word.isEmpty()) {
                continue;
            }
            System.out.println(word);
            if (!hashMap.containsKey(word)) {
                hashMap.put(word, 1);
            } else if (hashMap.containsKey(word)) {
                if (word.equals("isn't")) {
                    hashMap.put("don't", hashMap.get("don't") + 1);
                    continue;
                }
                hashMap.put(word, hashMap.get(word) + 1);
            }
        }
        System.out.println(hashMap);
    }
}






        

