package by.it.kuzmichalex.calc_jd02_06;

import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.getInstance().loadLog();
        Logger.getInstance().printAndLog(LanguageManager.get(Messages.calculator_running));

        Parser parser = new Parser();
        Var.loadVarsFromFile();

        while (true) {
            try {
                String expression = scanner.next();
                Logger.getInstance().printAndLog(LanguageManager.get(Messages.expression) + expression);
                if (expression.equals(KeyWords.PRINTVAR)) {
                    Logger.getInstance().printAndLog(Var.printVars());
                    continue;
                }
                if (expression.equals(KeyWords.SORTVAR)) {
                    Logger.getInstance().printAndLog(Var.sortVars());
                    continue;
                }
                if (expression.equals(KeyWords.LANGUAGE_BE) || expression.equals(KeyWords.LANGUAGE_BY) ||
                        expression.equals(KeyWords.LANGUAGE_EN) || expression.equals(KeyWords.LANGUAGE_RU)) {
                    LanguageManager.setLanguage(expression);
                    Logger.getInstance().printAndLog(LanguageManager.get(Messages.calculator_running));
                    continue;
                }
                if (expression.equals(KeyWords.END) || expression.equals(KeyWords.EXIT) || expression.equals(KeyWords.QUIT)) {
                    Logger.getInstance().printAndLog(LanguageManager.get(Messages.calculator_stopped));
                    break;
                }
                Var result = parser.calc(expression);
                Logger.getInstance().printAndLog(result.toString());
            } catch (CalcException e) {
                Logger.getInstance().printAndLog(e.getMessage());
            }
        }
    }
}
