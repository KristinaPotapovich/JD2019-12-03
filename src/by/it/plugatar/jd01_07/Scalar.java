package by.it.plugatar.jd01_07;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar){
        this.value=scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
        //return "Это класс Scalar";
    }
/*
    Scalar(Scalar other Scalar) {
    }
*/
/*
    public static void main(String[] args) {
        public Scalar(double value){
        }
*/
    }

