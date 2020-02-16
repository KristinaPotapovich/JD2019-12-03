package by.it.kuzmichalex.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        double beanReturn;
        Class<?>  beanTest;
        Object beanObject;

        beanTest=Bean.class;
        beanObject=beanTest.newInstance();

        Method[] beanMethods = beanTest.getDeclaredMethods();
        for (Method beanMethod : beanMethods) {
            //System.out.println("Method " + beanMethod.getName());
            Param beanAnnotation = beanMethod.getAnnotation(Param.class);
            if(beanAnnotation!=null){
                beanReturn = (double) beanMethod.invoke(beanObject, beanAnnotation.a(), beanAnnotation.b());
                System.out.println(beanMethod.getName() + " " + beanReturn);
            }
        }
    }
}
