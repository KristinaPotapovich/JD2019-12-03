package by.it.popkov.calc;

class Patterns {
    static final String MATH_SIGN = "[-+/*=]";
    static final String SCALAR = "[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(, ?" + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(, ?" + VECTOR + ")*}";
    static final String LITTER = "[A-Za-zА-Яа-я]";
}
