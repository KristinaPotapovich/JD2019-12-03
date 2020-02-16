package by.it.plugatar.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder sb = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                sb.append("public ");

                if (Modifier.isPrivate(modifiers)) sb.append("private ");
                if (Modifier.isProtected(modifiers)) sb.append("protected ");
                if (Modifier.isStatic(modifiers)) sb.append("static ");

                Class<?> returnType = method.getReturnType();
                String ret = returnType.getSimpleName();

                int parameterCount = method.getParameterCount();
                Class<?>[] parameterTypes = method.getParameterTypes();

                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterCount == 1) {
                        System.out.printf("%s%s %s(%s)\n", sb, ret, name, parameterTypes[i]);
                    }

                    if (parameterCount == 2) {
                        System.out.printf("%s%s %s(%s,%s)\n", sb, ret, name, parameterTypes[i], parameterTypes[i + 1]);
                        i++;
                    }
                }

                if (parameterCount != 1 && parameterCount != 2) System.out.printf("%s%s %s()\n", sb, ret, name);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            System.out.printf("%s %s\n", type.getName(), field.getName());
        }

    }
}
