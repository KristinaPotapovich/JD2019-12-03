package by.it.kuzmichalex.calc_jd01_15;

class Printer {

    void print(Var varToPrint) {
        if (varToPrint != null)
            System.out.println(varToPrint);
        else
            System.out.println("Пустое значение для печати");
    }

}
