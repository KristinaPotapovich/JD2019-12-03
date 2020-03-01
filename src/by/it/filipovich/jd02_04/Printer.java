package by.it.filipovich.jd02_04;

class Printer {
    void print(Var variable){
        if(variable != null)
            System.out.println(variable);
        else
            System.out.println("Unknown Error!");
    }
}
