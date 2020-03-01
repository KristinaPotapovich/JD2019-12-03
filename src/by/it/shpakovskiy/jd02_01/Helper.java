package by.it.shpakovskiy.jd02_01;

class Helper {
    static final int K_SPEED = 50;

    static int getRandom(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
