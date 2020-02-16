package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskC3 {
    public static void main(String[] args) {
//        String line1 = "([{<>}]) - true.";
//        String line2 = "([{]}) - false.";
//        String line3 = "((()())()) - true";
//        String line4 = ")(((())) - false.";
//        String line5 = "{}[]()(()[]) - true.";
//        String line6 = "(}{) - false.";
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5, line6));
//        for (String str : list){
//            System.out.println(str + " " + check(str));
//        }
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(check(line));
    }

    private static boolean check(String line) {
        line = line.replaceAll("[^{}\\[\\]()]+", "");
        char[] chars = line.toCharArray();
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('(', '{', '['));
        LinkedList<Character> closeBrackets = new LinkedList<>();
        for (char c : chars) {
            if (openBrackets.contains(c)) {
                switch (c) {
                    case '(':
                        closeBrackets.addLast(')');
                        break;
                    case '{':
                        closeBrackets.addLast('}');
                        break;
                    case '[':
                        closeBrackets.addLast(']');
                        break;
                }
            } else {
                if (closeBrackets.isEmpty()) {
                    return false;
                } else if (!closeBrackets.peekLast().equals(c)) {
                    return false;
                }
                closeBrackets.removeLast();
            }
        }
        return closeBrackets.isEmpty();
    }
}
