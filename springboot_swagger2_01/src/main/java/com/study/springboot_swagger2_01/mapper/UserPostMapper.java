package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.study.springboot_swagger2_01.pojo.UserPost;

/**
 * <p>
 * 用户post表   Mapper 接口
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
@Mapper
public interface UserPostMapper extends BaseMapper<UserPost> {

}
