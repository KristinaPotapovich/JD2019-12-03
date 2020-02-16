package by.it.filipovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Training {
    public static void main(String[] args) {
    String[] str = new String[]{"abc","def","ghi","jkl"};
        List<String> line = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String s : str) {
            line.add(s);
            set.add(s);
        }
        String s = line.get(2);
        System.out.println(line);
        System.out.println(set);

    }

}
