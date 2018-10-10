package com.paul.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE, ElementType.LOCAL_VARIABLE,
        ElementType.TYPE,
        ElementType.CONSTRUCTOR})
public @interface SimpleAnnotation {

    public String name() default "test";
}
