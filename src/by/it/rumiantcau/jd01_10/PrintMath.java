package by.it.rumiantcau.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methodsClass = mathClass.getDeclaredMethods();
        for (Method methodI : methodsClass) {
            StringBuilder str = new StringBuilder("public static ");
            if (((methodI.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                    && ((methodI.getModifiers() & Modifier.STATIC) == Modifier.STATIC)) {

                Class<?>[] parameterTypes = methodI.getParameterTypes();
                str.append(methodI.getReturnType()).append(" ").append(methodI.getName()).append("(");
                if (parameterTypes.length == 0)
                    str.append(")");
                if (parameterTypes.length == 1)
                    str.append(parameterTypes[0]).append(")");
                else {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (i == parameterTypes.length - 1)
                            str.append(parameterTypes[i]).append(")");
                        else str.append(parameterTypes[i]).append(",");
                    }


                }
                System.out.println(str);
            }


        }
        System.out.println("double E");
        System.out.println("double PI");


    }
}


