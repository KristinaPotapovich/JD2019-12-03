package by.it.shulga.jd01.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    private Method method;

    public static void main(String[] args) {

        Class<Math> structMath = Math.class;

        Method[] methods = structMath.getMethods();
        Field[] pole = structMath.getFields();

        for (Method method : methods) {
            for (Field field : pole) {
                if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                    if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {


                        System.out.println(method);
                         System.out.println(field);
                    }
                }
            }
        }


    }
}


