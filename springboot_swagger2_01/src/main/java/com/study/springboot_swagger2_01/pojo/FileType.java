package com.study.springboot_swagger2_01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description:
 * @author tony.kroos
 * @since 2020-09-01
 */
@ApiModel(value ="文件管理")
@Data
@EqualsAndHashCode(callSuper = false)
public class FileType extends Model<FileType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    @ApiModelProperty(value = "主键",name="id",example="1")
    private Integer id;
    
    @TableField("file_name")
    @ApiModelProperty(value = "文件名称",name="fileName",example="文件名称")
    private String fileName;
    
    @TableField("type")
    @ApiModelProperty(value = "文件类型",name="type",example="文件类型")
    private String type;
    
    @TableField("path")
    @ApiModelProperty(value = "存储地址",name="path",example="存储地址")
    private String path;

    @TableField("create_time")
    @ApiModelProperty(value = "时间",name="createTime",example="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("create_by")
    private String createBy;

    @TableField("app_id")
    private String appId;

    
	@Override
	protected Serializable pkVal() {
	     return this.id;
	}
}
