package by.it.plugatar.jd01_07;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] array) {
        this.value = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++)
            System.arraycopy(array[i], 0, this.value[i], 0, array[i].length);
    }

    Matrix(Matrix mat) {
        this.value = new double[mat.value.length][mat.value[0].length];
        for (int i = 0; i < mat.value.length; i++)
            System.arraycopy(mat.value[i], 0, this.value[i], 0, mat.value[i].length);
    }

    Matrix(String s) {
//Убираем .0 и делимм строку на  массивы
        s = s.replace(".0", "");
        Pattern pt = Pattern.compile("[{][0-9., ]+[}]");
        Matcher m1 = pt.matcher(s);
        ArrayList<String> list = new ArrayList<>();
        while (m1.find()) list.add(m1.group());

        //выясняем кол-во членов в массивах и размер матрицы this
        String[] buf = list.get(0).split(",");
        this.value = new double[list.size()][buf.length];

        //убираем лишние символы из  массивов и переносим данные в матрицу this
        for (int i = 0; i < list.size(); i++) {
            String buff = list.get(i).replace("{","");
            buff = buff.replace("}","");
            String[] str = buff.split(",");
            for (int i1 = 0; i1 < str.length; i1++) {
                str[i1] = str[i1].trim();
            }
            for (int j = 0; j<str.length;j++){
                this.value[i][j] = Double.parseDouble(str[j]);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder def = new StringBuilder(", ");
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{").append(this.value[i][0]);
            for (int j = 1; j < this.value[i].length; j++)
                sb.append(def).append(this.value[i][j]);
            sb.append("}");
            if (i < this.value.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}