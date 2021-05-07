package com.study.springboot_swagger2_01.pojo.delConfig;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Author: lilong
 */
@Data
@EqualsAndHashCode
public class TableConfig {

    @ApiModelProperty(value = "时间对应字段名称")
    private String timeColName;
    /**
     * 时间字段描述，仅用作展示观看，不参加业务处理
     * varchar 2021-04-01 10:16:30
     * timestamp 1615602110
     */
    @ApiModelProperty(value = "时间对应字段举例")
    private String timeColDesc;
    /**
     * 字段类型
     * 支持 varchar,timestamp
     */
    @ApiModelProperty(value = "时间对应字段类型")
    private String timeColType;
    /**
     * 数据保留时间
     * hour/day/month/year
     */
    @ApiModelProperty(value = "数据保留时间单位")
    private String remianTimeUnit;
    @ApiModelProperty(value = "数据保留时间")
    private int remainTime;
    @ApiModelProperty(value = "需要删除的表名")
    private String tableName;
}