package by.it.samuseva.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        create(Bean.class);

    }

    static void create(Class<?> cls) {
        try {
            Method[] methods = cls.getMethods();
            Object object = null;
            for (Method method : methods) {
                if (method.isAnnotationPresent(Param.class)){
                    if(object==null) object=cls.getDeclaredConstructor().newInstance();
                    Param annotation = method.getAnnotation(Param.class);
                    System.out.println(method.getName()+ " " + method.invoke(object, annotation.a(),annotation.b()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
