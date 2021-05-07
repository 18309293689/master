package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.pojo.FacealarmHistory;
import com.study.springboot_swagger2_01.mapper.FacealarmHistoryMapper;
import com.study.springboot_swagger2_01.service.FacealarmHistoryService;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 人脸布控告警
 * </p>
 *
 * @package: com.study.springboot_swagger2_01.service.impl
 * @description: 人脸布控告警
 * @author: Liu Jialin
 * @date: Created in 2021-04-17 11:17:57
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Liu Jialin
 */
@Service
public class FacealarmHistoryServiceImpl extends ServiceImpl<FacealarmHistoryMapper, FacealarmHistory> implements FacealarmHistoryService {

}
