package by.it.shpakovskiy.jd01_10;

import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Bean bean = beanClass.getDeclaredConstructor().newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                int a = method.getAnnotation(Param.class).a();
                int b = method.getAnnotation(Param.class).b();
                double result = (double) method.invoke(bean, a, b);
                System.out.println(method.getName() + ": " + result);
            }
        }
    }
}
