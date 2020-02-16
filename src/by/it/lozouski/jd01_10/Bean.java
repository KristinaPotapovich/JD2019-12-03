package by.it.lozouski.jd01_10;

class Bean {

    @Param(a = 2, b = 5)
    static double sum(int a, int b) {
        return a + b; //7
    }

    @Param(a = 1, b = 10)
    double max(int a, int b) {
        return Math.max(a, b); //10
    }

    @Param(a = 1, b = 10)
    double min(int a, int b) {
        return Math.min(a, b); //1
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0; //3,5
    }
}
