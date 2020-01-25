package by.it.shpakovskiy.jd01_09;

import java.util.Arrays;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        return new Scalar(this.value + other.value);
    }

    @Override
    public Var add(Vector other) {
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar other) {
        return new Scalar(other.value - this.value);
    }

    @Override
    public Var sub(Vector other) {
        double[] op1 = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < op1.length; i++) {
            op1[i] = op1[i] - value;
        }
        return new Vector(op1);
    }

    @Override
    public Var sub(Matrix other) {
        double[][] op1 = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < op1.length; i++) {
            op1[i] = Arrays.copyOf(other.getValue()[i], other.getValue()[i].length);
        }
        for (int i = 0; i < op1.length; i++) {
            for (int j = 0; j < op1[i].length; j++) {
                op1[i][j] = op1[i][j] - value;
            }

        }
        return new Matrix(op1);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) {
        return new Scalar(this.value * other.value);
    }

    @Override
    public Var mul(Vector other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix other) {
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) {
        if (this.value != 0) {
            return new Scalar(other.value / this.value);
        }
        return super.div(other);
    }

    @Override
    public Var div(Vector other) {
        if (value != 0) {
            double[] op1 = Arrays.copyOf(other.getValue(), other.getValue().length);
            for (int i = 0; i < op1.length; i++) {
                op1[i] = op1[i] / value;
            }
            return new Vector(op1);
        }
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) {
        if (value!=0){
            double[][] op1 = Arrays.copyOf(other.getValue(), other.getValue().length);
            for (int i = 0; i < op1.length; i++) {
                op1[i] = Arrays.copyOf(other.getValue()[i], other.getValue()[i].length);
            }
            for (int i = 0; i < op1.length; i++) {
                for (int j = 0; j < op1[i].length; j++) {
                    op1[i][j] = op1[i][j]/value;
                }

            }
            return new Matrix(op1);
        }
        return super.div(other);
    }
}