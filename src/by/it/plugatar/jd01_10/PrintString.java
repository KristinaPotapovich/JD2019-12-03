package by.it.plugatar.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> ss = String.class;
        Method[] methods = ss.getDeclaredMethods();

        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) System.out.println(name);

        }
    }
}