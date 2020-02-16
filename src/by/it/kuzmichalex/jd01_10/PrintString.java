package by.it.kuzmichalex.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * prints non-static methods of String class
 * */
public class PrintString {
    public static void main(String[] args) {

        Class<?> stringClass=String.class;
        Method[] stringMethods = stringClass.getDeclaredMethods();
        for (Method stringMethod : stringMethods) {
            if(!Modifier.isStatic(stringMethod.getModifiers())) {
                System.out.println( stringMethod.getName());
            }

        }
    }
}
