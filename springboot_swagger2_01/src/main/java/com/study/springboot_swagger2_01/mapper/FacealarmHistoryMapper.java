package com.study.springboot_swagger2_01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.study.springboot_swagger2_01.pojo.FacealarmHistory;

/**
 * <p>
 * 人脸布控告警
 * </p>
 *
 * @package:  com.study.springboot_swagger2_01.mapper
 * @description: 人脸布控告警
 * @author: Liu Jialin
 * @date: Created in 2021-04-17 11:17:57
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Liu Jialin
 */
@Mapper
public interface FacealarmHistoryMapper extends BaseMapper<FacealarmHistory> {

}
