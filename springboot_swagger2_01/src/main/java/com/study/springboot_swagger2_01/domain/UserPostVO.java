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
 * 用户post表   响应参数对象
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserPostVO对象",description = "用户post表  响应参数对象")
public class UserPostVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户岗位ID
     */
    @ApiModelProperty(value = "用户岗位ID")
    private Integer id;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String name;


}
