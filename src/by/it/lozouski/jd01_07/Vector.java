package by.it.lozouski.jd01_07;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector(String strVector) {
        String[] temp = strVector.replaceAll("[{}]", "").split(",");
        this.value = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            value[i] = Double.parseDouble(temp[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (double elem : value) {
            sb1.append(joiner).append(elem);
            joiner = ", ";
        }
        sb1.append("}");
        return sb1.toString();
    }
}
