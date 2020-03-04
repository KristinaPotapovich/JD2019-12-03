package by.it.busel.calc02_06;

/**
 * a factory to create a Matrix
 */
public class MatrixCreator extends VarCreator {
    /**
     * a String that is to be converted to Matrix
     */
    private String expression;

    /**
     * the only constructor
     *
     * @param expression a String that contains a Matrix expression
     */
    public MatrixCreator(String expression) {
        this.expression = expression;
    }

    /**
     * a method that creates Matrix on the basis of a method argument
     *
     * @return a Matrix object
     */
    @Override
    public Var create() {
        return new Matrix(expression);
    }
}