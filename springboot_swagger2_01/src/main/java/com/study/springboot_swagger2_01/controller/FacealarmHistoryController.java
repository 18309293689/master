package com.study.springboot_swagger2_01.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.springboot_swagger2_01.common.PageResult;
import com.study.springboot_swagger2_01.common.R;
import com.study.springboot_swagger2_01.pojo.FacealarmHistory;
import com.study.springboot_swagger2_01.domain.FacealarmHistoryDTO;
import com.study.springboot_swagger2_01.service.FacealarmHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
/**
 * <p>
 * 人脸布控告警
 * </p>
 *
 * @package:  com.study.springboot_swagger2_01.controller
 * @description: 人脸布控告警
 * @author: Liu Jialin
 * @date: Created in 2021-04-17 11:17:57
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Liu Jialin
 */
@Slf4j
@RestController
@RequestMapping("/facealarmhistory")
@Api("FacealarmHistoryController")
public class FacealarmHistoryController {
    @Autowired
    private  FacealarmHistoryService facealarmHistoryService;

    /**
     * 分页查询人脸布控告警
     * @param facealarmHistoryDTO 数据传输对象
     * @return R
     */
    /*@GetMapping("/page")
    @ApiOperation(value = "分页查询人脸布控告警", notes = "分页查询人脸布控告警")
    public R listFacealarmHistory(@ModelAttribute(name = "数据传输对象") FacealarmHistoryDTO facealarmHistoryDTO) {
        log.info("listFacealarmHistory-->{}",facealarmHistoryDTO);
        Page page=new Page(facealarmHistoryDTO.getPageNumber(),facealarmHistoryDTO.getPageSize());
        FacealarmHistory facealarmHistory=new FacealarmHistory();
        BeanUtils.copyProperties(facealarmHistoryDTO,facealarmHistory);
        facealarmHistoryService.page(page, Wrappers.query(facealarmHistory));
        PageResult<FacealarmHistory> pageResult=new PageResult(page.getTotal(),page.getCurrent(),page.getSize(),page.getRecords());
        return R.success(pageResult);
    }*/


    /**
     * 通过id查询人脸布控告警
     * @param fid id
     * @return R
     */
    @GetMapping("/{fid}")
    @ApiOperation(value = "通过id查询人脸布控告警", notes = "通过id查询人脸布控告警")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fid", value = "主键id", required = true,paramType="path")
    })
    public R getFacealarmHistory(@PathVariable("fid") Integer fid){
      log.info("getFacealarmHistory-->{}",fid);
      return R.success(facealarmHistoryService.getById(fid));
    }

    /**
     * 新增人脸布控告警
     * @param facealarmHistory 人脸布控告警
     * @return R
     */
    @PostMapping
    @ApiOperation(value = "新增人脸布控告警", notes = "新增人脸布控告警")
    public R saveFacealarmHistory(@RequestBody FacealarmHistory facealarmHistory){
      log.info("saveFacealarmHistory-->{}",facealarmHistory);
      return R.success(facealarmHistoryService.save(facealarmHistory));
    }

    /**
     * 修改人脸布控告警
     * @param facealarmHistory 人脸布控告警
     * @return R
     */
    @PutMapping
    @ApiOperation(value = "修改人脸布控告警", notes = "修改人脸布控告警")
    public R updateFacealarmHistory(@RequestBody FacealarmHistory facealarmHistory){
      log.info("updateFacealarmHistory-->{}",facealarmHistory);
      return R.success(facealarmHistoryService.updateById(facealarmHistory));
    }

    /**
     * 通过id删除人脸布控告警
     * @param fid id
     * @return R
     */
    @DeleteMapping("/{fid}")
    @ApiOperation(value = "删除人脸布控告警", notes = "删除人脸布控告警")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fid", value = "主键id", required = true,paramType="path")
    })
    public R deleteFacealarmHistory(@PathVariable Integer fid){
      log.info("deleteFacealarmHistory-->{}",fid);
      return R.success(facealarmHistoryService.removeById(fid));
    }

}
