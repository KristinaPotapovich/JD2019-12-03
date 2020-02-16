package by.it.shulga.jd01.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClass1 = String.class;
        Method[] declaredMethods1 = stringClass1.getDeclaredMethods();

        for (Method method : declaredMethods1) {
            if((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {

                System.out.println(method);
            }
        }

    }
}

