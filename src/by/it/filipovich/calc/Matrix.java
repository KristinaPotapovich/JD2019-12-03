package by.it.filipovich.calc;

public class Matrix extends Var {

    protected double[][] value;

    public Matrix(double[][] value){
    this.value = new double[value.length][value[0].length];

    for (int i = 0; i < value.length; i++) {
        System.arraycopy(value[i], 0, this.value[i], 0, value[0].length);
    }
    }

    public Matrix(Matrix matrix){
        this(matrix.value);
    }

    public Matrix(String strMatrix){
        String[] a = strMatrix.split("},");
        String b = a[0].replaceAll("\\D","").trim();

        double[][] arr = new double[a.length][b.length()];
        for (int i = 0; i < a.length; i++) {
            String[] mas = a[i].replaceAll("\\D"," ")
                                .replaceAll(" {2,}", " ")
                                .trim()
                                .split(" ");
            for (int j = 0; j < b.length(); j++) {
                arr[i][j] = Double.parseDouble(mas[j]);
            }
        }
        this.value = new double[arr.length][arr[0].length];
        System.arraycopy(arr, 0, this.value, 0, arr.length);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if(j != value[0].length-1)
                    sb.append(", ");
            }
            sb.append("}");
            if(i != value.length-1)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j]+((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        if(other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length &&
                    this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] sum = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sum.length; i++) {
                    for (int j = 0; j < sum[0].length; j++) {
                        sum[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(sum);
        }
        if(other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length &&
                    this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] sum = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < sum.length; i++) {
                    for (int j = 0; j < sum[0].length; j++) {
                        sum[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] = this.value[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(mul);
        }
        if(other instanceof Vector){
            if (this.value[0].length == ((Vector) other).value.length) {
                double[] mul = new double[this.value[0].length];
                for (int i = 0; i < mul.length; i++) {
                    for (int j = 0; j < mul.length; j++) {
                        mul[i] = mul[i]+this.value[i][j] * ((Vector) other).value[j];
                    }
                }
                return new Vector(mul);
            }
        }
        if(other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value[0].length &&
                    this.value[0].length == ((Matrix) other).value.length) {
                double[][] mul = new double[this.value.length][((Matrix)other).value[0].length];
                //int i1 = 0;
                for (int i = 0; i < mul.length; i++) {
                    for (int j1 = 0; j1 < mul[0].length; j1++) {
                        for (int j = 0; j < mul[0].length; j++) {
                            mul[i][j1] = mul[i][j1] + this.value[i][j] * ((Matrix) other).value[j][j1];
                        }
                    }
                }
                return new Matrix(mul);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            if(((Scalar) other).value !=  0) {
                double[][] div = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < div.length; i++) {
                    for (int j = 0; j < div[0].length; j++) {
                        div[i][j] = this.value[i][j] * ((Scalar) other).value;
                    }
                }
                return new Matrix(div);
            }
        }
        return super.div(other);
    }
}
