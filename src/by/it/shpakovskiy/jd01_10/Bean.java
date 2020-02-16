package by.it.shpakovskiy.jd01_10;

class Bean {
    @Param(a = 2, b = 5)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 9, b = 7)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 6, b = 5)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
