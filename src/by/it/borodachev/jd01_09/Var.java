package by.it.borodachev.jd01_09;

public abstract class Var implements Operation {
     @Override
     public String toString() {
          return "Var{}";
     }

     @Override
     public Var add(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var sub(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var mul(Var newValue) throws Exception {
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }

     @Override
     public Var div(Var newValue) throws Exception{
          System.out.println("Operation " + this + "+" + newValue + " impossible");
          return null;
     }
     static Var createVar(String strVar) throws Exception {
          if (strVar.matches(Patterns.SCALAR))
               return new Scalar(strVar);
          else if (strVar.matches(Patterns.VECTOR))
               return new Vector(strVar);
          else if (strVar.matches(Patterns.MATRIX))
               return new Matrix(strVar);
          else
               return null; //TODO generate error here
     }
}
