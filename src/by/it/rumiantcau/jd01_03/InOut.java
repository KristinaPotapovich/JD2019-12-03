package by.it.rumiantcau.jd01_03;
/*p
public class InOut {

    static Double[] getArray(String line) {
        String[] strArr=line.split(" ");
        Double[] res= new Double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
         return res;

    }

    static void printArray(Double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(Double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -4d]=%-11.4f ",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
            
        }
    }


}*/
public class InOut {
    static double [] getArray(String line){
        String[]strArr = line.split(" ");
        double [] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=  Double.parseDouble(strArr[i]);


        }





        return res;
    }
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");

        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name,i,arr[i]);
            if ((i+1)%columnCount==0||i+1==arr.length){
                System.out.println();
            }

        }
    }
}

