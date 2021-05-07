package com.study.springboot_swagger2_01.configuration;

import com.study.springboot_swagger2_01.mapper.UserMapper;
import com.study.springboot_swagger2_01.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Objects;

@Component
public class Started implements CommandLineRunner {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(Started.class);
    
	@Resource
	private UserMapper userMapper;
	@Value("${user.id}")
	private Integer userId;

    @Override
    public void run(String... strings) throws Exception {

    	User old=userMapper.selectById(userId);
    	
    	if(Objects.isNull(old)) {
    		User user=new User();
    		user.setId(userId);
    		user.setName("超级管理员");
    		user.setAge(999);
    		user.setEmail("admin@163.com");
    		userMapper.insert(user);
    	}
    	
    	LOGGER.info("start successfully.......");
    }
}
