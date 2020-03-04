package by.it.busel.calc02_06;

/**
 * a factory to create a Scalar
 */
public class ScalarCreator extends VarCreator {
    /**
     * a String that is to be converted to Scalar
     */
    private String expression;

    /**
     * the only constructor
     *
     * @param expression a String that contains a Scalar expression
     */
    public ScalarCreator(String expression) {
        this.expression = expression;
    }

    /**
     * a method that creates Scalar on the basis of a method argument
     *
     * @return a Scalar object
     */
    @Override
    public Var create() {
        return new Scalar(expression);
    }
}