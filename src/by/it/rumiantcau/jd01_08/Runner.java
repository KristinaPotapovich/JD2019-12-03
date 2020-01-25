package by.it.rumiantcau.jd01_08;

public class Runner {
    private static void print(Var var) {

        if (var != null)
            System.out.println(var);
    }

    public static void main(String[] args) {
        Var m3 = new Matrix("{{1, 2}, {3, 4}}");// матрицу, если вы их не реализовали
        Var s = new Scalar(1.0);
  //      print(m3.add(s));
   //     print(m3.add(s));
        print(m3.sub(s));
        print(m3.sub(s));
  /*  Var s = new Scalar(1.0);
        Var v = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{3, 4, 5});


        // закомментируйте вектор и/или*/
          /*  Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
      Var m2 = new Matrix("{{4,2,4},{1,1,1},{1,1,1}}");// матрицу, если вы их не реализовали

        print(s.add(v));
         Уровень сложности A (калькулятор) */
            /* print(s.add(s)); //выведет в консоль 6.0
        print(v.add(s)); //
        print(s.add(v)); //
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
   // Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
    /*    print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.mul(v)); //выведет в консоль 14.0 */
    //    print(v.div(v)); //сообщит о невозможности операции
    //    print(v.div(v2)); //сообщит о невозможности операции


      //  print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}

      //  System.out.println(m.mul(s));
 //print(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
// print(m2.add(s)); //
 //print(m3.add(m3)); //

  //  print(m.add(m2)); //
      //  print(m.sub(m));
       // print(v.mul(m));
       //print(m.sub(s));
        /* Уровень сложности C (матричные операции и умножение на вектор)
    закомментируйте, если не реализовали

        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}

        print(m.mul(v)); //{14.0, 32.0, 50.0}*/

    }
}
