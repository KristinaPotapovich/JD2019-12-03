package by.it.busel.calc;

class ConsoleCommands {
    static final String PRINTVAR = "PRINTVAR";
    static final String SORTVAR = "SORTVAR";

    public static void call(String varExpression) {
        if (varExpression.toUpperCase().equals(ConsoleCommands.PRINTVAR)) {
            Storage.printvar();
        } else if (varExpression.toUpperCase().equals(ConsoleCommands.SORTVAR)) {
            Storage.sortvar();
        }
    }
}
