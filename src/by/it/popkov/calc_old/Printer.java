package by.it.popkov.calc_old;

class Printer  {
    public void print (Var calc) throws CalcException {
        if (calc != null){
            System.out.println(calc.toString());
        }else {
            System.out.println("Error");
        }

    }
}
