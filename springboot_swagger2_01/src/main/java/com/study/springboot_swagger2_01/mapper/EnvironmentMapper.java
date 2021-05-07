package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.study.springboot_swagger2_01.pojo.Environment;

/**
 * <p>
 * 环境表  Mapper 接口
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
@Mapper
public interface EnvironmentMapper extends BaseMapper<Environment> {

}
