package com.study.springboot_swagger2_01.enums;

public enum EnvironmentMonitoringEnum {

    status_NORMAL("status_NORMAL","正常"),
    status_ALARM("status_ALARM","告警"),
    SPOT_TYPE_A("SPOT_TYPE_A","模拟"),
    SPOT_TYPE_D("SPOT_TYPE_D","数字"),
    STATUS_ANALOG_NORMAL("STATUS_ANALOG_NORMAL","正常"),
    STATUS_ANALOG_LOW("STATUS_ANALOG_LOW","过低"),
    STATUS_ANALOG_HIGH("STATUS_ANALOG_HIGH","过高"),
    STATUS_ANALOG_INTERRUPT("STATUS_ANALOG_INTERRUPT","通讯中断"),
    STATUS_ANALOG_NONE("STATUS_ANALOG_NONE","还未取到值"),
    ;

    private String code;
    private String msg;

    EnvironmentMonitoringEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
