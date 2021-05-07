package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.domain.VideoTreeVO;
import com.study.springboot_swagger2_01.mapper.DeviceInfoMapper;
import com.study.springboot_swagger2_01.pojo.DeviceInfo;
import com.study.springboot_swagger2_01.service.DeviceInfoService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 设备信息表  服务实现类
 * </p>
 *
 * @author 蒋哲奇
 * @since 2020-11-06
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;



    //查询设备列表(不分页)
    @Override
    public List<DeviceInfo> selectAllList() {
        LambdaQueryWrapper<DeviceInfo> queryWrapper = Wrappers.<DeviceInfo>lambdaQuery();
        return deviceInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<VideoTreeVO> getVideoTree() {
        QueryWrapper<DeviceInfo> qr1 = new QueryWrapper<>();
        qr1.eq("type",'5').groupBy("building_name");
        //获取一级树所以对象
        List<DeviceInfo> list1 = deviceInfoMapper.selectList(qr1);
        ArrayList<VideoTreeVO> videoTreeVOS1 = new ArrayList<>();
        for (DeviceInfo deviceInfo : list1) {
            //设置一级树当前对象的楼栋属性
            VideoTreeVO videoTreeVO1 = new VideoTreeVO();
            videoTreeVO1.setBuildingName(deviceInfo.getBuildingName());

            //获得二级树所有对象
            QueryWrapper<DeviceInfo> qr2 = new QueryWrapper<>();
            qr2.eq("type",'5').
                    eq("building_name",deviceInfo.getBuildingName()).
                    groupBy("floor_name");
            List<DeviceInfo> list2 = deviceInfoMapper.selectList(qr2);
            ArrayList<VideoTreeVO> videoTreeVOS2 = new ArrayList<>();
            for (DeviceInfo info : list2) {
                //设置二级树当前对象的楼层属性
                VideoTreeVO videoTreeVO2 = new VideoTreeVO();
                videoTreeVO2.setFloorName(info.getFloorName());

                //获得三级树所有对象
                QueryWrapper<DeviceInfo> qr3 = new QueryWrapper<>();
                qr3.eq("type",'5').
                        eq("building_name",info.getBuildingName()).
                        eq("floor_name",info.getFloorName());
                List<DeviceInfo> list3 = deviceInfoMapper.selectList(qr3);
                ArrayList<VideoTreeVO> videoTreeVOS3 = new ArrayList<>();
                for (DeviceInfo deviceInfo1 : list3) {
                    //设置三级树当前对象的属性
                    VideoTreeVO videoTreeVO3 = new VideoTreeVO();
                    BeanUtils.copyProperties(deviceInfo1,videoTreeVO3);
                    videoTreeVOS3.add(videoTreeVO3);
                }
                //设置二级树当前对象的子树
                videoTreeVO2.setChildren(videoTreeVOS3);
                videoTreeVOS2.add(videoTreeVO2);
            }
            //设置一级树当前对象的子树
            videoTreeVO1.setChildren(videoTreeVOS2);
            videoTreeVOS1.add(videoTreeVO1);
        }
        return videoTreeVOS1;
    }

}
