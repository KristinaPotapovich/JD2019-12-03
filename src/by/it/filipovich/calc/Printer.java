package by.it.filipovich.calc;

class Printer {
    void print(Var variable){
        if(variable != null)
            System.out.println(variable);
        else
            System.out.println("Unknown Error!");
    }
}
