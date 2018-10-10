package com.paul.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class ReflectBaseEntity {

    private static Logger logger = Logger.getLogger(ReflectBaseEntity.class);
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class baseEntityClass = Class.forName("com.paul.base.annotation.BaseEntity");
        Field[] fields = baseEntityClass.getDeclaredFields();
        for (Field field :fields) {
            SimpleAnnotation simpleAnnotation = field.getAnnotation(SimpleAnnotation.class);
            System.out.println(simpleAnnotation.name());
        }
        Method[] methods = baseEntityClass.getDeclaredMethods();
        for (Method method : methods) {
            SimpleAnnotation simpleAnnotation = method.getAnnotation(SimpleAnnotation.class);
            System.out.println(simpleAnnotation.name());
        }
    }
}
