package by.it.rumiantcau.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringStructure = String.class;
        Method[] methodsStrings = stringStructure.getDeclaredMethods();
        for (Method methodsString : methodsStrings) {
            if((methodsString.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(methodsString.getName());
        }


    }

}
