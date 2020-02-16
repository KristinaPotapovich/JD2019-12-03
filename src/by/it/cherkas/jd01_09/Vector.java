package by.it.cherkas.jd01_09;

import java.util.Arrays;

class Vector extends Var {

        private double[] value;



         Vector(double[] value) {
                this.value = new double[value.length];
                System.arraycopy(value, 0, this.value,0,this.value.length);

        }
        Vector(Vector vector){
                 this(vector.value);
        }

        Vector(String strVector){
                 strVector=strVector.replaceAll("[{|}]","");
                 String[] stringValue=strVector.split(",");
                 value=new double[stringValue.length];
            for (int i = 0; i <stringValue.length ; i++) {
                value[i]=Double.parseDouble(stringValue[i].trim());
                
            }
                }
                public double[] getValue(){
             return value;

        }
        public void setValue(double[] value){
             this.value=value;
        }


        @Override
        public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        String delimiter="";
                for (double element:value ) {
                sb.append(delimiter);
                sb.append(element);
                delimiter=", ";
                }
                sb.append("}");
                return sb.toString();
        }

    @Override
    public Var add(Var other) {
             if (other instanceof Scalar){
                 double[] result=Arrays.copyOf(value,value.length);
                 for (int i = 0; i <result.length ; i++) {
                     result[i]=result[i]+((Scalar)other).getValue();
                 }
            return new Vector(result);
    }
             else  if (other instanceof Vector){
                 double[] result=Arrays.copyOf(value, value.length);
                 for (int i = 0; i <result.length ; i++) {
                     result[i]=result[i]+((Vector)other).value[i];
                 }
                 return new Vector(result);
             }
             else return super.add(other);
}
    @Override
    public Var sub(Var other){
             if (other instanceof Scalar){
                 double[] result=Arrays.copyOf(value,value.length);
                 for (int i = 0; i <result.length ; i++) {
                     result[i]=result[i]-((Scalar)other).getValue();
                 }
                 return new Vector(result);
             }
             else  if (other instanceof Vector){
                 double[] result=Arrays.copyOf(value, value.length);
                 for (int i = 0; i <result.length ; i++) {
                     result[i]=result[i]-((Vector)other).value[i];
                 }
                 return new Vector(result);
             }
             else return super.sub(other);
         }

    @Override
    public Var mul(Var other){
        if (other instanceof Scalar){
            double[] mul=Arrays.copyOf(value,value.length);
            for (int i = 0; i <mul.length ; i++) {
                mul[i]=mul[i]*((Scalar)other).getValue();
            }
            return new Vector(mul);
        }
        else  if (other instanceof Vector){
            double[] mul=Arrays.copyOf(value, value.length);
            double s=0;
            for (int i = 0; i <mul.length ; i++) {
                mul[i]=mul[i]*((Vector)other).value[i];
                s+=mul[i];
            }
            return new Scalar(s);
        }
        else return super.mul(other);
    }
    @Override
    public Var div(Var other){
        if (other instanceof Scalar){
            double[] result=Arrays.copyOf(value,value.length);
            for (int i = 0; i <result.length ; i++) {
                result[i]=result[i]/((Scalar)other).getValue();
            }
            return new Vector(result);
        }
        else  if (other instanceof Vector){
            double[] result=Arrays.copyOf(value, value.length);
            for (int i = 0; i <result.length ; i++) {
                result[i]=result[i]/((Vector)other).value[i];
            }
            return super.div(other);
        }
        else return super.div(other);
    }
    }






