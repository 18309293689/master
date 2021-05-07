package com.study.springboot_swagger2_01.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * 用户post表  对象
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:56:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserPost对象",description = "用户post表  对象")
@TableName("user_post")
public class UserPost implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户岗位ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户岗位ID")
    private Integer id;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称")
    private String name;


}
