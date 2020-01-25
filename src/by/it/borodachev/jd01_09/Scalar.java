package by.it.borodachev.jd01_09;

public class Scalar extends Var {
     private double value;
     public double getValue() {return this.value;}
     public Scalar(double var) {
          this.value=var;
     }
     public Scalar(Scalar Sc)
     {this.value = Sc.getValue();}
    public Scalar(String var)  {
        this.value= new Double(var);
    }
    @Override
    public String toString() {
      return Double.toString(this.value);
    }

    @Override
    public Var add(Var newValue) throws Exception {

        if (newValue instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) newValue).value);
        }
        return newValue.add(this);
    }

    @Override
    public Var sub(Var newValue) throws Exception {
        if (newValue instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) newValue).value);
        }
        return new Scalar(-1).mul(newValue.sub(this));

    }

    @Override
    public Var mul(Var newValue)  throws Exception {
        if (newValue instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) newValue).value);
        }
        return newValue.mul(this);
    }

    @Override
    public Var div(Var newValue)  throws Exception {
        if (newValue instanceof Scalar) {
            //Деление на 0 запрещено
            if (((Scalar) newValue).value==0) {
                System.out.println("Omg!! Division by zero");
            }
            return new Scalar(this.value / ((Scalar) newValue).value);
        }
        return newValue.mul(new Scalar(1.0).div(this));
    }
}
