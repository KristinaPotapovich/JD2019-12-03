package by.it.samuseva.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        Field[] fields = mathClass.getFields();
        System.out.println("Публичные поля:");
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder str = new StringBuilder("public");
                if (Modifier.isStatic(modifiers)){
                    str.append(" ").append("static");
                    if (Modifier.isFinal(modifiers)){
                        str.append(" ").append("final").append(" ");
                        System.out.println(str + field.getType().toString() + " " + field.getName());

                    }
                }
            }

        }
        System.out.println("\nПубличные методы:");
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                StringBuilder str = new StringBuilder("public");
                if (Modifier.isStatic(modifiers)){
                    str.append(" ").append("static").append(" ");
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    StringBuilder strParameter = new StringBuilder();
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes.length == 1) {
                            strParameter.append(parameterTypes[i]);
                        } else {
                            if (i != parameterTypes.length-1){
                                strParameter.append(parameterTypes[i]).append(",");
                            } else {
                                strParameter.append(parameterTypes[i]);
                            }
                        }
                    }
                    System.out.println(str + method.getReturnType().toString() + " "
                            + method.getName()+ "("+ strParameter + ")");
                }
            }
        }

    }
}
