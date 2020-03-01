package by.it.filipovich.jd01_05;

import static java.lang.Math.pow;

class AverageCalculation {

    static double geometricMean(double[] array) {
        double multiply = 1;
        int power = array.length;
        for (double v : array) {
            multiply = multiply*v;
        }
        return pow(multiply, 1.0/power);
    }
}
