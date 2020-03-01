package by.it.kuzmichalex.jd01_07;

class Matrix extends Var{
    double value[][];
    /**
     * construct from double[][]
     * */
    Matrix(double[][] value) {
        this.value=new double[value.length][value[0].length];
        for (int y = 0; y <value.length ; y++) {
            System.arraycopy(value[y],0,this.value[y], 0,value[y].length);
        }
    }
    /**
     * Conctruct from Matrix
     * */
    Matrix(Matrix inMatrix){
        this.value=new double[inMatrix.value.length][inMatrix.value[0].length];
        for (int y = 0; y <inMatrix.value.length ; y++) {
            System.arraycopy(inMatrix.value[y],0,this.value[y], 0,inMatrix.value[y].length);
        }
    }

    /**
     * construct from string {{1,2},{3,4},{5,6}}
     * */
    Matrix(String strMatrix){
        int ySize=0;
        int xSize=0;
        String[] stringOfMatrix=strMatrix.replace(" ","").split("[\\}]{1}[\\,]{1}[\\{]{1}");
        ySize=stringOfMatrix.length;
        for (int i = 0; i <ySize ; i++) {
            String[] elementOfString=stringOfMatrix[i].split(",");
            if(elementOfString.length>xSize)xSize=elementOfString.length;
        }
        value = new double[ySize][xSize];
        for (int y = 0; y <ySize ; y++) {
            String[] elementOfString=stringOfMatrix[y].split(",");
            for (int x = 0; x < elementOfString.length; x++) {
                this.value[y][x]=Double.parseDouble(elementOfString[x].replaceAll("[\\{|\\}]{1}",""));
            }
        }
    }



    /**
     * Converts Matrix value to string {{1, 2, 3}, {4, 5, 6}}
     * */
    @Override
    public String toString() {
        StringBuffer retStrBuffer = new StringBuffer("{");
        for (int y = 0; y <this.value.length ; y++) {
            retStrBuffer.append("{");
            for (int x = 0; x <this.value[y].length ; x++) {
                retStrBuffer.append(Double.toString(this.value[y][x]));
                if(x<(this.value[y].length-1))retStrBuffer.append(", ");
            }
            retStrBuffer.append("}");
            if(y<(this.value.length-1))retStrBuffer.append(", ");
        }
        retStrBuffer.append("}");
        return retStrBuffer.toString();
    }
}
