package by.it.cherkas.jd01_07;

        class Vector extends Var {

                private double[] value;


                 Vector(double[] value) {
                        this.value = new double[value.length];
                        System.arraycopy(value, 0, this.value,0,this.value.length);

                }
                Vector(Vector vector){
                         this.value=new double[vector.value.length];
                         System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
                }

                Vector(String strVector){
                         String[] vectorString=strVector.trim().substring(0, strVector.length()-1).split(", ");
                       this.value=new double[vectorString.length];
                        for (int i = 0; i <vectorString.length ; i++) {
                        this.value[i]=Double.parseDouble(vectorString[i]);
                        }
                }


                @Override
                public String toString() {
                StringBuilder sb=new StringBuilder();
                sb.append("{");
                String del="";
                        for (double element:value ) {
                        sb.append(del);
                        sb.append(element);
                        del=", ";
                        }
                        sb.append("}");
                        return sb.toString();
                }
        }




