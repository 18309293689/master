package com.study.springboot_swagger2_01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备信息表 
 * </p>
 *
 * @author qzhao
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceInfo对象", description="设备信息表 ")
@TableName("device_info")
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id ;

    @ApiModelProperty(value = "设备编码")
    /** 设备编码 */
    private String code ;

    @ApiModelProperty(value = "设备名称")
    /** 新设备名称 */
    private String newname ;

    @ApiModelProperty(value = "系统名称")
    /** 系统名称 */
    private String systemname ;

    @ApiModelProperty(value = "设备图片")
    /** 设备图片 */
    private String picture ;

    @ApiModelProperty(value = "设备型号")
    /** 设备型号 */
    private String model ;

    @ApiModelProperty(value = "供应商id")
    /** 供应商id */
    private Integer supplier;

    @ApiModelProperty(value = "供应商名称")
    @TableField(value = "supplier_name")
    /** 供应商id */
    private String supplierName ;

    @ApiModelProperty(value = "楼栋id ")
    @TableField(value = "building_id")
    /** 安装地点-楼栋 */
    private Integer buildingId ;

    @ApiModelProperty(value = "楼栋 ")
    @TableField(value = "building_name")
    /** 安装地点-楼栋 */
    private String buildingName ;

    @ApiModelProperty(value = "楼层id ")
    @TableField(value = "floor_id")
    /** 安装地点-楼层 */
    private Integer floorId ;

    @ApiModelProperty(value = "楼层 ")
    @TableField(value = "floor_name")
    /** 安装地点-楼层 */
    private String floorName ;

    @ApiModelProperty(value = "科室")
    @TableField(value = "room_number")
    /** 安装地点-科室 */
    private String roomNumber ;

    @ApiModelProperty(value = "安装时间")
    /** 安装时间 */
    private Date createtime ;

    @ApiModelProperty(value = "状态")
    /** 状态 */
    private String status ;

    @ApiModelProperty(value = "设备类型",example="xingguo")
    /** 设备类型 */
    /**
     BROADCAST("1","广播系统"),
     MEDIA("2","多媒体会议系统"),
     INFORMATION("3","信息发布系统"),
     FIRECONTROL("4","消防自动报警系统"),
     VIDEO("5","视频监控系统"),
     INTRUSION("6","入侵报警系统"),
     ENTRANCE("7","出入口控制系统"),
     PARKING ("8","停车场系统"),
     LIGHTING("9","智能照明系统"),
     ENERGY("10","能源管理系统"),
     POWER("11","电力监控系统"),
     ENVIRONMENTAL("12","环境监控系统"),
     OPERATION("13","数字一体化手术室"),
     MEDICALBEHAVIOR("14","医疗行为管理系统"),
     VISIT("15","探视对讲系统"),
     MEDICALINTERCOM("16","医疗对讲系统"),
     LINE("17","排队叫号系统"),
     LOGISTICS("18","物流传输系统"),
     BLOOD("19","自动采血与轨道"),
     * */
    private String type ;

    /** 制造商id */
    @ApiModelProperty(value = "制造商id")
    private Integer manufacturer ;

    /** 制造商名称 */
    @ApiModelProperty(value = "制造商名称")
    @TableField(value = "manufacturer_name")
    private String manufacturerName ;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String remark ;



}
