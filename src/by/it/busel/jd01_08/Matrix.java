package by.it.busel.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a matrix expression
 */
class Matrix extends Var {
    /**
     * a value of "this" matrix expression
     */
    private double[][] value;

    /**
     * a constructor, which argument sets a value of "this" matrix expression
     *
     * @param value a value of "this" matrix expression
     */
    Matrix(double[][] value) {
        this.value = value;
    }

    /**
     * a constructor, which argument is another vector expression the value of which is to be assigned as a value of
     * "this" matrix expression
     *
     * @param matrix another matrix expression the value of which is to be assigned as a value of
     *               "this" matrix expression
     */
    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    /**
     * a constructor that takes a String object, parses it into a value of "this" matrix expression
     * @param strMatrix a String object that contains a matrix expression
     */
    Matrix(String strMatrix) {
        Pattern patternToRows = Pattern.compile("[{][0-9, ]+[}]");
        Matcher matcherToRows = patternToRows.matcher(strMatrix);
        int numberOfRows = counterOfElementsOfAnArray(matcherToRows);
        String[] strArrayRows = concstructorArrayRows(matcherToRows, numberOfRows);

        Pattern patternRowsToElements = Pattern.compile("[0-9]+");
        Matcher matcher = patternRowsToElements.matcher(strArrayRows[0]);
        int numberOfColumns = counterOfElementsOfAnArray(matcher);
        if (numberOfRows > 0 && numberOfColumns > 0) {
            value = new double[numberOfRows][numberOfColumns];
            valueFiller(strArrayRows, matcher);
        }
    }

    /**
     * an overridden method of the Object. toString() method
     * @return a value of "this" matrix expression, which is to be printer when "this" object is called to be printed
     */
    @Override
    public String toString() {
        String separator = ", ";
        StringBuilder strToString = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            strToString.append("{");
            for (int j = 0; j < value[0].length; j++) {
                strToString.append(value[i][j]);
                if (j != value[0].length - 1) {
                    strToString.append(separator);
                }
            }
            strToString.append("}");
            if (i != value.length - 1) {
                strToString.append(separator);
            }
        }
        strToString.append("}");
        return strToString.toString();
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "addition"
     *
     * @param other an instance of Var-class or its subclasses, which is to be added
     * @return a result of addition
     */

    @Override
    public Var add(Var other) {
        try {
            return this.add((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.add((Matrix) other);
            } catch (ClassCastException e1) {
                return super.add(other);
            }
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "addition" between "this" matrix expression and
     * a scalar expression
     *
     * @param other a scalar expression, which is to be added to "this" matrix expression
     * @return a result of addition, i.e. a new matrix expression
     */
    private Var add(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] + filler;
            }
        }
        return new Matrix(result);
    }

    /**
     * an overloaded method that performs a mathematical operation of "addition" between two matrix expression
     *
     * @param other a matrix expression, which is to be added to "this" matrix expression
     * @return a result of addition, i.e. a new matrix expression
     */
    private Var add(Matrix other) {
        if (this.value.length == other.value.length &&
                this.value[0].length == other.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + other.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "subtraction"
     *
     * @param other an instance of Var-class or its subclasses, which is to be subtracted
     * @return a result of subtraction
     */
    @Override
    public Var sub(Var other) {
        try {
            return this.sub((Scalar) other);
        } catch (ClassCastException e0) {
            try {
                return this.sub((Matrix) other);
            } catch (ClassCastException e1) {
                return super.sub(other);
            }
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between "this" matrix expression
     * and a scalar expression
     *
     * @param other a scalar expression that is a deduction
     * @return a result of subtraction, i.e. a new matrix expression
     */
    private Var sub(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] - filler;
            }
        }
        return new Matrix(result);
    }

    /**
     * an overloaded method that performs a mathematical operation of "subtraction" between two matrix expressions
     *
     * @param other a matrix expression that is a deduction
     * @return a result of subtraction, i.e. a new matrix expression
     */
    private Var sub(Matrix other) {
        if (this.value.length == other.value.length &&
                this.value[0].length == other.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - other.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "multiplication"
     *
     * @param other an instance of Var-class or its subclasses, which is a multiplier
     * @return a result of multiplication
     */
    @Override
    public Var mul(Var other) {
        try {
            return this.mul((Scalar) other);
        } catch (ClassCastException e0) {
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
     * an overloaded method that performs a mathematical operation of "multiplication" between "this" matrix expression
     * and a scalar expression
     *
     * @param other a scalar expression that is a multiplier
     * @return a result of multiplication, i.e. a new matrix expression
     */
    private Var mul(Scalar other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        double filler = other.getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.value[i][j] * filler;
            }
        }
        return new Matrix(result);
    }

    /**
     * an overloaded method that performs a mathematical operation of "multiplication" between "this" matrix expression
     * and a vector expression
     *
     * @param other a vector expression that is a multiplier
     * @return a result of multiplication, i.e. a new vector expression
     */
    private Var mul(Vector other) {
        double[] vector = other.getValue();
        if (this.value[0].length == vector.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i] = result[i] + this.value[i][j] * vector[j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    /**
     * an overloaded method that performs a mathematical operation of "multiplication" between two matrix expressions
     *
     * @param other a matrix expression that is a multiplier
     * @return a result of multiplication, i.e. a new matrix expression
     */
    private Var mul(Matrix other) {
        if (this.value[0].length == other.value.length) {
            double[][] result = new double[this.value.length][other.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < this.value[0].length; k++) {
                        result[i][j] = result[i][j] + this.value[i][k] * other.value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    /**
     * an overridden from a base class "Var" method that determines a type of a class from its argument
     * and depending on the type performs a mathematical operation of "division"
     *
     * @param other an instance of Var-class or its subclasses, which is divisor
     * @return a result of division
     */
    @Override
    public Var div(Var other) {
        try {
            return this.div((Scalar) other);
        } catch (ClassCastException e0) {
            return super.div(other);
        }
    }

    /**
     * an overloaded method that performs a mathematical operation of "division" between "this" vector expression
     * and a scalar expression
     * @param other a scalar expression that is a divisor
     * @return a result of division, i.e. a new matrix expression
     */
    private Var div(Scalar other) {
        double filler = other.getValue();
        if (filler != 0) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] / filler;
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    /**
     * a method that composes a String array, each element of which is a row of a matrix expression
     * @param matcherToRows a matcher that find rows of a matrix
     * @param numberOfRows a number of rows
     * @return a String array, each element of which is a row of a matrix expression
     */
    private String[] concstructorArrayRows(Matcher matcherToRows, int numberOfRows) {
        String[] sb = new String[numberOfRows];
        int index = 0;
        while (matcherToRows.find()) {
            sb[index++] = matcherToRows.group();
        }
        matcherToRows.reset();
        return sb;
    }

    /**
     * a method that counts a number of rows of "this" matrix expression
     * @param matcher a matcher, which finds a rows of "this" matrix expression
     * @return a number of rows of "this" matrix expression
     */
    private int counterOfElementsOfAnArray(Matcher matcher) {
        if (!matcher.find()) {
            return 0;
        }
        matcher.reset();
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        matcher.reset();

        return counter;
    }

    /**
     * a method that fills a value of "this" matrix expression
     * @param strArrayRows a String array, each element of which is a row of "this" matrix expression
     * @param matcher a matcher, which finds a separate element of "this" matrix expression
     */
    private void valueFiller(String[] strArrayRows, Matcher matcher) {
        for (int i = 0; i < strArrayRows.length; i++) {
            matcher.reset(strArrayRows[i]);
            int indexInsideRow = 0;
            while (matcher.find()) {
                value[i][indexInsideRow++] = Double.parseDouble(matcher.group());
            }
        }
    }
}
