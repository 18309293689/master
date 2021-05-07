package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.springboot_swagger2_01.pojo.Buildings;
import com.study.springboot_swagger2_01.domain.BuildingsVO;
import com.study.springboot_swagger2_01.domain.BuildingsDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * buildings  服务类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:47:35
 */
public interface BuildingsService extends IService<Buildings> {
    /**
     * 分页查询表信息
     *
     * @param buildingsDTO 请求参数
     * @return 分页信息
     */
    IPage<BuildingsVO> pagelist(BuildingsDTO buildingsDTO);


}
