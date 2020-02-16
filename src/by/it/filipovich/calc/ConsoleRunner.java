package by.it.filipovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer pr = new Printer();
        while (true){
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            else
            pr.print(parser.calc(expression));
        }
    }

}
