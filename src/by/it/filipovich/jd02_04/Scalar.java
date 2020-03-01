package by.it.filipovich.jd02_04;

public class Scalar extends Var {
    protected double value;

    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }
    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    public String toString(){
      return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double diff = this.value - ((Scalar) other).value;
            return new Scalar(diff);
        }
        return other.mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double prod = this.value * ((Scalar) other).value;
            return new Scalar(prod);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if(((Scalar) other).value !=0) {
                double div = this.value / ((Scalar) other).value;
                return new Scalar(div);
            }
            else throw new CalcException("The denominator is ZERO!");
        }
        return super.div(other);
    }
}
