package by.it.busel.jd01_09;

/**
 * an interface which provided a contract of methods, which are to be implemented
 */
public interface Operation {
    /**
     * a contract of a mathematical operation "addition"
     *
     * @param other an instance of Var-class or its subclasses, which is to be added
     * @return a result of addition
     */
    Var add(Var other);

    /**
     * a contract of a mathematical operation "subtraction"
     *
     * @param other an instance of Var-class or its subclasses, which is to be subtracted
     * @return a result of subtraction
     */
    Var sub(Var other);

    /**
     * a contract of a result of subtraction "multiplication"
     *
     * @param other an instance of Var-class or its subclasses, which is a multiplier
     * @return a result of a multiplication
     */
    Var mul(Var other);

    /**
     * a contract of a result of subtraction "division"
     * @param other an instance of Var-class or its subclasses, which is divisor
     * @return a result of division
     */
    Var div(Var other);
}
