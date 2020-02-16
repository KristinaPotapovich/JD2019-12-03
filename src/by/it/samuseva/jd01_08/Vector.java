package by.it.samuseva.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }
    Vector(Vector vector) {
        this(vector.value);
    }
    Vector(String str) {
        str.trim();
       //  по другому не смогла удолить фигурные скобки
        String[] string = str.split("[{ ,}]+");

        if (string[0].equals(""))
            for (int i = 0; i < string.length-1; i++) {
                string[i]=string[i+1];
            }
        string = Arrays.copyOf(string,string.length-1);

        double[] array = new double[string.length];
        for (int i = 0; i < array.length; i++) {
                array[i] = Double.parseDouble(string[i]);
        }
        this.value = array;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += scalar.getValue();
            }
            return new Vector(sum);
        }
        if (other instanceof Vector) {
            double[] vector1 = Arrays.copyOf(value,value.length);
            Vector vector2 = (Vector) other;
            for (int i = 0; i < vector1.length; i++) {
                vector1[i] += vector2.value[i];
            }
            return new Vector(vector1);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] sub = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= scalar.getValue();
            }
            return new Vector(sub);
        }
        if (other instanceof Vector) {
            double[] vector1 = Arrays.copyOf(value,value.length);
            Vector vector2 = (Vector) other;
            for (int i = 0; i < vector1.length; i++) {
                vector1[i] -= vector2.value[i];
            }
            return new Vector(vector1);
        }
        else return other.sub(this);
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] mul = Arrays.copyOf(value,value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= scalar.getValue();
            }
            return new Vector(mul);
        }
        if (other instanceof Vector) {
            double[] vector1 = Arrays.copyOf(value,value.length);
            Vector vector2 = (Vector) other;
            double mul1 = 0;
            for (int i = 0; i < vector1.length; i++) {
                vector1[i] *= vector2.value[i];
                mul1 += vector1[i];
            }
            return new Scalar(mul1);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] div = Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= scalar.getValue();
            }
            return new Vector(div);
        }
        return super.div(other);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String delimiter ="";
        for (double element : value) {
            string.append(delimiter).append(element);
            delimiter = ", ";

        }
        string.append("}");
        return string.toString();
    }
}
