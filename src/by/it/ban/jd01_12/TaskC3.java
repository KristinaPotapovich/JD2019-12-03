package by.it.ban.jd01_12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String next = scanner.next();
            if(next.equals("end")) break;
            if (check(next)) System.out.println("Ошибок нет");
            else System.out.println("Ошибки в скобках");
        }
    }

    private static boolean check(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c=='('||c=='['||c=='{') deque.addFirst(c);
            else if (c==')'||c==']'||c=='}') {
                Character cha;
                cha =  deque.pollFirst();
                if(cha != null) {
                    if (!(cha == '(' && c == ')' || cha == '{' && c == '}' || cha == '[' && c == ']')) {
                        return false;
                    }
                }else return false;
            }
        }
        if (deque.pollFirst()!=null) return false;
        return true;
    }
}
