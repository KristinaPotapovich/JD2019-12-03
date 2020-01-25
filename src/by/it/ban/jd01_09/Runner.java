package by.it.ban.jd01_09;

import by.it.ban.jd01_09.Matrix;
import by.it.ban.jd01_09.Scalar;
import by.it.ban.jd01_09.Var;
import by.it.ban.jd01_09.Vector;

public class Runner {
    private static void print(by.it.ban.jd01_09.Var var) {
        if (var != null)
            System.out.println(var);
    }

    public static void main(String[] args) {
        by.it.ban.jd01_09.Var s = new by.it.ban.jd01_09.Scalar(3.0);
        by.it.ban.jd01_09.Var v = new by.it.ban.jd01_09.Vector(new double[]{1, 2, 3});        // закомментируйте вектор и/или
        by.it.ban.jd01_09.Var m = new by.it.ban.jd01_09.Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        by.it.ban.jd01_09.Var m1 = new by.it.ban.jd01_09.Matrix("{{1,2},{3,4}}");
        Var m2 = new by.it.ban.jd01_09.Matrix("{{4,5},{7,8}}");
        /*  Уровень сложности A (калькулятор) */
        print(s.add(s)); //выведет в консоль 6.0
        print(v.add(s)); //
        print(s.add(v)); //
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.mul(v)); //выведет в консоль 14.0
        print(v.div(v)); //сообщит о невозможности операции
        /* Уровень сложности C (матричные операции и умножение на вектор)
    закомментируйте, если не реализовали */
        print(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
        System.out.println("-----------");
        print(m1.add(m2));
        print(m1.sub(m2));
        print(m1.mul(m2));
    }
}
