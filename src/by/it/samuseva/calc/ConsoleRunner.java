package by.it.samuseva.calc;

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
            try {
                printer.print(parset.calc(line));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
      //  Var.sortvar();
    }
}
