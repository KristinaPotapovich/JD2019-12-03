package by.it.barkovsky.jd01_07;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, this.value[i], 0, matrix.value[i].length);
        }
    }

    Matrix(String strMatrix) {
        String[] matrixLineStr = strMatrix.trim().substring(1, strMatrix.length() - 1).split("\\},\\{");
        this.value = new double[matrixLineStr.length][matrixLineStr[0].trim().substring(1, matrixLineStr[0].length()).split(",").length];
        for (int i = 0; i < matrixLineStr.length; i++) {
            String[] line = matrixLineStr[i].trim().split(",");
            for (int j = 0; j < line.length; j++) {
                if (line[j].length() > 0) {
                    if (line[j].indexOf("}") > 0) {
                        this.value[i][j] = Double.parseDouble(line[j].substring(0, line[j].indexOf("}")));
                    } else if (line[j].contains("{")) {
                        this.value[i][j] = Double.parseDouble(line[j].substring(1));
                    } else this.value[i][j] = Double.parseDouble(line[j]);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (int i = 0; i < value.length; i++) {
            res.append("{");
            String delimiter = "";
            for (double element : value[i]) {
                res.append(delimiter).append(element);
                delimiter = ", ";
            }
            res.append("}");
            if (i + 1 < value.length) res.append(",");
        }
        res.append("}");
        return res.toString();
    }
}