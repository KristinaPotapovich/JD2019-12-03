package by.it.cherkas.jd01_04;



public class InOut {

    static double[ ] getArray(String line){
        String[] strArr=line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length ; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
            return res;
        }

    static void printArray(double[ ] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }


        }


        static void printArray ( double[] arr, String V, int column){
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%s[%- 3d]=%-10.4f ",V, i, arr[i]);
                //if((i+1)%column==0 || (i+1)==arr.length);
                if (i==column)System.out.println();


            }
            System.out.println();


        }

    }