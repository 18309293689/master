package com.study.springboot_swagger2_01.domain;

import com.study.springboot_swagger2_01.utils.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 环境监控系统查询条件对象
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021/4/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "EnvironmentMonitoring查询条件对象",description = "环境监控系统查询条件")
public class EnvironmentMonitoringQueryDTO extends PageQuery {

    @ApiModelProperty(value = "设备名称",example = "设备名称")
    private String newname;

    @ApiModelProperty(value = "楼栋号",example = "楼栋号")
    private String building_name;

    @ApiModelProperty(value = "楼层号",example = "楼层号")
    private String floor_name;

    @ApiModelProperty(value = "状态",example = "状态")
    private String status;

}
