package by.it.filipovich.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Bean bean = Bean.class.newInstance();
        Method[] declaredMethods = Bean.class.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(Param.class)) {
                Param annotation = declaredMethod.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object invoke = declaredMethod.invoke(bean,a,b);
                System.out.println(declaredMethod.getName());
                System.out.println(invoke.toString());
            }
        }
    }
}
