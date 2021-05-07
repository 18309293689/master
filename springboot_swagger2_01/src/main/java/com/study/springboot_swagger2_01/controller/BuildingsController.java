package com.study.springboot_swagger2_01.controller;

import com.study.springboot_swagger2_01.pojo.Buildings;
import com.study.springboot_swagger2_01.domain.BuildingsDTO;
import com.study.springboot_swagger2_01.domain.BuildingsVO;
import com.study.springboot_swagger2_01.service.BuildingsService;
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
 * buildings  前端控制器
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:47:35
 */
@Slf4j
@RestController
@RequestMapping("/hmf/buildings")
@Api(value="BuildingsController",tags = "楼栋管理表模块")
public class BuildingsController {
    @Autowired
    private  BuildingsService buildingsService;

    /**
     * 分页查询楼栋管理表信息
     * @param buildingsDTO 请求参数对象
     * @return 分页信息
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页查询楼栋管理表信息", notes = "分页查询楼栋管理表信息")
    @ApiLog(title = "根据条件分页查询楼栋管理表信息",isSaveRequestData = false)
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BuildingsVO.class)
    })
    public Map<String,Object> listBuildings(@RequestBody BuildingsDTO buildingsDTO) {
        return new ResultMap().Data(buildingsService.pagelist(buildingsDTO));
    }


    /**
     * 通过id查询楼栋管理表信息
     * @param id
     * @return 楼栋管理表信息对象
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "通过id查询楼栋管理表信息", notes = "通过id查询楼栋管理表信息")
    @ApiLog(title = "根据id查询楼栋管理表信息",isSaveRequestData = false)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,paramType="path")
    })
    public Map<String,Object> getBuildings(@PathVariable("id") Integer id){
      return new ResultMap().Data(buildingsService.getById(id));
    }

    /**
     * 新增楼栋管理表信息
     * @param buildings 楼栋管理表信息对象
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增楼栋管理表信息", notes = "新增楼栋管理表信息")
    @ApiLog(title = "新增楼栋管理表信息",isSaveRequestData = false)
    public Map<String,Object> saveBuildings(@RequestBody Buildings buildings){
      return new ResultMap().Data(buildingsService.save(buildings));
    }

    /**
     * 修改楼栋管理表信息
     * @param buildings 楼栋管理表信息对象
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改楼栋管理表信息", notes = "修改楼栋管理表信息")
    @ApiLog(title = "修改楼栋管理表信息",isSaveRequestData = false)
    public Map<String,Object> updateBuildings(@RequestBody Buildings buildings){
      return new ResultMap().Data(buildingsService.updateById(buildings));
    }

    /**
     * 通过id数组批量删除楼栋管理表信息
     * @param ids id数组
     * @return
     */
    @DeleteMapping("/deleteByIds")
    @ApiOperation(value = "通过id数组批量删除删除楼栋管理表信息", notes = "通过id数组批量删除楼栋管理表信息")
    @ApiLog(title = "通过id数组批量删除楼栋管理表信息",isSaveRequestData = false)
    public Map<String,Object> deleteBuildings(@RequestBody List<Integer> ids){
      return new ResultMap().Data(buildingsService.removeByIds(ids));
    }

}
