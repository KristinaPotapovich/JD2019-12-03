package by.it.borodachev.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> bean = Bean.class;
        Class<? extends Annotation> anno = Param.class;
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");
        Object instance = bean.getDeclaredConstructor().newInstance();
        int countAnnotation = 0;
        Method[] methods = bean.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(anno)) {
                countAnnotation++;
                Annotation an = method.getAnnotation(anno);
                int aValue = (int) a.invoke(an);
                int bValue = (int) b.invoke(an);
                String name = method.getName();
                double result;
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    result = (double) method.invoke(null, aValue, bValue);
                } else {
                    result = (double) method.invoke(instance, aValue, bValue);
                }
                  System.out.println(name+"="+result);
            }
        }
    }
}
