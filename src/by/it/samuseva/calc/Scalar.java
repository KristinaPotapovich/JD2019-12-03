package by.it.samuseva.calc;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }
    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

//////////   methods for add operation
    @Override
    public Var add(Var right) throws CalcException{
       /* if (other instanceof Scalar){
           double sum = this.value + ((Scalar) other).value;
           return new Scalar(sum);
        }
        else*/ return right.add(this);
    }

    @Override
    public Var add(Scalar left) {
        double sum = this.value + ((Scalar) left).value;
        return new Scalar(sum);

    }

    @Override
    public Var add(Vector left) throws CalcException{
        return left.add(this);
    }

    @Override
    public Var add(Matrix left) throws CalcException{
        return left.add(this);
    }

//////////   methods for sub operation
    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else return other.sub(this);
    }
//////////   methods for mul operation
    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }


//////////   methods for div operation
    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar){
            if (((Scalar) other).value==0) throw new CalcException("Делить на ноль нельзя!");
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
