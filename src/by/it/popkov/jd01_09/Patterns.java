package by.it.popkov.jd01_09;

class Patterns {
    static final String MATH_SIGN = "[-+/*]";
    static final String SCALAR = "[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
