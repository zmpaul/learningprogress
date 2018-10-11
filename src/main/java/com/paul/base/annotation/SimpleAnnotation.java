package com.paul.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention ：注解的生命周期
 *            1.SOURCE:在源文件中有效（即源文件保留）
 *            2.CLASS:在class文件中有效（即class保留）
 *            3.RUNTIME:在运行时有效（即运行时保留）
 * @Inherited : 被继承 子class读取父class 类上的注解
 * @Target : 使用范围
 *         1.CONSTRUCTOR:用于描述构造器
 *         2.FIELD:用于描述域
 *         3.LOCAL_VARIABLE:用于描述局部变量
 *         4.METHOD:用于描述方法
 *         5.PACKAGE:用于描述包
 *         6.PARAMETER:用于描述参数
 *         7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * @author admin
 * @date 2018年10月11日 上午11:54:52
 */
@Retention(RetentionPolicy.RUNTIME) // 反射可读取注解
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE, ElementType.LOCAL_VARIABLE,
        ElementType.TYPE,
        ElementType.CONSTRUCTOR})
@Inherited // 只作用于类注解
@Documented
public @interface SimpleAnnotation {

    public String name() default "test";
}
