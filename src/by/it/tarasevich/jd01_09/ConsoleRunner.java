package by.it.tarasevich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;

        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(s = scanner.nextLine()).equals("end")){
            Var result = parser.calc(s);
            printer.print(result);
        }


    }
}
