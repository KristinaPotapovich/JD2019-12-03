package by.it.rumiantcau.jd01_05;
public class TaskC {

    public static void main(String[] args) {
        int lenghtMas = 28;
        double mas1[];


        //formirovanie pervogo massiva
        mas1 = mas(lenghtMas);
        System.out.println("Массив A[]");
        //vyvod pervogo massiva
        printMas(mas1, "A");
        System.out.println();

        System.out.println("Массив B[]");
        //formirovanie vtorogo massiva > 3.5
        masNew(mas1);
        printMas(mas1, "B");
        System.out.println();

        //sredneeGeometricheskoe
        System.out.println(sredneeGeometricheskoe(mas1));


    }

    private static double sredneeGeometricheskoe(double[] mas1) {
        double srGeo = 1;
        for (double v : mas1) {
            srGeo = srGeo * v;
        }
        srGeo = Math.pow(srGeo, 1.0/mas1.length);
        return srGeo;

    }


    private static double[] mas(int lenghtMas) {
        int yMas = 0;
        double minX = 5.33;
        double maxX = 9;
        //  lenghtMas =  (int) ((Math.random() * ((max - min) + 1)) + min);

        System.out.println("vybrana velichina massiva = " + (lenghtMas +1));
        double[] mas = new double[lenghtMas];
        double deltaX = (maxX - minX) / (lenghtMas-1);

        for (double x = minX; x <= maxX; x = x + deltaX) {
            mas[yMas] = Math.cbrt(x * x + 4.75);
            yMas = yMas +1;
            //  System.out.println("x = " + x + "| yMas =" + yMas);
        }
        return mas;

    }



    private static double[] masNew(double[] mas) {
        System.out.println("Nachalo formirovanija massiva so znachenijami bolshe 3.5");
        int masCount = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 3.5) masCount++;
        }

        if (masCount == 0) {
            System.out.println("V massive net znachenij bolshe 3.5");
            return null;
        }
        else {
            double[] masNew = new double[masCount];
            int masI = 0;

            for (int i = 0; i < mas.length; i++) {
                if (mas[i] > 3.5) {
                    masNew[masI] = mas[i];
                    masI++;
                }
            }
            System.out.println("Konec formirovanie massiva so znachenijami bolshe 3.5");
            return masNew;
        }


    }

    private static void printMas(double[] mas, String name) {
        for (int i = 0; i < mas.length; i++) {

            System.out.printf("%s[%d]=%f ", name,  i, mas[i]);


           // System.out.print("MAS [ " + i + " ] = " + mas[i] + "\t");
            if (((i % 5) == 0) && (i > 0)) System.out.println();

        }
    }


}
