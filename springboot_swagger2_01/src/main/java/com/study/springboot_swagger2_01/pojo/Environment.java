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
 * 环境表 对象
 * </p>
 *
 * @author Li Jialin
 * @since 2021-04-21 11:17:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Environment对象",description = "环境表 对象")
@TableName("environment")
public class Environment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
