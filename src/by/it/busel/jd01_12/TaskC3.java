package by.it.busel.jd01_12;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    static class Stack<T> {
        private LinkedList<T> storage = new LinkedList<>();

        void push(T value) { storage.addFirst(value); }

        T peek() {
            return storage.getFirst();
        }

        T pop() { return storage.removeFirst(); }

        boolean empty() { return storage.isEmpty(); }

        public java.lang.String toString() {
            return storage.toString();
        }

    }

    private static class Patterns {
        private static final String allBrackets = "[{}()\\[\\]]";
    }

    private static void checkWhetherInputIsCorrectFrom(Scanner sourceScanner) {
        while (true) {
            String line = sourceScanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            Matcher bracketsMatcher = Pattern.compile(Patterns.allBrackets).matcher(line);
            Stack<Character> brackets = new Stack<>();
            bracketsOrderChecker(bracketsMatcher, brackets);
        }
    }

    private static void bracketsOrderChecker(Matcher matcher, Stack<Character> brackets) {
        boolean lineIsStillCorrect = true;
        while (matcher.find() && lineIsStillCorrect) {
            char bracket = matcher.group().charAt(0);
            switch (bracket) {
                case '{': brackets.push('}'); break;
                case '(': brackets.push(')'); break;
                case '[': brackets.push(']'); break;
                default:
                    if (!brackets.empty() && brackets.pop().equals(bracket)) {
                        break;
                    } else {
                        lineIsStillCorrect = false;
                    }
                    break;
            }
        }
        System.out.println(lineIsStillCorrect && brackets.empty());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkWhetherInputIsCorrectFrom(scanner);
    }
}
