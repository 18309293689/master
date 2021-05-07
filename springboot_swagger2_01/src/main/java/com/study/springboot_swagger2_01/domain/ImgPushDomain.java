package com.study.springboot_swagger2_01.domain;/**
 * @author xiey
 * @date 2020/7/10 11:36
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiey
 * @date 2020/7/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("图片上传请求参数")
public class ImgPushDomain {

    @ApiModelProperty("项目名称-也是图片文件夹名称")
    private String projectName;

    @ApiModelProperty("图片实体,使用base64编码")
    private String img;

}
