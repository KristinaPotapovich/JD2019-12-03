package by.it.filipovich.calc;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer pr = new Printer();
        VarToFile.load();
        while (true){
            String expression = scanner.nextLine();
            if(expression.equals("end"))
                break;
            if(expression.equals("printvar")){
                for (Map.Entry<String, Var> pair : Var.vars.entrySet()) {
                    System.out.println(pair);
                }
                break;
            }
            if(expression.equals("sortvar")){
                for (Map.Entry<String, Var> varEntry : new TreeMap<>(Var.vars).entrySet()) {
                    System.out.println(varEntry);
                }
                break;
            }
            //Var result = null;
            try {
                Var result = parser.calc(expression);
                pr.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
