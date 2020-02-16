package by.it.busel.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
TaskB1
 */
class PrintMath {

    private static void addParameterTypes(StringBuilder sb, Method method) {
        sb.append("(");
        Class<?>[] parameter = method.getParameterTypes();
        int iMax = parameter.length - 1;
        for (int i = 0; i < parameter.length; i++) {
            if (i != iMax) {
                sb.append(String.valueOf(parameter[i])).append(",");
            } else {
                sb.append(String.valueOf(parameter[i]));
            }
        }
        sb.append(")\n");
    }

    private static void printAllPublicFieldsAndMethodsOfMath() {
        Class<Math> cls = Math.class;
        StringBuilder sb = new StringBuilder("");
        collectFieldsOfMath(cls, sb);
        collectMethodsOfMath(cls, sb);
        System.out.println(sb);

    }

    private static void collectFieldsOfMath(Class<Math> cls, StringBuilder sb) {
        Field[] field = cls.getDeclaredFields();
        for (Field f : field) {
            int mod = f.getModifiers();
            if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
                sb.append("public static ").append(f.getGenericType()).append(" ").append(f.getName()).
                        append("\n");
            }
        }

    }

    private static void collectMethodsOfMath(Class<Math> cls, StringBuilder sb) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            int mod = m.getModifiers();
            if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
                sb.append("public static ").append(m.getReturnType()).append(" ").append(m.getName());
                addParameterTypes(sb, m);
            }
        }
    }

    public static void main(String[] args) {
        printAllPublicFieldsAndMethodsOfMath();
    }
}
