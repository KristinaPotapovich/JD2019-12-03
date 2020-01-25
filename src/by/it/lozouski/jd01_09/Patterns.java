package by.it.lozouski.jd01_09;

class Patterns {
    static final String OPERATION = "[-+*/]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
