package by.it.borodachev.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
     private double [] value;
      private int valueLength;
      public int length() { return valueLength;}
      public double getValue(int i) throws VectorException {
        if (i<0) throw new VectorException("Неверный индекс");
        if (i>=value.length) throw new VectorException("Неверный индекс");
        return this.value [i];
    }
    public Vector (double... args) throws VectorException {
        if (args.length == 0) throw new VectorException("Длина массива =0");
        valueLength=args.length;
        value=new double [valueLength];
        for (int i = 0; (i < valueLength); i++) {
          value[i]=args[i];
        }
    }
    public Vector (Vector vc) throws VectorException {
        if (vc.length() == 0) throw new VectorException("Длина массива =0");
        valueLength=vc.length();
        value=new double [valueLength];
        for (int i = 0; (i < valueLength); i++) {
            value[i]=vc.getValue(i);
        }
    }
    public Vector (String str) throws VectorException {
          str=str.trim();
        String[] valStr;
        Pattern pat= Pattern.compile("[^{}][0-9,/.]+");
        Matcher m=pat.matcher(str);
        if (m.find()) {
            valStr = m.group().split(",");}
           else {
               throw new VectorException("Длина массива =0");
           }
        if (valStr.length == 0) throw new VectorException("Длина массива =0");
        valueLength=valStr.length;
        value=new double [valueLength];
        for (int i = 0; (i < valueLength); i++) {
            value[i]=new Double (valStr[i]);
        }
    }
    @Override
    public String toString() {
          String tmpStr;
        StringBuilder retStr =new StringBuilder("{");
        for (int i = 0; i < valueLength-1; i++) {
            tmpStr=Double.toString(value[i]);
            retStr.append(tmpStr.trim());
            retStr.append(", ");
        }
        tmpStr=Double.toString(value[valueLength-1]);
        retStr.append(tmpStr.trim());
        retStr.append("}");
        return retStr.toString();
    }

    @Override
    public Var add(Var newValue) throws Exception {
        if (newValue instanceof Scalar) {
            Scalar tmpScalar = (Scalar) newValue;
            double[] tmpArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < tmpArr.length; i++) {
                tmpArr[i] += tmpScalar.getValue();
            }
            return new Vector(tmpArr);
    }
        if (newValue instanceof Vector) {
            Vector tmpVector = (Vector) newValue;
            if (tmpVector.length() ==valueLength) {
                double[] tmpArr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < tmpArr.length; i++) {
                    tmpArr[i] += tmpVector.getValue(i);
                }
                return new Vector(tmpArr);
            }
        }
        return super.add(newValue);
    }

    @Override
    public Var sub(Var newValue) throws Exception {
        if (newValue instanceof Scalar) {
            Scalar tmpScalar = (Scalar) newValue;
            double[] tmpArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < tmpArr.length; i++) {
                tmpArr[i] -= tmpScalar.getValue();
            }
            return new Vector(tmpArr);
        }
        if (newValue instanceof Vector) {
            Vector tmpVector = (Vector) newValue;
            if (tmpVector.length() ==valueLength) {
                double[] tmpArr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < tmpArr.length; i++) {
                    tmpArr[i] -= tmpVector.getValue(i);
                }
                return new Vector(tmpArr);
            }
        }
        return super.add(newValue);
    }

    @Override
    public Var mul(Var newValue) throws Exception {
        if (newValue instanceof Scalar) {
            Scalar tmpScalar = (Scalar) newValue;
            double[] tmpArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < tmpArr.length; i++) {
                tmpArr[i] *= tmpScalar.getValue();
            }
            return new Vector(tmpArr);
        }
        if (newValue instanceof Vector) {
            Vector tmpVector = (Vector) newValue;
            if (tmpVector.length() ==valueLength) {
                double[] tmpArr = Arrays.copyOf(value, value.length);
                double retValue=0;
                for (int i = 0; i < tmpArr.length; i++) {
                    retValue+=tmpArr[i] * tmpVector.getValue(i);
                }
                return new Scalar(retValue);
            }
        }
        return super.add(newValue);
    }


    @Override
    public Var div(Var newValue) throws Exception {
        if (newValue instanceof Scalar) {
            Scalar tmpScalar = (Scalar) newValue;
            if (tmpScalar.getValue() == 0) {
                System.out.println("Omg!! Division by zero");
            } else {
                double[] tmpArr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < tmpArr.length; i++) {
                    tmpArr[i] /= tmpScalar.getValue();
                }
                return new Vector(tmpArr);
            }
        }

        return super.add(newValue);
        }

        }

