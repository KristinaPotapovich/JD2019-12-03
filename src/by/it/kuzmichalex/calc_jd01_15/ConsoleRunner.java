package by.it.kuzmichalex.calc_jd01_15;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.loadLog();
        Logger.printAndLog("Calculator started");
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVarsFromFile();


        while (true) {
            try {
                String expression = scanner.next();
                Logger.printAndLog("Expression: " + expression);
                if (expression.equals(KeyWords.PRINTVAR)) {
                    Logger.printAndLog(Var.printVars());
                    //System.out.println(Var.printVars());
                    continue;
                }
                if (expression.equals(KeyWords.SORTVAR)) {
                    Logger.printAndLog(Var.sortVars());
                    //System.out.println(Var.sortVars());
                    continue;
                }
                if (expression.equals("end") || expression.equals("exit") || expression.equals("quit")){
                    Logger.printAndLog("Calculator stopped.");
                    break;
                }
                Var result = parser.calc(expression);
                Logger.printAndLog(result.toString());
                //printer.print(result);
            }
            catch (CalcException e){
                Logger.printAndLog(e.getMessage());
            }
        }
    }
}
