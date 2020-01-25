package by.it.shpakovskiy.jd01_08;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];
            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                value[i] = tempArr;
            }
        }
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String s = "";
        for (double[] aValue : value) {
            for (double v : aValue) {
                stringBuilder.append(s).append(v);
                s = ", ";
            }
            stringBuilder.append("}");
            s = ", {";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        double[][] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = other.getValue() + result[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var add(Matrix other) {
        if (value.length == other.value.length && value[0].length == other.value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] + other.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar other) {
        double[][] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = other.getValue() - result[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Matrix other) {
        if (value.length == other.value.length && value[0].length == other.value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = other.value[i][j] - value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) {
        double[][] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = other.getValue() * result[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var mul(Matrix other) {
        if (value.length == other.value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < other.value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        result[i][j] = result[i][j] + other.value[i][k] * value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return other.div(this);
    }
}