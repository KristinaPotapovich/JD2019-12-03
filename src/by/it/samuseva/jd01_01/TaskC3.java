package by.it.samuseva.jd01_01;

import java.util.Scanner;
/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1. Метод getWeight(int weight) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int weightEarth = scan.nextInt();
        System.out.println(getWeight(weightEarth));
    }
    private static double getWeight(int weight){
        double weightMars;
        int weightMars100;
        double d;
        weightMars = weight * 3.86 / 9.81;
        weightMars100 = (int)(weightMars * 100);
        d = weightMars*100 - weightMars100;
        return (d<=0.5) ? (weightMars100/100.0) : (weightMars100/100.0+0.01);
        //  return (double)Math.round(weightMars*100)/100;
    }
}