package com.study.springboot_swagger2_01.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * <p>
 * 环境表  响应参数对象
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EnvironmentVO对象",description = "环境表 响应参数对象")
public class EnvironmentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 设备码
     */
    @ApiModelProperty(value = "设备码")
    private String code;

    /**
     * 测点号
     */
    @ApiModelProperty(value = "测点号")
    private Integer spotNo;

    /**
     * 测定名
     */
    @ApiModelProperty(value = "测定名")
    private String spotNm;

    /**
     * 测点类型
     */
    @ApiModelProperty(value = "测点类型")
    private String spotType;

    /**
     * 测点值
     */
    @ApiModelProperty(value = "测点值")
    private String spotValue;

    /**
     * 测点状态
     */
    @ApiModelProperty(value = "测点状态")
    private String spotState;


}
