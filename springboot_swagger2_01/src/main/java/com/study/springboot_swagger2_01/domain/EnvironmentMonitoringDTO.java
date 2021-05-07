package com.study.springboot_swagger2_01.domain;

import com.study.springboot_swagger2_01.pojo.EnvironmentMonitoring;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 环境监控数据组装展示对象:数据来源于device_info表和environment_monitoring表
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021/4/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "EnvironmentMonitoring数据组装展示对象",description = "环境监控数据组装展示")
public class EnvironmentMonitoringDTO implements Serializable {

    @ApiModelProperty(value = "设备码")
    private String code;

    @ApiModelProperty(value = "设备名称")
    private String newname;

    @ApiModelProperty(value = "楼栋号")
    private String buildingName;

    @ApiModelProperty(value = "楼层号")
    private String floorName;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "测点信息list")
    private List<EnvironmentMonitoring> spotInfoList;


}
