package com.study.springboot_swagger2_01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.springboot_swagger2_01.domain.VideoTreeVO;
import com.study.springboot_swagger2_01.pojo.DeviceInfo;

import java.util.List;

/**
 * <p>
 * 设备信息表  服务类
 * </p>
 *
 * @author yangqiuwei
 * @since 2021-3-17
 */
public interface DeviceInfoService extends IService<DeviceInfo> {

    //查询设备列表(不分页)
    List<DeviceInfo> selectAllList();

    List<VideoTreeVO> getVideoTree();

}
