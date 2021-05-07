package com.study.springboot_swagger2_01.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * <p>
 * 人脸布控告警
 * </p>
 * @description: 人脸布控告警
 * @author: Liu Jialin
 * @date: Created in 2021-04-17 11:17:57
 * @copyright: Copyright (c) 2021
 */
@Data
@ApiModel(description = "FacealarmHistoryDTO")
public class FacealarmHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分页编号")
    private Integer pageNumber;

    @ApiModelProperty(value = "分页尺寸")
    private Integer pageSize;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer fid;
    /**
     * 人脸名单编号
     */
    @ApiModelProperty(value = "人脸名单编号")
    private String faceId;
    /**
     * 证件类型:0是身份证,1是驾驶证,2是其他证件号
     */
    @ApiModelProperty(value = "证件类型:0是身份证,1是驾驶证,2是其他证件号")
    private String faceIdtype;
    /**
     * 证件ID
     */
    @ApiModelProperty(value = "证件ID")
    private String faceCardid;
    /**
     * 报警类型：1是黑名单报警，2是白名单报警
     */
    @ApiModelProperty(value = "报警类型：1是黑名单报警，2是白名单报警")
    private String alarmType;
    /**
     * 性别：0是女，1是男，98是未知
     */
    @ApiModelProperty(value = "性别：0是女，1是男，98是未知")
    private String faceGender;
    /**
     * 布控列管类型
     */
    @ApiModelProperty(value = "布控列管类型")
    private String guardType;
    /**
     * 人脸抓拍时间（yyyy-MM-dd）
     */
    @ApiModelProperty(value = "人脸抓拍时间（yyyy-MM-dd）")
    private String snapTime;
    /**
     * 人脸抓拍图片url
     */
    @ApiModelProperty(value = "人脸抓拍图片url")
    private String snapPicurl;
    /**
     * 人脸相似度
     */
    @ApiModelProperty(value = "人脸相似度")
    private String faceSamevalue;
    /**
     * 报警时间（yyyy-MM-dd）
     */
    @ApiModelProperty(value = "报警时间（yyyy-MM-dd）")
    private String alarmTime;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String faceName;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private String faceAge;
    /**
     * 人脸在图片中位置
     */
    @ApiModelProperty(value = "人脸在图片中位置")
    private String facePlaction;
    /**
     * 布控列管原因
     */
    @ApiModelProperty(value = "布控列管原因")
    private String guardReason;
    /**
     * 人脸国籍
     */
    @ApiModelProperty(value = "人脸国籍")
    private String faceCountry;
    /**
     * 出生日期（yyyy-MM-dd）
     */
    @ApiModelProperty(value = "出生日期（yyyy-MM-dd）")
    private String faceBirthday;
    /**
     * 名单库人脸url
     */
    @ApiModelProperty(value = "名单库人脸url")
    private String facePicurl;
    /**
     * 产生报警的布控ID
     */
    @ApiModelProperty(value = "产生报警的布控ID")
    private String guardtaskId;
    /**
     * 人脸城市
     */
    @ApiModelProperty(value = "人脸城市")
    private String faceCity;
    /**
     * 人脸抓拍机编码
     */
    @ApiModelProperty(value = "人脸抓拍机编码")
    private String facecamCode;
    /**
     * 人脸抓拍小图片url
     */
    @ApiModelProperty(value = "人脸抓拍小图片url")
    private String snapfacePicurl;
    /**
     * 人脸省份
     */
    @ApiModelProperty(value = "人脸省份")
    private String faceProvince;
    /**
     * 布控的对比库
     */
    @ApiModelProperty(value = "布控的对比库")
    private String facelibId;
    /**
     * 人脸报警ID
     */
    @ApiModelProperty(value = "人脸报警ID")
    private String id;
    /**
     * 人脸抓拍图片ID
     */
    @ApiModelProperty(value = "人脸抓拍图片ID")
    private String snappicId;

}
