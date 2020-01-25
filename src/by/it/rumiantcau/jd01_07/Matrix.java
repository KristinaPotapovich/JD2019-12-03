package by.it.rumiantcau.jd01_07;

    class Matrix extends Var {
    private double[][] value;

    Matrix(double[ ][ ] value){
        this.value = value;
    }
    Matrix(Matrix matrix){
        this.value = matrix.value;
    }


   Matrix(String strMatrix){
            int rowNumber = 0;

            String resultStr;
            strMatrix = strMatrix.replace("{{", "{");
            strMatrix = strMatrix.replace("}}", "}");
            //вычесляем количество рядов и столбцов у матрицы
            char[] charMas = strMatrix.toCharArray();
            for (int i = 0; i < charMas.length; i++) {
                if (charMas[i] =='}') rowNumber++;
            }
            resultStr = strMatrix.substring(strMatrix.indexOf('{') + 1, strMatrix.indexOf('}'));
            String[] sb= resultStr.split(",");
            int columnNumber = sb.length;
            this.value = new double[rowNumber][columnNumber];

               for (int i = 0; i < rowNumber; i++) {
                resultStr = strMatrix.substring(strMatrix.indexOf('{') + 1, strMatrix.indexOf('}'));
                strMatrix = strMatrix.substring(strMatrix.indexOf('}') +1 , strMatrix.length());
                sb= resultStr.split(",");

                    for (int j = 0; j < sb.length; j++) {
                        value[i][j] =  Double.parseDouble(sb[j]);
                    }
                }

        }



    public String toString() {
        StringBuilder sb=new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            String delimiter="";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            if (i<value.length-1) sb.append("}, {");
        }
        sb.append("}}");

        return sb.toString();
        }






}
