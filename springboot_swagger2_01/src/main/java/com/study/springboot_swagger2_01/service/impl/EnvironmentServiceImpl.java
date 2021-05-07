package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.pojo.Environment;
import com.study.springboot_swagger2_01.mapper.EnvironmentMapper;
import com.study.springboot_swagger2_01.service.EnvironmentService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.study.springboot_swagger2_01.domain.EnvironmentVO;
import com.study.springboot_swagger2_01.domain.EnvironmentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.springboot_swagger2_01.utils.PageQuery;
import java.util.*;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.beans.BeanUtils;
import com.study.springboot_swagger2_01.utils.Convert;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * environment  服务实现类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
@Service
@Slf4j
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper, Environment> implements EnvironmentService {
    @Resource
    private EnvironmentMapper environmentMapper;

    /**
     * 分页查询表信息
     *
     * @param environmentDTO 请求参数
     * @return 分页信息
     */
    @Override
    public IPage<EnvironmentVO> pagelist(EnvironmentDTO environmentDTO) {
        PageQuery.pageParamCheck(environmentDTO.getPageNo(), environmentDTO.getPageSize());

        Page<Environment> page = new Page<>(environmentDTO.getPageNo(), environmentDTO.getPageSize(), 0);

        QueryWrapper<Environment> queryWrapper = new QueryWrapper<>();
        List<EnvironmentVO> list = new ArrayList<>();

        if (!Objects.isNull(environmentDTO.getId())) {
            queryWrapper.eq("id", environmentDTO.getId());
        }
        if (StringUtils.isNotEmpty(environmentDTO.getCode())) {
            queryWrapper.eq("code", environmentDTO.getCode());
        }
        if (!Objects.isNull(environmentDTO.getSpotNo())) {
            queryWrapper.eq("spot_no", environmentDTO.getSpotNo());
        }
        if (StringUtils.isNotEmpty(environmentDTO.getSpotNm())) {
            queryWrapper.eq("spot_nm", environmentDTO.getSpotNm());
        }
        if (StringUtils.isNotEmpty(environmentDTO.getSpotType())) {
            queryWrapper.eq("spot_type", environmentDTO.getSpotType());
        }
        if (StringUtils.isNotEmpty(environmentDTO.getSpotValue())) {
            queryWrapper.eq("spot_value", environmentDTO.getSpotValue());
        }
        if (StringUtils.isNotEmpty(environmentDTO.getSpotState())) {
            queryWrapper.eq("spot_state", environmentDTO.getSpotState());
        }

        IPage<Environment> environmentIPage = environmentMapper.selectPage(page, queryWrapper);
        List<Environment> environmentList = environmentIPage.getRecords();
        if (CollectionUtils.isNotEmpty(environmentList)) {
            for (Environment environment : environmentList) {
                EnvironmentVO environmentVO = new EnvironmentVO();
                BeanUtils.copyProperties(environment, environmentVO);
                list.add(environmentVO);
            }
        }
        IPage<EnvironmentVO> newIpage = page.convert(Environment -> Convert.copyProperties(Environment, EnvironmentVO.class));
        newIpage.setRecords(list);
        return newIpage;
    }
}
