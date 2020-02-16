package by.it.busel.jd01_10;

/*
by.it.busel.jd01_10.TaskA2
 */
class Bean {
    @Param(a = 2, b = 5)
    static double sum(int a, int b) {
        return (double) (a + b);
    }

    @Param(a = 2, b = 5)
    double max(int a, int b) {
        return a > b ? (double) a : (double) b;
    }

    @Param(a = 2, b = 5)
    double min(int a, int b) {
        return a < b ? (double) a : (double) b;
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
