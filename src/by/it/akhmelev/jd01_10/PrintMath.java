package by.it.akhmelev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder str = new StringBuilder("public");
                if (Modifier.isStatic(modifiers))
                    str.append(" static");
                str.append(" ").append(method.getName()).append("(");
                System.out.println(str);
            }
        }
    }
}
