package by.it.borodachev.jd01_13;

import java.util.*;

public class TaskC {
    private static Scanner scanner;
    private static void readData() throws InterruptedException {
        List<Double>inpData = new ArrayList<>();
        int errCount=0;
        while (true) {
         String strSome = scanner.next();

            try {
               Double tmpVal= Double.valueOf(strSome);
                inpData.add(tmpVal);
            }
              catch (NullPointerException |NumberFormatException e){
                  errCount++;
                  if (errCount >=5) {
                      throw e;
                  }
                  Thread.sleep(100);
                  ListIterator<Double> it =  inpData.listIterator(inpData.size());

                   while (it.hasPrevious()) {
                        System.out.print(it.previous()+" ");
                    }
                    System.out.println("");
                }
            }
        }
     public static void main(String[] args) throws InterruptedException {
        scanner=new Scanner(System.in);
        readData();
    }
}
