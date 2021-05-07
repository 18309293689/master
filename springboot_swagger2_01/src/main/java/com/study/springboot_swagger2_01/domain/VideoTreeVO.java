package com.study.springboot_swagger2_01.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 相机实况所需的响应树
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021-04-01
 */
@Data
@ApiModel(value="VideoTreeVO对象", description="相机实况所需的响应树")
public class VideoTreeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所在楼栋")
    private String buildingName;

    @ApiModelProperty(value = "所在楼层")
    private String floorName;

    @ApiModelProperty(value = "设备名称")
    private String newname;

    @ApiModelProperty(value = "设备码")
    private String code;

    @ApiModelProperty(value = "list子树")
    private List<VideoTreeVO> children;

}