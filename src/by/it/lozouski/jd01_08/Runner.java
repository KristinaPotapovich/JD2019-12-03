package by.it.lozouski.jd01_08;

class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var scalar = new Scalar(3.0);
        Var vector = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var matrix = new Matrix("{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        print(scalar.add(scalar)); //выведет в консоль 6.0
        print(scalar.sub(scalar)); //выведет в консоль 0.0
        print(scalar.mul(scalar)); //выведет в консоль 9.0
        print(scalar.div(scalar)); //выведет в консоль 1.0
//        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(vector.add(vector)); //выведет в консоль {2.0, 4.0, 6.0}
        print(vector.sub(vector)); //выведет в консоль {0.0, 0.0, 0.0}
        print(vector.mul(vector)); //выведет в консоль 14.0
        print(vector.div(vector)); //сообщит о невозможности операции
///* Уровень сложности C (матричные операции и умножение на вектор)
//закомментируйте, если не реализовали */
        print(matrix.add(matrix)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(matrix.sub(matrix)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(matrix.mul(matrix)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(matrix.mul(vector)); //{14.0, 32.0, 50.0}
    }
}
