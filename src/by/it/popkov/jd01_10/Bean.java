package by.it.popkov.jd01_10;

class Bean {
    @Param(a = 1, b = 3)
    double sum(int a, int b) {
        return a + b;
    }
    @Param(a = 1, b = 3)
    static double max(int a, int b) {
        return Math.max(a, b);
    }
    @Param(a = 1, b = 3)
    static double min(int a, int b) {
        return Math.min(a, b);
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
