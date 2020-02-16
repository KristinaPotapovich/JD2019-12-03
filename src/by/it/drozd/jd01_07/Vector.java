package by.it.drozd.jd01_07;


import java.util.Arrays;

class Vector extends Var{
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }
    Vector(Vector vector){
    this.value=vector.value;
    }
    Vector(String strVector){

        String nums = strVector.substring(1, strVector.length() - 1);
        this.value = Arrays.stream(nums.split(",")).mapToDouble(Double::parseDouble).toArray();
        }



    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
