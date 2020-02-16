package by.it.samuseva.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class  Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                this.value[i][j] = value[i][j];
            }
        }
    }
    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String str) {
        Pattern p = Pattern.compile("\\{([1-9, ]+)}");
        Matcher m = p.matcher(str);
        double[][] array = new double[2][2];
        int i = 0;
        while (m.find()){
            String string = m.group();
            String str1 = string.replaceAll("[{}]", " ").trim();
            String[] string1 = str1.split("[ ,]+");
            for (int j = 0; j < string1.length; j++) {
                array[i][j] = Double.parseDouble(string1[j]);

            }
            i++;
        }
        this.value = array;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = array[i][j] + scalar.getValue();
                }
            }
            return new Matrix(array);
        }
        if (other instanceof Matrix) {
            double[][] array1 = new double[value.length][value.length];
            Matrix matrix = (Matrix) other;
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1.length; j++) {
                    array1[i][j] = value[i][j] + matrix.value[i][j];
                }
            }
            return new Matrix(array1);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = array[i][j] - scalar.getValue();
                }
            }
            return new Matrix(array);
        }
        if (other instanceof Matrix) {
            double[][] array1 = new double[value.length][value.length];
            Matrix matrix = (Matrix) other;
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1.length; j++) {
                    array1[i][j] = value[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(array1);
        }

        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
          //  double[][] array = new double[value.length][value.length];
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = this.value[i][j] * scalar.getValue();
                }
            }
            return new Matrix(array);
        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[][] array = new double[this.value.length][this.value[0].length];
            double[] mul = new double[array.length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = this.value[i][j] * vector.getValue()[j];
                    mul[i] += array[i][j];
                }
            }
            return new Vector(mul);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] array = Arrays.copyOf(value, value.length);
            double[][] mul = new double[matrix.value.length][array[0].length];
            for (int i = 0; i < matrix.value.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    for (int k = 0; k < matrix.value[0].length; k++) {
                        mul[i][j] += array[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar scalar = (Scalar) other;
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = array[i][j] / scalar.getValue();
                }
            }
            return new Matrix(array);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String delimiter = "";

        for (int i = 0; i < this.value.length; i++) {
            string.append("{");
            delimiter = "";
            for (int j = 0; j < this.value[0].length; j++) {
                string.append(delimiter).append(this.value[i][j]);
                delimiter = ", ";
            }
            if (i<this.value.length-1) string.append("}, ");
            if (i==this.value.length-1) string.append("}");
        }
        string.append("}");
        return string.toString();

    }

}
