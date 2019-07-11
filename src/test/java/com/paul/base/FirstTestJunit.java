package com.paul.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @ClassName: IOCConstructor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年7月9日 下午4:41:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/spring-test.xml")
public class FirstTestJunit {
    @Test
    public void testNull() {
        Assert.notNull(null, "不能为空");
    }
}
