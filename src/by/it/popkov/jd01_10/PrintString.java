package by.it.popkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    static void getNotStaticName(Class<?> aClass){
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) System.out.println(method.getName());
        }
    }

    public static void main(String[] args) {
        getNotStaticName(String.class);
    }
}
