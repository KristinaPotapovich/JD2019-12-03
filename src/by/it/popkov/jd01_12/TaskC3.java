package by.it.popkov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Подходит для простых случаев. На ()[()]{()()[]} выдаёт false, хотя должно true

class TaskC3 {
    static boolean check(String row) {
        List<String> list = new LinkedList<>();
        Pattern p = Pattern.compile("[\\[\\](){}]");
        Matcher m = p.matcher(row);
        while (m.find()) {
            list.add(m.group());
        }
        while (list.size() > 0) { // Удаляем правильные пары пока не будет 0 size
            if ((list.get(0).equals("{") && list.get(1).equals("}"))
                    || (list.get(0).equals("(") && list.get(1).equals(")"))
                    || (list.get(0).equals("[") && list.get(1).equals("]"))) {
                list.remove(1);
                list.remove(0);
            } else if (((list.get(list.size() - 2)).equals("{") && list.get(list.size() - 1).equals("}"))
                    || ((list.get(list.size() - 2)).equals("(") && list.get(list.size() - 1).equals(")"))
                    || ((list.get(list.size() - 2)).equals("[") && list.get(list.size() - 1).equals("]"))) {
                list.remove(list.size() - 2);
                list.remove(list.size() - 1);
            } else if ((list.get(0).equals("{") && list.get(list.size() - 1).equals("}"))
                    || (list.get(0).equals("(") && list.get(list.size() - 1).equals(")"))
                    || (list.get(0).equals("[") && list.get(list.size() - 1).equals("]"))) {
                list.remove(list.size() - 1);
                list.remove(0);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        System.out.println(check(row));
    }
}