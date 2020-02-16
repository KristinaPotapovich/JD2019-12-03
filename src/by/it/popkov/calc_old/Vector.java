package by.it.popkov.calc_old;


class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        strVector = strVector.replaceAll(",", " ");
        String[] doubNums = strVector.split(" ");
        value = new double[doubNums.length];
        for (int i = 0; i < doubNums.length; i++) {
            value[i] = Double.parseDouble(doubNums[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder toStr = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i != value.length - 1) {
                toStr.append(value[i]).append(", ");
            } else {
                toStr.append(value[i]).append("}");
            }
        }
        return toStr.toString();
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            if (((Vector) other).value.length != this.value.length) throw new CalcException("Разная длина векторов");
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(out);
        } else if (other instanceof Scalar) {
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(out);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            if (((Vector) other).value.length != this.value.length) throw new CalcException("Разная длина векторов");
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(out);
        } else if (other instanceof Scalar) {
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(out);
        }
        return super.mul(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(out);
        } else if (other instanceof Vector) {
            if (((Vector) other).value.length != this.value.length) throw new CalcException("Разная длина векторов");
            double out = 0;
            for (int i = 0; i < this.value.length; i++) {
                out += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(out);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                throw new CalcException("Деление на 0");
            }
            double[] out = new double[this.value.length];
            for (int i = 0; i < out.length; i++) {
                out[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(out);
        }
        return super.div(other);
    }
}
