package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.springboot_swagger2_01.domain.UserDTO;
import com.study.springboot_swagger2_01.mapper.UserMapper;
import com.study.springboot_swagger2_01.pojo.User;
import com.study.springboot_swagger2_01.service.UserService;
import com.study.springboot_swagger2_01.utils.PageQuery;
import com.study.springboot_swagger2_01.utils.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        userMapper.insert(user);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        userMapper.updateById(user);
        return true;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<User> getUsersByPage(UserDTO userDTO) {
        PageQuery.pageParamCheck(userDTO.getPageNo(),userDTO.getPageSize());
        Page<User> page = new Page<>(userDTO.getPageNo(),userDTO.getPageSize(),0);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(userDTO.getName())){
            queryWrapper.like("name",userDTO.getName());
        }
        if(!Objects.isNull(userDTO.getAge())){
            queryWrapper.eq("age",userDTO.getAge());
        }
        if(StringUtils.isNotEmpty(userDTO.getEmail())){
            queryWrapper.eq("email",userDTO.getEmail());
        }
        return userMapper.selectPage(page, queryWrapper);
    }

    /*//每5s执行一次定时任务
    @Scheduled(cron = "0/5 * * * * ?")*/
    //每天凌晨执行一次定时任务
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void systemDateTask() {
        System.out.println("SystemDateTask输出："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Async
    @Override
    public void asyncTest() {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException  e){
            e.printStackTrace();
        }
        System.out.println("业务进行中....  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
