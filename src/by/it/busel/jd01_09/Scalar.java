package by.it.busel.jd01_09;

/**
 * a scalar expression
 */
class Scalar extends Var {
    /**
     * a value of "this" scalar expression
     */
    private double value;

    /**
     * a method, which is a getter of a value of "this" scalar expression
     *
     * @return a value of a scalar expression
     */
    public double getValue() {
        return value;
    }

    /**
     * a constructor, which argument sets a value of "this" scalar expression
     *
     * @param value a value of a scalar expression
     */
    Scalar(double value) {
        this.value = value;
    }

    /**
     * a constructor, which argument is another scalar expression value of which is to be assigned as a value of "this"
     * scalar expression
     *
     * @param scalar another scalar expression value of which is to be assigned as a value of "this" scalar expression
     */
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    /**
     * a constructor that takes a String object, parses it into a value of "this" scalar expression
     *
     * @param strScalar a String object that contains a scalar expression
     */
    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    /**
     * a default constructor
     */
    Scalar() {

    }

    /**
     * an overridden method of the Object. toString() method
     *
     * @return a value of "this" scalar expression, which is to be printer when "this" object is called to be printed
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "addition"
     * @param other an instance of Var-class or its subclasses, which is to be added
     * @return a result of addition
     */
    @Override
    public Var add(Var other) {
        try {
            return this.add((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.add((Vector) other);
            } catch (ClassCastException e1) {
                try {
                    return this.add((Matrix) other);
                } catch (ClassCastException e2) {
                    return super.add(other);
                }
            }
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "addition" between two scalar expressions
     * @param other a scalar expression, which is to be added to "this" scalar expression
     * @return a result of addition, i.e. a new scalar expression
     */
    private Var add(Scalar other) {
        double sum = this.value + other.value;
        return new Scalar(sum);
    }

    /**
     * an overloaded method that performs a mathematical operation of "addition" between "this" scalar expressions
     * and its argument - a vector expression
     * @param other a vector expression, which is to be added to "this" scalar expression
     * @return a redirect to a method of a vector expression with the same nature
     */
    private Var add(Vector other) {
        return other.add(this);
    }

    /**
     * an overloaded method that performs a mathematical operation of "addition" between "this" scalar expressions
     * and its argument - a matrix expression
     * @param other a matrix expression, which is to be added to "this" scalar expression
     * @return a redirect to a method of a matrix expression with the same nature
     */
    private Var add(Matrix other) {
        return other.add(this);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "subtraction"
     * @param other an instance of Var-class or its subclasses, which is to be subtracted
     * @return a result of subtraction
     */
    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e) {
            try {
                return this.sub((Vector) other);
            } catch (ClassCastException e1) {
                try {
                    return this.sub((Matrix) other);
                } catch (ClassCastException e2) {
                    return super.sub(other);
                }
            }
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between two scalar expressions
     * @param other a scalar expression that is a deduction
     * @return a result of subtraction, i.e. a new scalar expression
     */
    private Var sub(Scalar other) {
        double rem = this.value - other.value;
        return new Scalar(rem);
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between a scalar expression and
     * a vector expression
     * @param other a vector expression that is a deduction;
     * @return a result of subtraction, i.e. a vector expression
     */
    private Var sub(Vector other) {
        return new Scalar(-1).mul(other).add(this);
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between a scalar expression and
     * a matrix expression
     * @param other a matrix expression that is a deduction
     * @return a result of subtraction, i.e. a matrix expression
     */
    private Var sub(Matrix other) {
        return new Scalar(-1).mul(other).add(this);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "multiplication"
     * @param other an instance of Var-class or its subclasses, which is a multiplier
     * @return a result of multiplication
     */
    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e) {
            try {
                return this.mul((Vector) other);
            } catch (ClassCastException e1) {
                try {
                    return this.mul((Matrix) other);
                } catch (ClassCastException e2) {
                    return super.mul(other);
                }
            }
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between two scalar expressions
     * @param other a scalar expression that is a multiplier
     * @return a result of multiplication, i.e. a new scalar expression
     */
    private Var mul(Scalar other) {
        double mul = this.value * other.value;
        return new Scalar(mul);
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between "this" scalar expression
     * and a vector expression
     * @param other a vector expression that is a multiplier
     * @return a redirect to a method of a vector expression with the same nature
     */
    private Var mul(Vector other) {
        return other.mul(this);
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between "this" scalar expression
     * and a matrix expression
     * @param other a matrix expression that is a multiplier
     * @return a redirect to a method of a matrix expression with the same nature
     */
    private Var mul(Matrix other) {
        return other.mul(this);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "division"
     * @param other an instance of Var-class or its subclasses, which is divisor
     * @return a result of division
     */
    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e) {
            return super.div(other);
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "division" between two scalar expression
     * @param other a scalar expression that is a divisor
     * @return a result of division, i.e. a new scalar expression
     */
    private Var div(Scalar other) {
        if (other.value != 0) {
            double div = this.value / other.value;
            return new Scalar(div);
        }
        return super.div(other);
    }

}
