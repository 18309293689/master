package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springboot_swagger2_01.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
