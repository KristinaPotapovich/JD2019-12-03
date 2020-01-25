package by.it.lozouski.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector(String strVector) {
        String[] temp = strVector.replaceAll("[{}]", "").split(",");
        this.value = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            value[i] = Double.parseDouble(temp[i]);
        }
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    Var add(Scalar otherScalar) {
        double[] sum = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            sum[i] = this.value[i] + otherScalar.getValue();
        }
        return new Vector(sum);
    }

    @Override
    Var add(Vector otherVector) {
        double[] sum = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            sum[i] = this.value[i] + otherVector.value[i];
        }
        return new Vector(sum);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    Var sub(Scalar otherScalar) {
        double[] sub = Arrays.copyOf(value, value.length);
        for (int i = 0; i < sub.length; i++) {
            sub[i] = sub[i] - otherScalar.getValue();
        }
        return new Vector(sub);
    }

    @Override
    Var sub(Vector otherVector) {
        return otherVector.add(this.mul(new Scalar(-1)));
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    Var mul(Scalar otherScalar) {
        double[] mul = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            mul[i] = this.value[i] * otherScalar.getValue();
        }
        return new Vector(mul);
    }

    @Override
    Var mul(Vector otherVector) {
        double scalarMultipleVectors = 0;
        for (int i = 0; i < this.value.length; i++) {
            scalarMultipleVectors = scalarMultipleVectors + this.value[i] * otherVector.value[i];
        }
        return new Scalar(scalarMultipleVectors);
    }

    @Override
    Var mul(Matrix otherMatrix) {
        double[] mul = new double[otherMatrix.getValue().length];
        for (int i = 0; i < otherMatrix.getValue().length; i++) {
            for (int j = 0; j < otherMatrix.getValue()[0].length; j++) {
                mul[i] = mul[i] + otherMatrix.getValue()[i][j] * this.value[j];
            }
        }
        return new Vector(mul);
    }

    @Override
    public Var div(Var other) {
        return other.div(this);
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (double elem : value) {
            sb1.append(joiner).append(elem);
            joiner = ", ";
        }
        sb1.append("}");
        return sb1.toString();
    }
}
