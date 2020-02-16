package by.it.shpakovskiy.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder stringBuilder = new StringBuilder("public ");
            if (Modifier.isStatic(modifiers)) {
                stringBuilder.append("static ");
            }
            stringBuilder.append(method.getReturnType().getName()).append(" ").append(method.getName()).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                stringBuilder.append(parameterTypes[i]);
                if (i != parameterTypes.length - 1)
                    stringBuilder.append(",");
            }
            stringBuilder.append(")");
            System.out.println(stringBuilder);

        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder stringBuilder = new StringBuilder("public ");
                if (Modifier.isStatic(modifiers))
                    stringBuilder.append("static ");
                stringBuilder.append(field.getType().getName()).append(" ").append(field.getName());
                System.out.println(stringBuilder);
            }
        }
    }
}
