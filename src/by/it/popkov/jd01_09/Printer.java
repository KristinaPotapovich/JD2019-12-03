package by.it.popkov.jd01_09;

class Printer {
    public void print(Var calc) {
        if (calc != null){
            System.out.println(calc.toString());
        }else {
            System.out.println("Error");
        }

    }
}
