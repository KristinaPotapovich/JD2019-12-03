package by.it.samuseva.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parset parset = new Parset();
        Printer printer = new Printer();
        while (true){
            String line = scan.next();
            if (line.equals("end")){
                break;
            }
            printer.print(parset.calc(line));
        }
    }
}
