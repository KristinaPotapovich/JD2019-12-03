package by.it.samuseva.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
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
        str.trim();
        Pattern p = Pattern.compile("[1-9,]+");
        Matcher m = p.matcher(str);
        double[][] array = new double[3][3];
        int i = 0;
        while (m.find()){
            String string = m.group();
            if (!string.equals(",")) {
                String[] string1 = string.split("[, ]");
                for (int j = 0; j < array[0].length; j++) {
                     array[i][j] = Double.parseDouble(string1[j]);
                }
                i++;
            }
        }
        this.value = array;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String delimiter = "";

        for (int i = 0; i < value.length; i++) {
            string.append("{");
            delimiter = "";
            for (int j = 0; j < value[0].length; j++) {
                string.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i<value.length-1) string.append("}, ");
            if (i==value.length-1) string.append("}");
        }
        string.append("}");
        return string.toString();

    }

}
