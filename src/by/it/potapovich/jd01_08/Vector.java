package by.it.potapovich.jd01_08;

import java.util.Arrays;

class Vector extends Var{
     private double [] value;


      Vector(double[] value) {
         this.value = value;
     }
     Vector (Vector vector) {
          this.value = vector.value;
     }
     Vector (String strVector){
          strVector = strVector.replaceAll("[{}]", "");
          String [] strVectors = strVector.split(",");
          double [] doubleVector = new double[strVectors.length];
         for (int i = 0; i < strVectors.length; i++) {
             doubleVector [i]= Double.parseDouble(strVectors[i]);
         }
          this.value = doubleVector;

         }



    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder("{");
         String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
            
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [] york = Arrays.copyOf(value,value.length);
            for (int i = 0; i < york.length; i++) {
                york[i] = york[i] * ((Scalar) other).getValue();

            }
            return new Vector(york);
        }
        else if (other instanceof Vector){
            double [] york = Arrays.copyOf(value,value.length);
            double s = 0;
            for (int i = 0; i < york.length; i++) {
                york[i] = york[i] * ((Vector) other).value[i];
                s += york [i];
            }


            return new Scalar(s);
        }
        else

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double [] div = Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();

            }
            return new Vector(div);

        }
        else if (other instanceof Vector){
            double [] div = Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Vector) other).value[i];
            }
            return super.div(other);
        }
        else

            return super.div(other);
    }
    }

