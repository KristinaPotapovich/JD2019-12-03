package by.it.ban.jd01_10;

import java.lang.reflect.Field;
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
                str.append(" ").append(method.getReturnType().getName());
                str.append(" ").append(method.getName()).append("(");
                String delimiter="";
                for (Class<?> parameterType : method.getParameterTypes()) {
                    str.append(delimiter).append(parameterType.getName());
                    delimiter=",";
                }
                str.append(")");

                System.out.println(str);
            }
        }
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            StringBuilder str = new StringBuilder("");
            if  (Modifier.isPublic(declaredField.getModifiers())) {
                str.append(declaredField.getType()).append(" ").append(declaredField.getName());
                System.out.println(str);
            }


        }

    }
}
