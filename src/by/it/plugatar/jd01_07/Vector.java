package by.it.plugatar.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value){
        this.value=new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector vec) {
        this.value = new double[vec.value.length];
        System.arraycopy(vec.value, 0, this.value, 0, vec.value.length);
    }

    Vector(String s) {
        s = s.replace(".0", "");
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] split = s.split(",");
        this.value = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            this.value[i] = Double.parseDouble(split[i]);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder des = new StringBuilder(", ");
        sb.append(this.value[0]);
        for (int i = 1; i < this.value.length; i++) {
            sb.append(des).append(this.value[i]);
        }
        sb.append("}");
        return sb.toString();
    }
/*
    @Override
    public String toString() {
        return "Это класс Vector";
    }
*/

}
