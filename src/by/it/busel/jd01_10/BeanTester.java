package by.it.busel.jd01_10;

import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Object o = beanClass.getDeclaredConstructor().newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        goThroughParamMethodsAndPrint(beanClass, o, methods);
    }

    private static void goThroughParamMethodsAndPrint(Class<Bean> beanClass, Object o, Method[] methods)
            throws Exception {
        for (Method m : methods) {
            if (m.isAnnotationPresent(Param.class)) {
                Param tempAnnotation = m.getAnnotation(Param.class);
                StringBuilder tempString = new StringBuilder();
                double calculationResult = (double) m.invoke(o, tempAnnotation.a(), tempAnnotation.b());
                tempString.append(m.getName()).append(" ").append(calculationResult);
                System.out.println(tempString);
            }
        }
    }
}
