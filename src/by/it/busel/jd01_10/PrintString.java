package by.it.busel.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
TaskB2
 */
class PrintString {
    public static void main(String[] args) {
        printNamesOfNonStaticMethodsOfStringClass();
    }

    private static void printNamesOfNonStaticMethodsOfStringClass() {
        Class<String> stringClass = String.class;
        StringBuilder sb = new StringBuilder("");
        collectNamesInSB(stringClass, sb);
        System.out.println(sb);

    }

    private static void collectNamesInSB(Class<String> stringClass, StringBuilder sb) {
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method m : methods) {
            if (!Modifier.isStatic(m.getModifiers())) {
                sb.append(m.getName()).append("\n");
            }
        }
    }
}
