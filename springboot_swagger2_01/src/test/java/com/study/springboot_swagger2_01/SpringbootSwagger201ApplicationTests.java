package com.study.springboot_swagger2_01;

import com.study.springboot_swagger2_01.configuration.SpringContextUtils;
import com.study.springboot_swagger2_01.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSwagger201ApplicationTests {

    @Test
    void contextLoads() {
        //按字节码(即类型)获得bean
        User user1 = SpringContextUtils.getBean(User.class);
        System.out.println(user1);
        user1.setAge(112);
        user1.setName("dd2");
        System.out.println(user1);
        //按名称获得bean
        User user2 = (User) SpringContextUtils.getBean("user");
        System.out.println(user2);
        user2.setAge(112);
        user2.setName("dd2");
        System.out.println(user2);
        //按名称和字节码获得bean
        User user3 = SpringContextUtils.getBean("user", User.class);
        System.out.println(user3);
        user3.setAge(113);
        user3.setName("dd3");
        System.out.println(user3);
    }

}
