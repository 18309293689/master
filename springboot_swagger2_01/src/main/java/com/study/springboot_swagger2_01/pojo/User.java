package com.study.springboot_swagger2_01.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.springboot_swagger2_01.utils.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value = "用户对象",description = "用户表")
@Component
public class User implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

}
