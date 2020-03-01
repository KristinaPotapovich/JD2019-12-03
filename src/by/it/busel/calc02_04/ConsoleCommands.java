package by.it.busel.calc02_04;

/**
 * a class which contains main commands that can be called in order to perform some actions with
 * var expressions that were assigned and saved during previous executions of "Calc project"
 */
class ConsoleCommands {
    /**
     * a String containing character data, to which an input is being compared, and which defines whether
     * a user of "Calc" wants to view all assigned and saved var expressions
     */
    private static final String PRINTVAR = "PRINTVAR";

    /**
     * a String containing character data, to which an input is being compared,
     * and which defines whether a user of "Calc" wants to
     * view all assigned and saved var expressions in a sorted by names order
     */
    private static final String SORTVAR = "SORTVAR";

    /**
     * a method which verifies if one of "Calc" commands is called
     *
     * @param varExpression a String which potentially can contain a "Calc" command
     * @return a boolean expression that states "true" when one of "Calc" commands was called
     */
    public static boolean call(String varExpression) {
        if (varExpression.toUpperCase().equals(ConsoleCommands.PRINTVAR)) {
            Storage.printvar();
        } else if (varExpression.toUpperCase().equals(ConsoleCommands.SORTVAR)) {
            Storage.sortvar();
        } else return false;
        return true;
    }
}
