package by.it.rumiantcau.jd01_09;

//    B разработайте для класса Var наследника Vector с тремя конструкторами:
//1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
//2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
//3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
//    Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}

import java.util.Arrays;

class Vector extends Var {

    private double[] value;
    public double[] getValue() {
        return value;
    }
    Vector(double[] value) {
        this.value = value;
    }

   /* Vector(Double valueDouble) {
        this.valueDouble = valueDouble;
    }*/


    Vector(Vector vector)
    {
        this.value = vector.value;
    }

    // вывод вещественного числа


    Vector(String strVector){
        strVector = strVector.replace("{", "");
        strVector = strVector.replace("}", "");
        String[] sb= strVector.split(",");

        this.value = new double[sb.length];
        for (int i = 0; i < sb.length; i++) {
                value [i] = Double.parseDouble(sb[i]) ;
        }
        }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);

            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar)other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);

            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector)other).value[i];

            }
            return new Vector(res);
        }

        else
            return super.add(other);
    }

    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] resSub = Arrays.copyOf(value, value.length);

            for (int i = 0; i < resSub.length; i++) {
                resSub[i] = resSub[i] - ((Scalar)other).getValue();

            }
            return new Vector(resSub);
        }
        else if (other instanceof Vector) {
            double[] resSub = Arrays.copyOf(value, value.length);

            for (int i = 0; i < resSub.length; i++) {
                resSub[i] = resSub[i] - ((Vector)other).value[i];

            }
            return new Vector(resSub);
        }

        else
           return super.sub(this);

    }


    @Override
    public Var div(Var other) {
       if (other instanceof Scalar){
            double[] resDiv = Arrays.copyOf(value, value.length);

            for (int i = 0; i < resDiv.length; i++) {
                resDiv[i] = resDiv[i] / ((Scalar)other).getValue();

            }
            return new Vector(resDiv);
        }
        else
            return super.div(this);
    }

    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] resMul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resMul.length; i++) {
               resMul[i] = resMul[i] * ((Scalar)other).getValue();
            }
            return new Vector(resMul);
        }
        else if (other instanceof Vector) {
            double resDouble = 0;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
               // resMul[0] = resMul[0] + res[i] * ((Vector)other).value[i];
                resDouble = resDouble + res[i] * ((Vector)other).value[i];
            }
            return new Scalar(resDouble);
        }
        else
            return super.mul(this);
    }


    public String toString() {
            StringBuilder sb = new StringBuilder("{");
            String delimiter = "";
            for (double v : value) {
                sb.append(delimiter).append(v);
                delimiter = ", ";
            }
            sb.append("}");
            return sb.toString();
    }





    }




