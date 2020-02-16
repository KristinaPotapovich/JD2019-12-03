package by.it.filipovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Method[] methods = Math.class.getMethods();
        Field[] fields = Math.class.getFields();

        for (Method declaredMethod1 : methods) {
            int modifier = declaredMethod1.getModifiers();
            if(Modifier.isPublic(modifier)){
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(modifier))
                        .append(" ")
                        .append(declaredMethod1.getReturnType().toString())
                        .append(" ")
                        .append(declaredMethod1.getName())
                        .append("(")
                        .append(toString(declaredMethod1.getParameterTypes()))
                        .append(")");
                System.out.println(sb);
            }
        }
        for (Field field : fields) {
            int modifier1 = field.getModifiers();
            if(Modifier.isPublic(modifier1)){
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(modifier1))
                        .append(" ")
                        .append(field.getType().toString())
                        .append(" ")
                        .append(field.getName());
                System.out.println(sb);
            }
        }
    }

    public static String toString(Class[] var){
        StringBuilder sb = new StringBuilder();
        if(var.length>1) {
            for (int i = 0; i < var.length - 1; i++) {
                sb.append(var[i].toString()).append(",");
            }
            sb.append(var[var.length - 1]);
        }
        else if (var.length==1)
            sb.append(var[0].toString());
        return sb.toString();
    }
}
