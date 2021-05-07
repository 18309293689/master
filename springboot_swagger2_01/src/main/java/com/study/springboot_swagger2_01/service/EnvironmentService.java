package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.springboot_swagger2_01.pojo.Environment;
import com.study.springboot_swagger2_01.domain.EnvironmentVO;
import com.study.springboot_swagger2_01.domain.EnvironmentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * environment  服务类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
public interface EnvironmentService extends IService<Environment> {
    /**
     * 分页查询表信息
     *
     * @param environmentDTO 请求参数
     * @return 分页信息
     */
    IPage<EnvironmentVO> pagelist(EnvironmentDTO environmentDTO);


}
