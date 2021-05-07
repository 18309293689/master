package com.study.springboot_swagger2_01.controller;

import com.study.springboot_swagger2_01.pojo.UserPost;
import com.study.springboot_swagger2_01.domain.UserPostDTO;
import com.study.springboot_swagger2_01.domain.UserPostVO;
import com.study.springboot_swagger2_01.service.UserPostService;
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
 * user_post  前端控制器
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
@Slf4j
@RestController
@RequestMapping("/hmf/userpost")
@Api(value="UserPostController",tags = "用户post表模块")
public class UserPostController {
    @Autowired
    private  UserPostService userPostService;

    /**
     * 分页查询用户post表信息
     * @param userPostDTO 请求参数对象
     * @return 分页信息
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页查询用户post表信息", notes = "分页查询用户post表信息")
    @ApiLog(title = "根据条件分页查询用户post表信息",isSaveRequestData = false)
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = UserPostVO.class)
    })
    public Map<String,Object> listUserPost(@RequestBody UserPostDTO userPostDTO) {
        return new ResultMap().Data(userPostService.pagelist(userPostDTO));
    }


    /**
     * 通过id查询用户post表信息
     * @param id
     * @return 用户post表信息对象
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "通过id查询用户post表信息", notes = "通过id查询用户post表信息")
    @ApiLog(title = "根据id查询用户post表信息",isSaveRequestData = false)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,paramType="path")
    })
    public Map<String,Object> getUserPost(@PathVariable("id") Integer id){
      return new ResultMap().Data(userPostService.getById(id));
    }

    /**
     * 新增用户post表信息
     * @param userPost 用户post表信息对象
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增用户post表信息", notes = "新增用户post表信息")
    @ApiLog(title = "新增用户post表信息",isSaveRequestData = false)
    public Map<String,Object> saveUserPost(@RequestBody UserPost userPost){
      return new ResultMap().Data(userPostService.save(userPost));
    }

    /**
     * 修改用户post表信息
     * @param userPost 用户post表信息对象
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改用户post表信息", notes = "修改用户post表信息")
    @ApiLog(title = "修改用户post表信息",isSaveRequestData = false)
    public Map<String,Object> updateUserPost(@RequestBody UserPost userPost){
      return new ResultMap().Data(userPostService.updateById(userPost));
    }

    /**
     * 通过id数组批量删除用户post表信息
     * @param ids id数组
     * @return
     */
    @DeleteMapping("/deleteByIds")
    @ApiOperation(value = "通过id数组批量删除删除用户post表信息", notes = "通过id数组批量删除用户post表信息")
    @ApiLog(title = "通过id数组批量删除用户post表信息",isSaveRequestData = false)
    public Map<String,Object> deleteUserPost(@RequestBody List<Integer> ids){
      return new ResultMap().Data(userPostService.removeByIds(ids));
    }

}
