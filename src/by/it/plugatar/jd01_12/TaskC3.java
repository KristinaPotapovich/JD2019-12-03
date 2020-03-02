package by.it.plugatar.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[\\(\\)\\{\\}\\[\\]]");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "{[6+{(2+3)*5}-10]+[15-4]}+8}";
        Matcher matcher = pattern.matcher(str);

        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }

        System.out.println("Result: " + check(list));
    }

    private static boolean check(List<String> list) {
        List<String> open = Arrays.asList("{", "[", "(");
        List<String> close = Arrays.asList("}", "]", ")");

        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : list) {
            if (open.contains(s)) {
                linkedList.add(s);
            } else if (close.contains(s)) {
                int i = close.indexOf(s);
                if (!linkedList.isEmpty() && open.get(i).equals(linkedList.getLast())) {
                    linkedList.pollLast();
                } else {
                    return false;
                }
            }
        }

        return linkedList.isEmpty();
    }

}