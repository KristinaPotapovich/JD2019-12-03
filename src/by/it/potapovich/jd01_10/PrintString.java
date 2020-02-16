package by.it.potapovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC){
              String [] methodDescription =  method.toString().split("String\\.");
                for (String s : methodDescription) {
                }

                String signature = methodDescription [1];
              String [] signatureMethods = signature.split("\\(");
              String methodName = signatureMethods [0];
              System.out.println(methodName);

            }

        }
    }
}
