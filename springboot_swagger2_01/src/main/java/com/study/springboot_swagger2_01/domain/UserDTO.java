package com.study.springboot_swagger2_01.domain;

import com.study.springboot_swagger2_01.utils.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 用于user分页条件查询的对象
 * </p>
 *
 * @author 刘嘉淋
 * @since ${DATE}
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "user分页条件查询的对象",description = "user分页条件查询的对象")
public class UserDTO extends PageQuery {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

}
