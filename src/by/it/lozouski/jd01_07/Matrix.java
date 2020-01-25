package by.it.lozouski.jd01_07;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][];
        System.arraycopy(matrix.value, 0, this.value, 0, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String temp1 = strMatrix.replaceAll("[\\s]|[{}]{2,}", "");
        String[] temp2 = temp1.replaceAll("[},{]{2,}", "}").replaceAll(",", " ").split("}");
        String[][] tempMatrix = new String[temp2.length][];
        for (int i = 0; i < temp2.length; i++) {
            tempMatrix[i] = temp2[i].split(" ");
        }

        this.value = new double[temp2.length][];
        for (int i = 0; i < value.length; i++) {
            value[i] = new double[tempMatrix[i].length];
            for (int j = 0; j < tempMatrix[i].length; j++) {
                value[i][j] = Double.parseDouble(tempMatrix[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (int i = 0; i < value.length; i++) {
            sb1.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb1.append(joiner).append(value[i][j]);
                joiner = ", ";
            }
            if (i != value.length - 1) sb1.append("}, ");
            else sb1.append("}");
            joiner = "";
        }
        sb1.append("}");
        return sb1.toString();
    }
}
