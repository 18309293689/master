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
 * 楼栋管理表   响应参数对象
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:47:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BuildingsVO对象",description = "楼栋管理表  响应参数对象")
public class BuildingsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 建筑名称
     */
    @ApiModelProperty(value = "建筑名称")
    private String name;

    /**
     * 地上层数
     */
    @ApiModelProperty(value = "地上层数")
    private Integer upNumber;

    /**
     * 地下层数
     */
    @ApiModelProperty(value = "地下层数")
    private Integer downNumber;

    /**
     * 楼层单位
     */
    @ApiModelProperty(value = "楼层单位")
    private String floorUnit;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String mark;


}
