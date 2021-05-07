package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.springboot_swagger2_01.domain.UserDTO;
import com.study.springboot_swagger2_01.pojo.User;

import java.util.List;
public interface UserService {

    boolean addUser(User user);

    boolean deleteByIds(List<Integer> ids);

    boolean updateUser(User user);

    List<User> getUsers();

    IPage<User> getUsersByPage(UserDTO userDTO);

    /**
     * <p>
     * 测试定时任务的方法
     * </p>
     *
     * @author 刘嘉淋
     * @since 2021/04/09
     */
    void systemDateTask();

    void asyncTest();

}
