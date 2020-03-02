package by.it.filipovich.jd02_04;

public class Vector extends Var {

    protected double[] value;

    public Vector(double[] value){
       this.value = new double[value.length];
       System.arraycopy(value, 0, this.value, 0,value.length);
    }

    public Vector(Vector vector){
        this(vector.value);
    }

    public Vector(String strVector){
            String[] a = strVector.replaceAll(" +", "")
                                    .replaceAll("}","")
                                    .replaceAll("\\{","")
                                    .replaceAll(","," ")
                                    .split(" ");

            double[] arr = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = Double.parseDouble(a[i]);
            }
            this.value = new double[arr.length];
            System.arraycopy(arr, 0, this.value, 0, arr.length);

        //}
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i<value.length; i++) {
            sb.append(value[i]);
            if(i != value.length-1)
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
            double[] sum = new double[this.value.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i] + ((Vector) other).value[i];
            }
                return new Vector(sum);
            }
        }
        if(other instanceof Scalar) {
            double[] sum = new double[this.value.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = this.value[i]+((Scalar) other).value;
            }
            return new Vector(sum);
        }
        return super.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] diff = new double[this.value.length];
                for (int i = 0; i < diff.length; i++) {
                    diff[i] = this.value[i] - ((Vector) other).value[i];
                }
                return new Vector(diff);
            }
        }
        if(other instanceof Scalar) {
            double[] diff = new double[this.value.length];
            for (int i = 0; i < diff.length; i++) {
                diff[i] = this.value[i]-((Scalar) other).value;
            }
            return new Vector(diff);
        }
        return super.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double diff = 0;
                for (int i = 0; i < this.value.length; i++) {
                    diff = diff+this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(diff);
            }
        }
        if(other instanceof Scalar) {
            double[] diff = new double[this.value.length];
            for (int i = 0; i < diff.length; i++) {
                diff[i] = this.value[i]*((Scalar) other).value;
            }
            return new Vector(diff);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Vector) {
            return super.div(other);
        }
        if(other instanceof Scalar) {
            if(((Scalar) other).value != 0) {
                double[] div = new double[this.value.length];
                for (int i = 0; i < div.length; i++) {
                    div[i] = this.value[i] / ((Scalar) other).value;
                }
                return new Vector(div);
            }
        }
        return super.div(other);
    }
}
