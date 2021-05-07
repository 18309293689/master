package com.study.springboot_swagger2_01.enums;

public enum SystemEnum {

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
    ;

    private String code;
    private String msg;

    SystemEnum(String code, String msg) {
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
