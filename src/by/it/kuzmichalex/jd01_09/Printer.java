package by.it.kuzmichalex.jd01_09;

class Printer {

    void print(Var varToPrint) {
        if (varToPrint != null)
            System.out.println(varToPrint);
        else
            System.out.println("Пустое значение для печати");
    }

}
