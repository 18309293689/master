package com.study.springboot_swagger2_01.controller;

import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringDTO;
import com.study.springboot_swagger2_01.domain.UserDTO;
import com.study.springboot_swagger2_01.message.ResultMap;
import com.study.springboot_swagger2_01.pojo.User;
import com.study.springboot_swagger2_01.service.UserService;
import com.study.springboot_swagger2_01.utils.RedisUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSONValidator.Type.Array;

@RestController
@Api("用户控制器")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/addUser")
    @ApiOperation("新增用户")
    public Map<String,Object> addUser(@RequestBody User user){
        return new ResultMap().Data(userService.addUser(user));
    }

    @DeleteMapping("/deleteUserByIds")
    @ApiOperation("根据id批量删除用户")
    public Map<String,Object> deleteUserByIds(@RequestBody List<Integer> ids){
        return new ResultMap().Data(userService.deleteByIds(ids));
    }

    @PutMapping("/updateUser")
    @ApiOperation("修改用户信息")
    public Map<String,Object> updateUser(@RequestBody User user){
        return new ResultMap().Data(userService.updateUser(user));
    }

    @GetMapping("/getUsers")
    @ApiOperation("获取所有用户信息")
    public Map<String,Object> getUsers(){
        return new ResultMap().Data(userService.getUsers());
    }

    //分页获得所有用户信息
    @PostMapping("/getUsersByPage")
    @ApiOperation("分页按条件查询用户信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = User.class)
    })
    public Map<String,Object> getUsersByPage(@RequestBody UserDTO userDTO){
        return new ResultMap().Data(userService.getUsersByPage(userDTO));
    }


    @GetMapping("/redisTest")
    @ApiOperation("测试redis的存值和取值")
    public Map<String,Object> redisTest(){
        //redisUtil.set("testName","Li Jiacheng");
        redisUtil.set("testName1","Li Jiacheng1");
        redisUtil.set("testName2","Li Jiacheng2");
        System.out.println(redisUtil.get("testName1"));
        System.out.println(redisUtil.get("testName2"));
        return new ResultMap().Data(true);
    }

    @GetMapping("/redisDelTest")
    @ApiOperation("测试redis的批量删除")
    public Map<String,Object> redisDelTest(){
        redisUtil.del("testName1","testName2");
        System.out.println(redisUtil.get("testName1"));
        System.out.println(redisUtil.get("testName2"));
        return new ResultMap().Data(true);
    }

    @GetMapping("/scheduleTest")
    @ApiOperation("测试定时任务")
    public Map<String,Object> systemDateTask(){
        userService.systemDateTask();
        return new ResultMap().Data(true);
    }

    @GetMapping("/asyncTest")
    @ApiOperation("测试异步任务")
    public Object asyncTest(){
        userService.asyncTest();
        return "Hello async: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }



}
