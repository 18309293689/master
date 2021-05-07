package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springboot_swagger2_01.pojo.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 设备信息表  Mapper 接口
 * </p>
 *
 * @author 蒋哲奇
 * @since 2020-11-06
 */
@Mapper
public interface DeviceInfoMapper extends BaseMapper<DeviceInfo> {

}
