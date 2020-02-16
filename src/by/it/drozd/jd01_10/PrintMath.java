package by.it.drozd.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getMethods();
        for (Method method : declaredMethods) {
            if((method.getModifiers() & Modifier.PUBLIC) ==Modifier.PUBLIC){
                System.out.println(method);
            }
        }
    }
    
}
