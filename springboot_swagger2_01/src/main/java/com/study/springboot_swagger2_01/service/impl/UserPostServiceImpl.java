package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.pojo.UserPost;
import com.study.springboot_swagger2_01.mapper.UserPostMapper;
import com.study.springboot_swagger2_01.service.UserPostService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.study.springboot_swagger2_01.domain.UserPostVO;
import com.study.springboot_swagger2_01.domain.UserPostDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.springboot_swagger2_01.utils.PageQuery;
import java.util.*;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.beans.BeanUtils;
import com.study.springboot_swagger2_01.utils.Convert;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * user_post  服务实现类
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
@Service
@Slf4j
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {
    @Resource
    private UserPostMapper userPostMapper;

    /**
     * 分页查询表信息
     *
     * @param userPostDTO 请求参数
     * @return 分页信息
     */
    @Override
    public IPage<UserPostVO> pagelist(UserPostDTO userPostDTO) {
        PageQuery.pageParamCheck(userPostDTO.getPageNo(), userPostDTO.getPageSize());

        Page<UserPost> page = new Page<>(userPostDTO.getPageNo(), userPostDTO.getPageSize(), 0);

        QueryWrapper<UserPost> queryWrapper = new QueryWrapper<>();
        List<UserPostVO> list = new ArrayList<>();

        if (!Objects.isNull(userPostDTO.getId())) {
            queryWrapper.eq("id", userPostDTO.getId());
        }
        if (StringUtils.isNotEmpty(userPostDTO.getName())) {
            queryWrapper.eq("name", userPostDTO.getName());
        }

        IPage<UserPost> userPostIPage = userPostMapper.selectPage(page, queryWrapper);
        List<UserPost> userPostList = userPostIPage.getRecords();
        if (CollectionUtils.isNotEmpty(userPostList)) {
            for (UserPost userPost : userPostList) {
                UserPostVO userPostVO = new UserPostVO();
                BeanUtils.copyProperties(userPost, userPostVO);
                list.add(userPostVO);
            }
        }
        IPage<UserPostVO> newIpage = page.convert(UserPost -> Convert.copyProperties(UserPost, UserPostVO.class));
        newIpage.setRecords(list);
        return newIpage;
    }
}
