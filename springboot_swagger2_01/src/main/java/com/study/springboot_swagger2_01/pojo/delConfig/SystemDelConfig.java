package com.study.springboot_swagger2_01.pojo.delConfig;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

/**
 * @Description:
 * @Author: lilong
 */
@Data
@EqualsAndHashCode
public class SystemDelConfig {
    @ApiModelProperty(value = "需要删除的表配置")
    private List<TableConfig> tableConfigs;
    @ApiModelProperty(value = "系统名称")
    private String systemName;
}
