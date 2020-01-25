package by.it.rumiantcau.jd01_07;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        double[][] value = {{1, 2, 3}, {4, 5, 6}};


        double[][] resDiv = Arrays.copyOf(value, value.length);


        System.out.println(resDiv[1][1]);



        /*
        boolean aWhile = true;
        int rowNumber = 0;
        String resultStr;
        double[] parsSB = new double[rowNumber];


     String strMatrix = "{{1, 2, 3}, {4, 5, 6}}";
        strMatrix = strMatrix.replace("{{", "{");
        strMatrix = strMatrix.replace("}}", "}");



      //  resultStr = strMatrix.substring(strMatrix.indexOf('{') + 1, strMatrix.indexOf('}'));
      //  String[] sb1= resultStr.split(",");
       // System.out.println("sb dlinna" + sb1.length);

        //вычесляем количество рядов у матрицы
        char[] charMas = strMatrix.toCharArray();
        for (int i = 0; i < charMas.length; i++) {
            if (charMas[i] =='}') rowNumber++;
        }
        resultStr = strMatrix.substring(strMatrix.indexOf('{') + 1, strMatrix.indexOf('}'));
        String[] sb= resultStr.split(",");
        int columnNumber = sb.length;
        double[][] value = new double[rowNumber][columnNumber];

//        String[] sb= strMatrix.split(",");
//        System.out.println(sb[0]);




      while (aWhile)

        {   for (int i = 0; i < rowNumber; i++) {
             if (strMatrix.indexOf('}') == (strMatrix.length()-1)) aWhile = false;
            resultStr = strMatrix.substring(strMatrix.indexOf('{') + 1, strMatrix.indexOf('}'));
            strMatrix = strMatrix.substring(strMatrix.indexOf('}') +1 , strMatrix.length());
            System.out.println(resultStr);
            System.out.println(strMatrix);

           sb= resultStr.split(",");


            for (int j = 0; j < sb.length; j++) {
                value[i][j] =  Double.parseDouble(sb[j]);
                System.out.println("вывод тестовый валью" + value[i][j] + " ");
            }
               }
    }
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }


*/
}}

