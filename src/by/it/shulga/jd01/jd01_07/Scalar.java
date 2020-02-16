package by.it.shulga.jd01.jd01_07;

 class Scalar extends Var {

     private double value;
     Scalar(double value) {
         this.value=value;
     }

     Scalar(Scalar scalar) {
         this.value=scalar.value;
     }

     public Scalar(String strScalar) {
         this.value = Double.parseDouble(strScalar);
     }



     @Override
     public String toString() {
         return Double.toString(this.value);
     }
 }
