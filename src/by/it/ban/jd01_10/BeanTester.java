package by.it.ban.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        double beanReturn;
        Class<?> beanTest;
        Object beanObject;

        beanTest = Bean.class;
        beanObject = beanTest.newInstance();

        Method[] beanMethods = beanTest.getDeclaredMethods();
        for (Method beanMethod : beanMethods) {
            Param beanAnnotation = beanMethod.getAnnotation(Param.class);
            if (beanAnnotation != null) {
                beanReturn = (double) beanMethod.invoke(beanObject, beanAnnotation.a(), beanAnnotation.b());
                System.out.println(new StringBuilder().append(beanMethod.getName()).append(" ").append(beanReturn).toString());
            }
        }
    }

}
