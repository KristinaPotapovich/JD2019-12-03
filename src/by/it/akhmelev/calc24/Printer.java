package by.it.akhmelev.calc24;

class Printer {

    void print(Var var) {
        if (var != null)
            System.out.println(var);
        else
            System.out.println("Unknown ERROR!!!");
    }

}
