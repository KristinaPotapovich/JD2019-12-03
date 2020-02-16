package by.it.shulga.jd01.jd01_08;

import java.util.Arrays;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
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
    public Var div(Var other) {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) {
        if (this.value != 0) {
            return new Scalar(other.value / this.value);
        }
        System.out.println("Division by zero");
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
        System.out.println("Division by zero");
        return super.div(other);
    }


}
