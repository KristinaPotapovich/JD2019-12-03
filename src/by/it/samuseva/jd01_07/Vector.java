package by.it.samuseva.jd01_07;

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
