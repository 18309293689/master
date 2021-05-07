package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringDTO;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringQueryDTO;
import com.study.springboot_swagger2_01.pojo.EnvironmentMonitoring;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 * 环境监控表  服务类
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021-4-8
 */
public interface EnvironmentMonitoringService extends IService<EnvironmentMonitoring> {

    void updateEnvironmentMonitoringsNormal();

    void updateEnvironmentMonitoringsSpecial();

    IPage<EnvironmentMonitoringDTO> queryEnvironmentMonitorings(EnvironmentMonitoringQueryDTO environmentMonitoringQueryDTO);
}
