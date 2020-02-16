package by.it.plugatar.calc;

public class Printer  {
    void print(Var var) throws CalcException{
        if (var != null)
            System.out.println(var);
        else
            //System.out.println("Unknown ERROR!!!");
        throw new CalcException("ERROR: Exception Variable");
    }
}
