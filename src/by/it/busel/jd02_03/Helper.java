package by.it.busel.jd02_03;

import java.util.Random;

class Helper {
    private static Random random = new Random(System.nanoTime());

    static int getRandomIntValue(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.SPEED_COEFFICIENT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int from, int to) {
        int millis = Helper.getRandomIntValue(from, to);
        sleep(millis);
    }
}
