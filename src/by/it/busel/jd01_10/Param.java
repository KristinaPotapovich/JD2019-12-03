package by.it.busel.jd01_10;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Param {
    int a();

    int b();
}
