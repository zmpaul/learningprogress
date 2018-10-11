package com.paul.base.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class ReflectBaseEntity {

    private static Logger logger = Logger.getLogger(ReflectBaseEntity.class);
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class baseEntityClass = Class.forName("com.paul.base.annotation.BaseEntity");
        testAnnotructor(baseEntityClass);
        Class childEntityClass = Class.forName("com.paul.base.annotation.ChildEntity");
        // new ChildEntity().getClass();
        testAnnotructor(childEntityClass.getClass());
    }
    private static void testAnnotructor(Class baseEntityClass) {
        SimpleAnnotation superclassAnnotation = (SimpleAnnotation) baseEntityClass.getSuperclass()
                .getAnnotation(SimpleAnnotation.class);
        // 读取父类的类注解
        logger.debug("ReflectBaseEntity[classAnnotation] superclassAnnotation "
                + superclassAnnotation.name());
        // SimpleAnnotation 通过@Inherited ,可以继承父类的类注解
        SimpleAnnotation classAnnotation =
                (SimpleAnnotation) baseEntityClass.getAnnotation(SimpleAnnotation.class);
        logger.debug(
                "ReflectBaseEntity[classAnnotation] classAnnotation "
                + classAnnotation.name());
        Field[] fields = baseEntityClass.getDeclaredFields();
        // 无法读取父类field method constructor 注解 baseEntityClass.superClass()
        for (Field field :fields) {
            if (field.isAnnotationPresent(SimpleAnnotation.class)) {
                SimpleAnnotation filedAnnotation = field.getAnnotation(SimpleAnnotation.class);
                logger.debug("ReflectBaseEntity[classAnnotation] filedAnnotation "
                        + filedAnnotation.name());
            }
        }
        Method[] methods = baseEntityClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SimpleAnnotation.class)) {
                SimpleAnnotation methodAnnotation = method.getAnnotation(SimpleAnnotation.class);
                logger.debug("ReflectBaseEntity[classAnnotation] methodAnnotation "
                        + methodAnnotation.name());
            }

        }
        Constructor[] constructors = baseEntityClass.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(SimpleAnnotation.class)) {
                SimpleAnnotation constructorAnnotation =
                        (SimpleAnnotation) constructor.getAnnotation(SimpleAnnotation.class);
                logger.debug("ReflectBaseEntity[constructorAnnotation] constructorAnnotation "
                        + constructorAnnotation.name());
            }

        }
    }
}
