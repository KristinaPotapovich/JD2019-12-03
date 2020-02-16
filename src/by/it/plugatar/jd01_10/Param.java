package by.it.plugatar.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//время действия
@Target(ElementType.METHOD)
public @interface Param {
    int a();
    int b();
}
