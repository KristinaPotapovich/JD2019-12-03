package by.it.shpakovskiy.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{|}]", "");
        String[] stringValue = strVector.split(",");
        value = new double[stringValue.length];
        for (int i = 0; i < stringValue.length; i++) {
            value[i] = Double.parseDouble(stringValue[i].trim());
        }
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
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
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector other) {
        if (this.value.length == other.value.length) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += other.value[i];
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = other.getValue() - result[i];
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Vector other) {
        if (this.value.length == other.value.length) {
            double[] result = Arrays.copyOf(other.value, other.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] *= other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var mul(Vector other) {
        if (this.value.length == other.value.length) {
            double result = 0;
            for (int i = 0; i < value.length; i++) {
                result += value[i] * other.value[i];
            }
            return new Scalar(result);
        }
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix other) {
        if (other.getValue()[0].length == value.length) {
            double[] result = new double[value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < other.getValue()[i].length; j++) {
                    result[i] += value[j] * other.getValue()[i][j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return other.div(this);
    }
}