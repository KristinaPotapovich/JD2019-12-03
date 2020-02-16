package by.it.popkov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Bean bean = beanClass.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                sb.append(method.getName())
                        .append(" ")
                        .append(method.invoke(bean, annotation.a(), annotation.b()))
                        .append("\n");
            }
        }
        System.out.println(sb);
    }
}
