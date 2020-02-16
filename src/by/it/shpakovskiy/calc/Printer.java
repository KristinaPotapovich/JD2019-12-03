package by.it.shpakovskiy.calc;

class Printer {

    void print(Var var) {
        if (var != null)
            System.out.println(var);
        else
            System.err.println("Unknown ERROR!!!");
    }

}
