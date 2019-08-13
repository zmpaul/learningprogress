package com.paul.base.basis;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.paul.base.bean.Child;

/**
 * jdk8 optional 用法
 * 
 * @ClassName: BaseOptional
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年8月13日 上午11:36:37
 */
public class BaseOptional {

    @Test
    public void optional() {
        Child child = null;
        Optional<Child> option = Optional.ofNullable(child);
        child = option.orElse(new Child("name", "sex"));
        String sex = child.getSex();
        Assert.assertEquals("sex", sex);
        // *******************
        Optional<String> empty = Optional.empty();
        // 参数不为空
        Optional<String> name = Optional.of("Name");

        // 相当于((value) -> { System.out.println(value);});
        name.ifPresent(System.out::println);
        // 如果Optional值不为空，lambda表达式会处理并在其上执行操作。
        name.ifPresent((value) -> {
            System.out.println(" the name value is " + value);
        });
        empty.ifPresent((value) -> {
            System.out.println(" the empty value is " + value);
        });
        // orElse(): returns the value if present, otherwise return other
        Assert.assertEquals("Name", name.orElse("th"));
        // orElseGet(): returns the value if present,
        // otherwise invoke other and return the result of its invocation
        Assert.assertEquals("Name", name.orElseGet(() -> "sd"));
        
        Assert.assertEquals("sd", empty.orElseGet(() -> "sd"));
        
        try {
            // empty.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertSame(empty, name.filter((value) -> {
            return false;
        }));;
        
        Assert.assertEquals("NAME", name.map((value) -> {
            return value.toUpperCase();
        }).get());
        
        empty.map((value)->{
            return value.toUpperCase();
        });
        // flatMap 与 map 类似 区别在于返回Optional
        Assert.assertEquals("NAME", name.flatMap((value) -> {
            return Optional.of(value.toUpperCase());
        }).get());
    }
}
