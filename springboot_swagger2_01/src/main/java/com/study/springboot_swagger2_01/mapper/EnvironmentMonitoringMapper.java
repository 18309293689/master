package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springboot_swagger2_01.pojo.EnvironmentMonitoring;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  环境监控 Mapper 接口
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021-04-08
 */
@Mapper
public interface EnvironmentMonitoringMapper extends BaseMapper<EnvironmentMonitoring> {

}
