package com.study.springboot_swagger2_01.controller;

import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringDTO;
import com.study.springboot_swagger2_01.domain.VideoTreeVO;
import com.study.springboot_swagger2_01.message.ResultMap;
import com.study.springboot_swagger2_01.service.DeviceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Objects;
/**
 * <p>
 * 全部系统设备信息表  前端控制器
 * </p>
 *
 * @author yangqiuwei
 * @since 2021-3-17
 */
@RestController
@RequestMapping("/hmf/deviceinfo")
@Api(value = "设备信息", tags = "设备信息模块")
@Slf4j
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;


    @ApiOperation(value = "查询所有设备(不分页)")
    @PostMapping("/selectAllList")
    public Map<String,Object> selectAllList(){
        return new ResultMap().Data(deviceInfoService.selectAllList());
    }

    @ApiOperation(value = "获得实况所需的资源树")
    @PostMapping("/getVideoTree")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = VideoTreeVO.class)
    })
    public Map<String,Object> getVideoTree(){
        return new ResultMap().Data(deviceInfoService.getVideoTree());
    }



}

