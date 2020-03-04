package by.it.busel.calc02_06;

/**
 * a factory to create a Matrix
 */
public class VectorCreator extends VarCreator {
    /**
     * a String that is to be converted to Vector
     */
    private String expression;

    /**
     * the only constructor
     *
     * @param expression a String that contains a Vector expression
     */
    public VectorCreator(String expression) {
        this.expression = expression;
    }

    /**
     * a method that creates Vector on the basis of a method argument
     *
     * @return a Vector object
     */
    @Override
    public Var create() {
        return new Vector(expression);
    }
}