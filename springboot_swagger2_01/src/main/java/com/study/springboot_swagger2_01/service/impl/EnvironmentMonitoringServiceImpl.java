package com.study.springboot_swagger2_01.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringDTO;
import com.study.springboot_swagger2_01.domain.EnvironmentMonitoringQueryDTO;
import com.study.springboot_swagger2_01.enums.EnvironmentMonitoringEnum;
import com.study.springboot_swagger2_01.enums.SystemEnum;
import com.study.springboot_swagger2_01.mapper.DeviceInfoMapper;
import com.study.springboot_swagger2_01.mapper.EnvironmentMonitoringMapper;
import com.study.springboot_swagger2_01.pojo.DeviceInfo;
import com.study.springboot_swagger2_01.pojo.EnvironmentMonitoring;
import com.study.springboot_swagger2_01.service.DeviceInfoService;
import com.study.springboot_swagger2_01.service.EnvironmentMonitoringService;
import com.study.springboot_swagger2_01.utils.Convert;
import com.study.springboot_swagger2_01.utils.PageQuery;
import com.study.springboot_swagger2_01.utils.PageUtil;
import com.study.springboot_swagger2_01.utils.RestTemplateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import static com.alibaba.fastjson.JSON.parseArray;

/**
 * <p>
 * 环境监控表  服务实现类
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021-04-08
 */
@Service
public class EnvironmentMonitoringServiceImpl extends
        ServiceImpl<EnvironmentMonitoringMapper, EnvironmentMonitoring> implements EnvironmentMonitoringService {

    @Resource
    private EnvironmentMonitoringMapper environmentMonitoringMapper;
    @Resource
    private EnvironmentMonitoringService environmentMonitoringService;
    @Resource
    private DeviceInfoMapper deviceInfoMapper;
    @Resource
    private DeviceInfoService deviceInfoService;
    @Resource
    private RestTemplateUtils restTemplateUtils;

    @Value("${Environment.getEquipNoAllState}")
    private String getEquipNoAllStateUrl;
    @Value("${Environment.getEquipName}")
    private String getEquipNameUrl;
    @Value("${Environment.getSpotName}")
    private String getSpotNameUrl;
    @Value("${Environment.getAllAnalogSpotValue}")
    private String getAllAnalogSpotValueUrl;
    @Value("${Environment.getAllDigitSpotValue}")
    private String getAllDigitSpotValueUrl;



    /**
     * <p>
     * 每天凌晨从第三方接口获取通用信息并更新入device_info表
     * </p>
     *
     * @author 刘嘉淋
     * @since 2021-04-08
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void updateEnvironmentMonitoringsNormal() {
        //调用工具类发送无参get请求,并获取所有设备号和状态
        String body1 = restTemplateUtils.getNoParam(getEquipNoAllStateUrl);
        JSONArray objects1 = parseArray(body1);
        //把所有信息存入map中：以code为键，status为值，方便后面组装数据
        Map<String, String> map = new HashMap<>();
        for (Object o : objects1) {
            JSONObject jsonObject = JSON.parseObject(o.toString());
            String code = jsonObject.get("EquipNo").toString();
            String status = "0".equals(jsonObject.get("State").toString()) ? EnvironmentMonitoringEnum.status_NORMAL.getMsg()
                    : EnvironmentMonitoringEnum.status_ALARM.getMsg();
            map.put(code,status);
        }

        //调用工具类发送无参get请求,并获取所有设备号和设备名称
        String body2 = restTemplateUtils.getNoParam(getEquipNameUrl);
        JSONArray objects2 = parseArray(body2);
        //用于批量操作的集合
        List<DeviceInfo> addList = new ArrayList<>();
        List<DeviceInfo> updateList = new ArrayList<>();
        //遍历json数组，获取每个对象进行组装数据
        for (Object object : objects2) {
            //获得所有属性
            JSONObject mr = JSON.parseObject(object.toString());
            String code = mr.get("device_no").toString();
            String newname = mr.get("device_nm").toString();
            //用map的get方法获取code对应的status
            String status = map.get(code);

            //条件过滤:判断新增还是修改
            QueryWrapper<DeviceInfo> deviceInfoQueryWrapper = new QueryWrapper<>();
            deviceInfoQueryWrapper.eq("code", code);
            deviceInfoQueryWrapper.eq("systemname", SystemEnum.ENVIRONMENTAL.getMsg());
            DeviceInfo deviceInfo = deviceInfoMapper.selectOne(deviceInfoQueryWrapper);
            if(Objects.isNull(deviceInfo)){
                //设备不存在就新增加入addList
                DeviceInfo addDeviceInfo = new DeviceInfo();
                addDeviceInfo.setCode(code);
                addDeviceInfo.setNewname(newname);
                addDeviceInfo.setStatus(status);
                addDeviceInfo.setType(SystemEnum.ENVIRONMENTAL.getCode());
                addDeviceInfo.setSystemname(SystemEnum.ENVIRONMENTAL.getMsg());
                addList.add(addDeviceInfo);
            }else {
                //设备存在就修改后加入updateList
                deviceInfo.setStatus(status);
                updateList.add(deviceInfo);
            }
        }

        //批量入库
        if(CollectionUtils.isNotEmpty(addList)){
            deviceInfoService.saveBatch(addList);
        }
        if(CollectionUtils.isNotEmpty(updateList)){
            deviceInfoService.updateBatchById(updateList);
        }
    }

    /**
     * <p>
     * 每天凌晨从第三方接口获取动态信息并更新入environment_monitorings表
     * </p>
     *
     * @author 刘嘉淋
     * @since 2021-04-08
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void updateEnvironmentMonitoringsSpecial() {
        //调用工具类发送无参get请求,并获取所有设备号和设备名称
        String body1 = restTemplateUtils.getNoParam(getSpotNameUrl);
        JSONArray objects1 = parseArray(body1);
        //用于批量操作的集合
        List<EnvironmentMonitoring> addList = new ArrayList<>();
        List<EnvironmentMonitoring> updateList = new ArrayList<>();
        //遍历json数组，获取每个对象进行组装数据
        for (Object object : objects1) {
            //获得当前设备当前测点当前测点名称下的所有属性
            JSONObject mr = JSON.parseObject(object.toString());
            String code = mr.get("device_no").toString();
            String spot_nm = mr.get("spot_nm").toString();
            int spot_no = Integer.parseInt(mr.get("spot_no").toString());
            String spot_type = mr.get("spot_type").toString();
            String spot_Info="";
            String value ="";
            String state ="";
            if("A".equals(spot_type)){
                //调用工具类发送带参get请求，获得该设备号对应所有测点模拟量的值及状态
                Map<String, String> map = new HashMap<>();
                map.put("equipno",code);
                spot_Info = restTemplateUtils.getParam(getAllAnalogSpotValueUrl, map);
                JSONArray array = parseArray(spot_Info);
                for (Object o : array) {
                    JSONObject jsonObject = JSON.parseObject(o.toString());
                    int spot = Integer.parseInt(jsonObject.get("Spot").toString());
                    if(spot_no==spot){
                        value = jsonObject.get("Value").toString();
                        state = jsonObject.get("State").toString();
                        if("0".equals(state)){
                            state=EnvironmentMonitoringEnum.STATUS_ANALOG_NORMAL.getMsg();
                        }else if("1".equals(state)){
                            state=EnvironmentMonitoringEnum.STATUS_ANALOG_LOW.getMsg();
                        } else if("2".equals(state)){
                            state=EnvironmentMonitoringEnum.STATUS_ANALOG_HIGH.getMsg();
                        }else if("3".equals(state)){
                            state=EnvironmentMonitoringEnum.STATUS_ANALOG_INTERRUPT.getMsg();
                        }else{
                            state=EnvironmentMonitoringEnum.STATUS_ANALOG_NONE.getMsg();
                        }
                    }
                }
                spot_type=EnvironmentMonitoringEnum.SPOT_TYPE_A.getMsg();
            }else if("D".equals(spot_type)){
                //调用工具类发送带参get请求，获得该设备号对应所有测点数字量的值及状态
                Map<String, String> map = new HashMap<>();
                map.put("Equipno",code);
                spot_Info = restTemplateUtils.getParam(getAllDigitSpotValueUrl, map);
                JSONArray array = parseArray(spot_Info);
                for (Object o : array) {
                    JSONObject jsonObject = JSON.parseObject(o.toString());
                    int spot = Integer.parseInt(jsonObject.get("Spot").toString());
                    if(spot_no==spot){
                        value = jsonObject.get("Value").toString();
                        state = jsonObject.get("State").toString();
                        if("0".equals(state)){
                            state=EnvironmentMonitoringEnum.status_NORMAL.getMsg();
                        }else if("1".equals(state)){
                            state=EnvironmentMonitoringEnum.status_ALARM.getMsg();
                        }
                    }
                }
                spot_type=EnvironmentMonitoringEnum.SPOT_TYPE_D.getMsg();
            }

            //条件过滤(根据设备号、测点号和测点名称才能得到唯一一条数据):判断新增还是修改
            QueryWrapper<EnvironmentMonitoring> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", code);
            queryWrapper.eq("spot_no",spot_no);
            queryWrapper.eq("spot_nm",spot_nm);
            EnvironmentMonitoring environmentMonitoring = environmentMonitoringMapper.selectOne(queryWrapper);
            if(Objects.isNull(environmentMonitoring)){
                //不存在就新增加入addList
                EnvironmentMonitoring em1 = new EnvironmentMonitoring();
                em1.setCode(code);
                em1.setSpotNo(spot_no);
                em1.setSpotNm(spot_nm);
                em1.setSpotType(spot_type);
                em1.setSpotValue(value);
                em1.setSpotState(state);
                addList.add(em1);
            }else {
                //存在就修改后加入updateList
                environmentMonitoring.setSpotType(spot_type);
                environmentMonitoring.setSpotValue(value);
                environmentMonitoring.setSpotState(state);
                updateList.add(environmentMonitoring);
            }
        }

        //批量入库
        if(CollectionUtils.isNotEmpty(addList)){
            environmentMonitoringService.saveBatch(addList);
        }
        if(CollectionUtils.isNotEmpty(updateList)){
            environmentMonitoringService.updateBatchById(updateList);
        }
    }

    @Override
    public IPage<EnvironmentMonitoringDTO> queryEnvironmentMonitorings(EnvironmentMonitoringQueryDTO environmentMonitoringQueryDTO) {
        //分页查询device_info:获得满足条件的所有静态字段信息
        PageQuery.pageParamCheck(environmentMonitoringQueryDTO.getPageNo(),environmentMonitoringQueryDTO.getPageSize());
        Page<DeviceInfo> page = new Page<DeviceInfo>(environmentMonitoringQueryDTO.getPageNo(), environmentMonitoringQueryDTO.getPageSize(), 0);
        QueryWrapper<DeviceInfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(environmentMonitoringQueryDTO.getNewname())){
            queryWrapper.like("newname",environmentMonitoringQueryDTO.getNewname());
        }
        if(StringUtils.isNotEmpty(environmentMonitoringQueryDTO.getBuilding_name())){
            queryWrapper.like("building_name",environmentMonitoringQueryDTO.getBuilding_name());
        }
        if(StringUtils.isNotEmpty(environmentMonitoringQueryDTO.getFloor_name())){
            queryWrapper.like("floor_name",environmentMonitoringQueryDTO.getFloor_name());
        }
        if(StringUtils.isNotEmpty(environmentMonitoringQueryDTO.getStatus())){
            queryWrapper.like("status",environmentMonitoringQueryDTO.getStatus());
        }
        queryWrapper.eq("systemname",SystemEnum.ENVIRONMENTAL.getMsg());
        IPage<DeviceInfo> listPage = deviceInfoMapper.selectPage(page,queryWrapper);

        //遍历device_info:将它的属性和对应的测点信息赋给EnvironmentMonitoringDTO
        List<DeviceInfo> list = listPage.getRecords();
        ArrayList<EnvironmentMonitoringDTO> emDTOList = new ArrayList<>();
        for (DeviceInfo deviceInfo : list) {
            //组装动静态字段信息
            EnvironmentMonitoringDTO emDTO = new EnvironmentMonitoringDTO();
            String code = deviceInfo.getCode();
            //将静态信息批量赋给EnvironmentMonitoringDTO
            BeanUtils.copyProperties(deviceInfo,emDTO);
            //获取满足条件的动态字段信息即测点信息并组装
            QueryWrapper<EnvironmentMonitoring> emQueryWrapper = new QueryWrapper<>();
            emQueryWrapper.eq("code",code);
            List<EnvironmentMonitoring> emList = environmentMonitoringMapper.selectList(emQueryWrapper);
            emDTO.setSpotInfoList(emList);
            emDTOList.add(emDTO);
        }

        //分页从DeviceInfo相关的转换为EnvironmentMonitoringDTO相关的
        IPage<EnvironmentMonitoringDTO> newIpage = page.convert(DeviceInfo -> Convert.copyProperties(DeviceInfo,EnvironmentMonitoringDTO.class));
        newIpage.setRecords(emDTOList);
        return newIpage;
    }

}
