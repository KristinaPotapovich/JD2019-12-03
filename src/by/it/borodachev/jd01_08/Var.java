package by.it.borodachev.jd01_08;

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

 }
