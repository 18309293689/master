package com.study.springboot_swagger2_01.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringDTO;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringQueryDTO;
import com.study.springboot_swagger2_01.message.ResultMap;
import com.study.springboot_swagger2_01.service.EnvironmentMonitoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 环境监控  前端控制器
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/hmf/environmentmonitoring")
@Api(value = "环境监控", tags = "环境监控系统")
@Slf4j
public class EnvironmentMonitoringController {

    @Resource
    private EnvironmentMonitoringService environmentMonitoringService;

    @ApiOperation("从第三方接口获取并更新环境监控信息的通用信息")
    @GetMapping(value = "updateEnvironmentMonitoringsNormal")
    public Map<String ,Object> updateEnvironmentMonitoringsNormal(){
        environmentMonitoringService.updateEnvironmentMonitoringsNormal();
        return new ResultMap().Data(true);
    }

    @ApiOperation("从第三方接口获取并更新环境监控信息的动态信息")
    @GetMapping(value = "updateEnvironmentMonitoringsSpecial")
    public Map<String ,Object> updateEnvironmentMonitoringsSpecial(){
        environmentMonitoringService.updateEnvironmentMonitoringsSpecial();
        return new ResultMap().Data(true);
    }

    /*@ApiOperation("条件查询环境监控信息")
    @PostMapping(value = "queryEnvironmentMonitorings")
    public Map<String ,Object> queryEnvironmentMonitorings(@RequestBody EnvironmentMonitoringQueryDTO environmentMonitoringQueryDTO){
        return new ResultMap().Data(environmentMonitoringService.queryEnvironmentMonitorings(environmentMonitoringQueryDTO));
    }*/

    @ApiOperation("条件查询环境监控信息")
    @PostMapping(value = "queryEnvironmentMonitorings")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = EnvironmentMonitoringDTO.class)
    })
    public Map<String ,Object> queryEnvironmentMonitorings(@RequestBody EnvironmentMonitoringQueryDTO environmentMonitoringQueryDTO){
        return new ResultMap().Data(environmentMonitoringService.queryEnvironmentMonitorings(environmentMonitoringQueryDTO));
    }




}

