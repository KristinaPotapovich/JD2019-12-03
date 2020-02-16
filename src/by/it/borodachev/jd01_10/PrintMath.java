package by.it.borodachev.jd01_10;

import java.lang.reflect.*;


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
            if (Modifier.isFinal(modifiers))
                    str.append(" final");
                str.append(" ").append(method.getReturnType());
                str.append(" ").append(method.getName()).append("(");
                Type[] parameters = method.getParameterTypes();
                for (int i = 0; i < parameters.length; i++) {
                    str.append(parameters[i]);
                   if ( i < parameters.length-1) {str.append(",");}
                }
                str.append(")");

                System.out.println(str);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            StringBuilder str = new StringBuilder("");
                str.append(field.getType());
                str.append(" ").append(field.getName());
                System.out.println(str) ;
        }
    }
}
