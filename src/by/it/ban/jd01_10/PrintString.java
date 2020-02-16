package by.it.ban.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method stringMethod : methods) {
            if(!Modifier.isStatic(stringMethod.getModifiers())) {
                System.out.println( stringMethod.getName());
            }

        }
//        Field[] declaredFields = mathClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            StringBuilder str = new StringBuilder("");
//            if  (Modifier.isPublic(declaredField.getModifiers())) {
//                str.append(declaredField.getType()).append(" ").append(declaredField.getName());
//                System.out.println(str);
//            }
//
//
//        }

    }
}
