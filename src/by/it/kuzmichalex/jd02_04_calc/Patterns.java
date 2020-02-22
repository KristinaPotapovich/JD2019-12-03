package by.it.kuzmichalex.jd02_04_calc;

public class Patterns {

    static final String OPERATION="[-+*/=]";
    static final String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    static final String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";
    static final String VARNAME="^[a-zA-Z_]{1,}[a-zA-Z1-9_]{0,}";
    static final String OPERATION_PATTERN = "([()])|(?<=[^-+*/={(,])[-+*/=]";

    private Patterns() {
    }
}
