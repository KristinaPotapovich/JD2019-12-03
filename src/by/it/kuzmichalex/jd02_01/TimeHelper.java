package by.it.kuzmichalex.jd02_01;

import java.util.Random;

class TimeHelper {
    private static final int SUPER_SPEED = 100;         //Ускоритель времени (для удобства просмотра)
    private static final double SLOW_SPEED = 1.5;       //Замедлитель пенсионера (для разнообразия покупателей)
    private static Random random = new Random(System.nanoTime());

    /**
     * Получить случайное число в диапазоне [nMinimum, nMaximum] включительно
     *
     * @param nMinimum минимальное значение
     * @param nMaximum максимальное значение
     * @return Слцчайное значение от nMinimum до nMaximum
     */
    static int getRandom(int nMinimum, int nMaximum) {
        if (nMinimum == nMaximum) return nMinimum;
        return (nMinimum + random.nextInt(nMaximum - nMinimum + 1));
    }

    /**
     * Получить коэффициант замедления покупателя
     */
    public static double getSlowSpeed() {
        return SLOW_SPEED;
    }

    /**
     * Получить коэффициент ускорния процесса просмотра
     */
    static int getSuperSpeed() {
        return SUPER_SPEED;
    }

    /**
     * засыпатель с обработкой ошибок сна.
     * Время сна кооректируется константой SUPER_SPEED
     */
    static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut / SUPER_SPEED);
        } catch (InterruptedException e) {
            System.out.println("I can't sleep no more!");
        }
    }
}
