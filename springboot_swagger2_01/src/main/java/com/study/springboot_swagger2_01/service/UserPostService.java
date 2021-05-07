package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.springboot_swagger2_01.pojo.UserPost;
import com.study.springboot_swagger2_01.domain.UserPostVO;
import com.study.springboot_swagger2_01.domain.UserPostDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * user_post  服务类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
public interface UserPostService extends IService<UserPost> {
    /**
     * 分页查询表信息
     *
     * @param userPostDTO 请求参数
     * @return 分页信息
     */
    IPage<UserPostVO> pagelist(UserPostDTO userPostDTO);


}
