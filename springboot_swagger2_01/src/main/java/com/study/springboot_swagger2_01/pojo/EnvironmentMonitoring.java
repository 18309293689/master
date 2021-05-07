package com.study.springboot_swagger2_01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 环境监控表
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021/4/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("environment_monitoring")
@ApiModel(value = "EnvironmentMonitoring对象",description = "环境监控表")
public class EnvironmentMonitoring implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备码")
    private String code;

    @ApiModelProperty(value = "测点号")
    private Integer spotNo;

    @ApiModelProperty(value = "测点名称")
    private String spotNm;

    @ApiModelProperty(value = "测点类型")
    private String spotType;

    @ApiModelProperty(value = "测点值")
    private String spotValue;

    @ApiModelProperty(value = "测点状态")
    private String spotState;

}
