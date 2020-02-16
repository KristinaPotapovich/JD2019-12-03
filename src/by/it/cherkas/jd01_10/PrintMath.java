package by.it.cherkas.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Math;


public class PrintMath {
    public static void main(String[] args) {
        Class<Math> smathClass = Math.class;
        Method[] methods=Math.class.getMethods();
        for (Method method : methods) {
            int modifiers=method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                StringBuilder str=new StringBuilder("public ");
                if (Modifier.isStatic(modifiers))
                    str.append("static ").append(method.getName()).append("(");
                method.getParameterTypes();
                System.out.println(str);
            }
        }

    }
}
