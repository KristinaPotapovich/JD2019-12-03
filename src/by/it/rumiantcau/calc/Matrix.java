package by.it.rumiantcau.calc;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;
    public double[][] getValue() {
        return value;
    }
//ОПЕРАЦИЯ УМНОЖЕНИЯ
    public Var mul(Var other) {
        //МАТРИЦА НА СКАЛЯР
        if (other instanceof Scalar){
            double[][] resMul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resMul.length; i++) {
                for (int j = 0; j < resMul[0].length; j++) {
                    resMul[i][j] = resMul[i][j] * ((Scalar)other).getValue();
                }
            }
            return new Matrix(resMul);
        }
        //МАТРИЦА НА МАТРИЦУ
        else if (other instanceof Matrix){
            double[][] resMul = Arrays.copyOf(value, value.length);
            double[][] x_mull = new double[resMul.length][((Matrix)other).value[0].length];
            for (int i = 0; i < resMul.length; i++) {
                for (int k = 0; k < ((Matrix)other).value.length; k++) {
                    for (int j = 0; j < ((Matrix)other).value[0].length; j++) {
                        x_mull[i][j] = x_mull[i][j] + resMul[i][k]*((Matrix)other).value[k][j];
                    }
                }
            }
            return new Matrix(x_mull);
        }
        //МАТРИЦА НА ВЕКТОР
        else if (other instanceof Vector){
            double[][] resMul = Arrays.copyOf(value, value.length);
            double[] x_mull = new double[resMul.length];
            double[] vectorMas = ((Vector)other).getValue();
            for (int i = 0; i < resMul.length; i++) {
            for (int j = 0; j < vectorMas.length; j++) {
            x_mull[i] = x_mull[i] + resMul[i][j]*vectorMas[j];
        }
    }
            return new Vector(x_mull);
        }
        else
            return super.mul(other);
    }
    //ОПЕРАЦИЯ СЛОЖЕНИЯ
    public Var add(Var other) {
        if (other instanceof Matrix){
            double[][] resMatrixAddMatrix = new double[value.length][value[0].length];
            double[][] otherMatrix = ((Matrix)other).value;
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    resMatrixAddMatrix[i][j] = value[i][j] + otherMatrix[i][j];;
                }
            }
            return new Matrix(resMatrixAddMatrix);
        }
        else if  (other instanceof Scalar){
            double[][] resMatrixAddScalar = new double[value.length][value[0].length];
            double otherScalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    resMatrixAddScalar[i][j] = value[i][j] + otherScalar;;
                }
            }
            return new Matrix(resMatrixAddScalar);
        }
        else return super.add(other);
    }
// ОПЕРАЦИЯ ВЫЧИТАНИЯ
    public Var sub(Var other) {
        if (other instanceof Matrix){
            //double[][] resMatrixSubMatrix = Arrays.copyOf(value, value.length);
            double[][] resMatrixSubMatrix = new double[value.length][value[0].length];
            double[][] otherMatrix = ((Matrix)other).value;
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    resMatrixSubMatrix[i][j] = value[i][j] - otherMatrix[i][j];;
                }
            }
            return new Matrix(resMatrixSubMatrix);
        }
        else if  (other instanceof Scalar){
           // double[][] resMatrixSubScalar = Arrays.copyOf(value, value.length);
            double[][] resMatrixSubScalar = new double[value.length][value[0].length];
            double otherScalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    resMatrixSubScalar[i][j] = value[i][j] - otherScalar;;
                }
            }
            return new Matrix(resMatrixSubScalar);
        }
        else return super.sub(other);
    }
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
