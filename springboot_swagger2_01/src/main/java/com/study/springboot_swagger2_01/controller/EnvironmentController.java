package com.study.springboot_swagger2_01.controller;

import com.study.springboot_swagger2_01.pojo.Environment;
import com.study.springboot_swagger2_01.domain.EnvironmentDTO;
import com.study.springboot_swagger2_01.domain.EnvironmentVO;
import com.study.springboot_swagger2_01.service.EnvironmentService;
import com.study.springboot_swagger2_01.message.ResultMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;
import com.study.springboot_swagger2_01.utils.ApiLog;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * environment  前端控制器
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
@Slf4j
@RestController
@RequestMapping("/hmf/environment")
@Api(value="EnvironmentController",tags = "环境模块")
public class EnvironmentController {
    @Autowired
    private  EnvironmentService environmentService;

    /**
     * 分页查询环境信息
     * @param environmentDTO 请求参数对象
     * @return 分页信息
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页查询环境信息", notes = "分页查询环境信息")
    @ApiLog(title = "根据条件分页查询环境信息",isSaveRequestData = false)
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = EnvironmentVO.class)
    })
    public Map<String,Object> listEnvironment(@RequestBody EnvironmentDTO environmentDTO) {
        return new ResultMap().Data(environmentService.pagelist(environmentDTO));
    }


    /**
     * 通过id查询环境信息
     * @param id
     * @return 环境信息对象
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "通过id查询环境信息", notes = "通过id查询环境信息")
    @ApiLog(title = "根据id查询环境信息",isSaveRequestData = false)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,paramType="path")
    })
    public Map<String,Object> getEnvironment(@PathVariable("id") Integer id){
      return new ResultMap().Data(environmentService.getById(id));
    }

    /**
     * 新增环境信息
     * @param environment 环境信息对象
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增环境信息", notes = "新增环境信息")
    @ApiLog(title = "新增环境信息",isSaveRequestData = false)
    public Map<String,Object> saveEnvironment(@RequestBody Environment environment){
      return new ResultMap().Data(environmentService.save(environment));
    }

    /**
     * 修改环境信息
     * @param environment 环境信息对象
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改环境信息", notes = "修改环境信息")
    @ApiLog(title = "修改环境信息",isSaveRequestData = false)
    public Map<String,Object> updateEnvironment(@RequestBody Environment environment){
      return new ResultMap().Data(environmentService.updateById(environment));
    }

    /**
     * 通过id数组批量删除环境信息
     * @param ids id数组
     * @return
     */
    @DeleteMapping("/deleteByIds")
    @ApiOperation(value = "通过id数组批量删除删除环境信息", notes = "通过id数组批量删除环境信息")
    @ApiLog(title = "通过id数组批量删除环境信息",isSaveRequestData = false)
    public Map<String,Object> deleteEnvironment(@RequestBody List<Integer> ids){
      return new ResultMap().Data(environmentService.removeByIds(ids));
    }

}
