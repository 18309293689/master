package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.pojo.Buildings;
import com.study.springboot_swagger2_01.mapper.BuildingsMapper;
import com.study.springboot_swagger2_01.service.BuildingsService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.study.springboot_swagger2_01.domain.BuildingsVO;
import com.study.springboot_swagger2_01.domain.BuildingsDTO;
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
 * buildings  服务实现类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:47:35
 */
@Service
@Slf4j
public class BuildingsServiceImpl extends ServiceImpl<BuildingsMapper, Buildings> implements BuildingsService {
    @Resource
    private BuildingsMapper buildingsMapper;

    /**
     * 分页查询表信息
     *
     * @param buildingsDTO 请求参数
     * @return 分页信息
     */
    @Override
    public IPage<BuildingsVO> pagelist(BuildingsDTO buildingsDTO) {
        PageQuery.pageParamCheck(buildingsDTO.getPageNo(), buildingsDTO.getPageSize());

        Page<Buildings> page = new Page<>(buildingsDTO.getPageNo(), buildingsDTO.getPageSize(), 0);

        QueryWrapper<Buildings> queryWrapper = new QueryWrapper<>();
        List<BuildingsVO> list = new ArrayList<>();

        if (!Objects.isNull(buildingsDTO.getId())) {
            queryWrapper.eq("id", buildingsDTO.getId());
        }
        if (StringUtils.isNotEmpty(buildingsDTO.getName())) {
            queryWrapper.eq("name", buildingsDTO.getName());
        }
        if (!Objects.isNull(buildingsDTO.getUpNumber())) {
            queryWrapper.eq("up_number", buildingsDTO.getUpNumber());
        }
        if (!Objects.isNull(buildingsDTO.getDownNumber())) {
            queryWrapper.eq("down_number", buildingsDTO.getDownNumber());
        }
        if (StringUtils.isNotEmpty(buildingsDTO.getFloorUnit())) {
            queryWrapper.eq("floor_unit", buildingsDTO.getFloorUnit());
        }
        if (StringUtils.isNotEmpty(buildingsDTO.getMark())) {
            queryWrapper.eq("mark", buildingsDTO.getMark());
        }

        IPage<Buildings> buildingsIPage = buildingsMapper.selectPage(page, queryWrapper);
        List<Buildings> buildingsList = buildingsIPage.getRecords();
        if (CollectionUtils.isNotEmpty(buildingsList)) {
            for (Buildings buildings : buildingsList) {
                BuildingsVO buildingsVO = new BuildingsVO();
                BeanUtils.copyProperties(buildings, buildingsVO);
                list.add(buildingsVO);
            }
        }
        IPage<BuildingsVO> newIpage = page.convert(Buildings -> Convert.copyProperties(Buildings, BuildingsVO.class));
        newIpage.setRecords(list);
        return newIpage;
    }
}
