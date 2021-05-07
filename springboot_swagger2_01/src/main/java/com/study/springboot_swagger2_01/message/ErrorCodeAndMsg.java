package com.study.springboot_swagger2_01.message;

public enum ErrorCodeAndMsg {
    SYSTEM_ERROR_CODE_MESSAGE("000000","系统故障，请稍后重试或联系管理员"),
    IMG_NOT_EXIST("500001","图片不存在"),
    IMG_PUSH_ERROR("500002","图片上传失败"),
    FILE_NOT_EXISTENCE("-510301","请添加上传文件"),
    FILE_UPLOAD_FAILED("-510302","文件上传失败"),
    FILE_TYPE("-510303","请选择文件类型"),
    FILE_TYPE_NOT_SUPPORTED("-510304","该文件不是系统支持的类型"),
    APP_NAME_ISNOT_NULL("-510305","APP名称不能为空"),
    APP_CODE_ISNOT_NUMBER("-510306","APPCODE只能是数字"),
    APP_DOWNLOAD_PATH_ISNOT_NULL("-510307","应用下载地址不能为空"),
    APP_UPDATE_CONTENT_ISNOT_NULL("-510308","版本迭代内容为必填项"),
    APP_VERSION_ISNOT_NULL("-510309","应用版本号不能为空"),
    APP_TYPE_ISNOT_NULL("-510310","应用类型不能为空"),
    APP_TYPE_ISNOT_MATCHING("-510311","类型不匹配"),
    APP_VERSION_ERROR("-510312","版本号填写错误"),
    APP_VERSION_LOW("-510312","版本号低于系统版本号，不予发布"),
    APPID_ISNOT_NULL("-510313","APPID不能为空"),
    NAME_ISNOT_NULL("-510314","上传者不能为空"),
    APP_UPDATE_TYPE("-510315","1:强制升级，0：非强制升级"),
    SORT_IS_NOT_SUPPORT("-520034","排序方式不支持"),
    PATH_IS_NOT_CHINESE("900001", "路径不能为中文"),
    FILE_NAME_IS_NOT_CHINESE("900002","文件名不能为中文"),

    BUILDING_IS_EXIST("100001", "建筑已经存在"),
    BUILDING_ISNOT_EXIST("100001", "建筑不存在"),
    BUILDING_NAME_NOT_NULL("100002", "建筑名不能为空"),
    BUILDING_UP_NUMBER_NOT_NULL("100003", "建筑上层数不能为空"),
    BUILDING_DOWN_NUMBER_NOT_NULL("100004", "建筑地下层数不能为空"),
    BUILDING_ID_NOT_NULL("100005", "建筑ID不能为空"),
    BUILDING_NAME_IS_REPETITION("100006", "建筑名不能为重复"),

    ALARM_NAME_IS_EXIST("200001", "警报名已经存在"),
    ALARM_ID_NOT_NULL("200002", "警报ID不能为空"),
    ALARM_NAME_NOT_NULL("200003", "警报名称不能为空"),
    ALARM_LEVEL_NOT_NULL("200004", "警报等级不能为空"),

    DEPARTMENT_IS_EXIST("300001", "科室已经存在"),
    DEPARTMENT_NAME_NOT_NULL("300002", "科室名不能为空"),
    DEPARTMENT_ID_NOT_NULL("300003", "科室ID不能为空"),


    PRODUCER_NAME_NOT_NULL("400001", "制造商名称不能为空"),
    PRODUCER_ID_NOT_NULL("400001", "制造商ID不能为空"),
    PRODUCER_IS_EXIST("400001", "制造商已存在"),


    SUPPLIER_NOT_NULL("500001", "新增供应商不能为空"),
    SUPPLIER_IS_EXIST("500001", "新增供应商重复"),
    SUPPLIER_NAME_NOT_NULL("500001", "供应商名称不能为空"),
    SUPPLIER_ENGLISHNAME_NOT_NULL("500001", "供应商英文名称不能为空"),
    SUPPLIER_URL_NOT_NULL("500001", "供应商网址不能为空"),
    SUPPLIER_SUPPLIERPRINCIPAL_NOT_NULL("500001", "供应商负责人不能为空"),
    SUPPLIER_SUPPLIERTEL_NOT_NULL("500001", "供应商负责人联系方式不能为空"),
    SUPPLIER_PRODUCER_NOT_NULL("500001", "所属制造商不能为空"),
    SUPPLIER_EQUIPMENTTYPE_NOT_NULL("500001", "设备类型不能为空"),
    SUPPLIER_EQUIPMENTPRINCIPAL_NOT_NULL("500001", "设备负责人不能为空"),
    SUPPLIER_EQUIPMENTTEL_NOT_NULL("500001", "设备负责人联系方式不能为空"),

    SCENE_NOT_NULL("500002", "新增联动场景不能为空"),
    SCENE_ID_NOT_NULL("500002", "联动场景ID不能为空"),
    SCENE_IS_EXIST("500002", "新增联动场景重复"),
    SCENE_SCENENAME_NOT_NULL("500002", "场景名称不能为空"),
    SCENE_SCENEASSOCIATION_NOT_NULL("500002", "场景关联不能为空"),
    SCENE_SCENEIMAGE_NOT_NULL("500002", "场景图片不能为空"),
    SCENE_STARTTIME_NOT_NULL("500002", "生效开始时间不能为空"),
    SCENE_ENDTIME_NOT_NULL("500002", "生效结束时间不能为空"),
    SCENE_TRIGGERS_NOT_NULL("500002", "触发条件不能为空"),
    SCENE_OPENTYPE_NOT_NULL("500002", "开放类型不能为空"),
    SCENE_OPENTIME_NOT_NULL("500002", "开放时间不能为空"),


    DEVICE_NOT_EXIST("600004", "设备名称不存在"),
    DEVICE_IS_EXIST("600001", "该设备已存在"),
    DEVICE_ID_NOT_NULL("600002", "设备ID不能为空"),
    DEVICE_CODE_NOT_NULL("600003", "设备编码不能为空"),
    DEVICE_NAME_NOT_NULL("600004", "设备名称不能为空"),
    DEVICE_SYSTEMNAME_NOT_NULL("600005", "设备名称不能为空"),
    DEVICE_MODEL_NOT_NULL("600006", "设备型号不能为空"),
    DEVICE_IMAGE_NOT_NULL("600007", "设备图像不能为空"),
    DEVICE_MANUFACTURER_NOT_NULL("600009", "设备制造商不能为空"),
    DEVICE_SUPPLIER_NOT_NULL("600010", "设备供应商不能为空"),
    DEVICE_BUILDING_ID_NOT_NULL("600011", "设备所在建筑不能为空"),

    DEVICE_LONGITUDE_NOT_NULL("600014", "设备电子图横坐标不能为空"),
    DEVICE_LATITUDE_NOT_NULL("600015", "设备电子图纵坐标不能为空"),


    FACEDB_NAME_NOT_NULL("700001", "人脸库名称不能为空"),
    FACEDB_TYPE_NOT_NULL("700002", "人脸库类型不能为空"),
    FACEDB_CODE_NOT_NULL("700003", "人脸库编码不能为空"),


    ENERGY_BUILDING_ID_NOT_NULL("700003", "建筑ID不能为空"),
    ENERGY_CODE_NOT_NULL("700003", "设备类型不能为空"),
    ENERGY_TYPE_NOT_NULL("700003", "基础数据类型不能为空"),
    ENERGY_CODE_ERROR("700003", "设备类型仅支持电:01000/水:02000"),
    ENERGY_IS_NOT_EXIST("700003", "设备不存在"),
    ENERGY_ID_NOT_NULL("700003", "设备ID不能为空"),
    ENERGY_BUILDING_SON_ID_NOT_NULL("700003", "回路ID不能为空"),
    ENERGY_METER_START_TIME_NOT_NULL("700003", "抄表开始时间不能为空"),
    ENERGY_METER_END_TIME_NOT_NULL("700003", "抄表结束时间不能为空"),
    ENERGY_METER_INFO_NOT_EXIST("700003", "抄表数据不存在"),
    ENERGY_DATA_NOT_EXIST("700003", "无数据,请检查"),

    PERSONINFO_IDTYPE_NOT_NULL("800001", "证件类型不能为空"),
    PERSONINFO_CARDID_NOT_NULL("800002", "证件号不能为空"),
    PERSONI_NNAME_NOT_NULL("800003", "姓名不能为空"),
    PERSONINFO_BIRTHDAY_NOT_NULL("800004", "出生年月不能为空"),
    PERSONINFO_GUARDTYPE_NOT_NULL("800005", "布控管理类型不能为空"),
    PERSONINFO_GUARDREASON_NOT_NULL("800006", "布控管理原因不能为空"),
    PERSONINFO_IS_EXISTED("800007", "人员信息已存在"),

    USER_NAME_IS_NOT_NULL("800030", "用户姓名不可为空"),
    USER_SEX_IS_NOT_NULL("800031", "用户性别不可为空"),
    USER_DEPART_IS_NOT_NULL("800031", "用户部门不可为空"),
    USER_POST_IS_NOT_NULL("800032", "用户岗位不可为空"),
    USER_LOGIN_IS_NOT_NULL("800033", "用户账号不可为空"),
    USER_PASS_IS_NOT_NULL("800034", "用户密码不可为空"),
    USER_REPEAT_PASS_IS_NOT_NULL("800034", "重复密码不可为空"),
    USER_TWO_PASS_IS_NOT_MATCH("800034", "两次密码不一致"),
    USER_TEL_IS_NOT_NULL("800035", "用户手机号不可为空"),
    USER_STAFF_ID_IS_NOT_NULL("800036", "员工编号不可为空"),
    USER_ADMIN_AREA_IS_NOT_NULL("800037", "用户管辖区域不可为空"),
    USER_IS_NOT_EXIST("800037", "用户不存在"),
    USER_ROOT_IS_NOT_DELETE("800037", "超级管理员不予许删除"),
    USER_LOGIN_IS_EXIST("800037", "账号已存在"),
    USER_ID_IS_NOT_NULL("800030", "用户ID不可为空"),
    USER_OLD_PASS_IS_NOT_NULL("800034", "旧密码不可为空"),
    USER_OLD_PASS_IS_ERROR("800034", "旧密码错误"),
    USER_LOGIN_OR_PASS_IS_ERROR("800034", "账号名或密码错误"),
    USER_POST_ID_IS_NOT_NULL("800032", "岗位ID不可为空"),
    USER_POST_IS_NOT_EXIST("800032", "岗位不存在"),
    USER_POST_IS_EXIST("800032", "岗位名称已存在"),
    USER_DEPART_IS_EXIST("800032", "部门名称已存在"),
    USER_PARENT_DEPART_IS_NOT_EXIST("800032", "父部门不存在"),
    USER_DEPART_IS_NOT_EXIST("800032", "部门不存在"),
    USER_SON_DEPART_IS_EXIST("800032", "存在子部门不允许删除"),
    USER_KEY_ISNOT_NULL("800049", "用户主键不能为空"),
    USER_TOKEN_ISNOT_NULL("800049", "用户TOKEN不能为空"),
    EXPIRED_TOKEN("0000401", "token已失效"),
    PLEASE_AGAIN_LOGIN("0000401", "登录过期,请重新登录"),

    PAGE_NO_IS_NOT_NULL("900001", "当前页不能为空"),
    PAGE_SIZE_IS_NOT_NULL("900002", "每页记录数不能为空"),
    PAGE_NO_LESS_ZERO("900003", "当前页不能小于等于0"),
    PAGE_SIZE_LESS_ZERO("900004", "每页记录数不能小于等于0"),

    CREATEOR_ISNOT_NULL("800019", "创建者必须填写"),
    MENU_ISNOT_NULL("800064", "菜单名不能为空"),
    MENU_IS_EXISTENCE("800065", "菜单名重复，不能提交"),
    AUTHOR_NAME_LENGTH("800058", "权限名称长度必须在8~12之间"),
    MENU_NAME_ISNOT_NULL("800059", "URL不能为空"),
    UPDATOR_ISNOT_NULL("800022", "修改人信息必须填写"),
    MENU_KEY_ISNOT_NULL("800067", "菜单主键不能为空"),
    MENU_KEY_ISNOT_EXISTENCE("800068", "菜单不存在，不允许修改，请创建"),

    ROLE_KEY_ISNOT_NULL("800028", "角色主键不能为空"),
    ROLE_NAME_ISNOT_NULL("800025", "角色名不能为空"),
    ROLE_INFO_ISNOT_NULL("800026", "角色信息不能为空"),
    ROLE_NAME_IS_EXISTENCE("800027", "角色名不能重复"),
    ROLE_ISNOT_EXISTENCE("800029", "角色不存在，不允许修改"),
    ROLE_ID_ISNOT_EXIST("800076", "角色ID不存在"),
    ROLE_IS_BINDING_USER("800085", "角色已绑定用户,无法删除"),

    BROADCAST_TTS_TEXT_ISNOT_NULL("800085", "广播语音播报文本不能为空"),
    BROADCAST_TTS_END_POINT_GROUP_ISNOT_NULL("800086", "广播语音播报执行终端不能为空"),
    BROADCAST_TTS_TEXT_ERROR("800087", "广播语音播报执行错误"),

    ROOM_NAME_IS_NOT_NULL("800088", "房间名称不能为空"),
    ROOM_NUMBER_IS_NOT_NULL("800089", "房间号不能为空"),
    ROOM_SIZE_IS_NOT_NULL("800089", "房间大小不能为空"),
    ROOM_FLOOR_NUMBER_IS_NOT_NULL("800089", "房间所在楼层不能为空"),
    ROOM_BUILDING_ID_IS_NOT_NULL("800089", "房间所在建筑ID不能为空"),
    ROOM_DEPARTMENT_ID_IS_NOT_NULL("800089", "房间所属科室ID不能为空"),
    ROOM_FLOOR_NUMBER_IS_OVER_SIZE("800089", "房间所在楼层过大"),
    ROOM_FLOOR_NUMBER_IS_UNDER_SIZE("800089", "房间所在楼层过小"),

    DEPARTMENT_ISNOT_EXIST("800076", "科室不存在"),
    DEPARTMENT_HAS_BEEN_USED("800077","科室已被使用"),

    EVENT_TYPE_IS_EXIST("800040","事件类型已存在"),
    EVENT_TYPE_IS_NOT_EXIST("800040","事件类型不存在"),
    EVENT_TYPE_ID_IS_NOT_BLANK("800040","事件类型ID不可为空"),
    EVENT_TYPE_NAME_IS_NOT_BLANK("800040","事件类型名称不可为空"),
    EVENT_REPORTED_NAME_IS_NOT_BLANK("800040","事件上报人不可为空"),
    EVENT_SUPPLIER_IS_NOT_BLANK("800040","供应商名称不可为空"),
    EVENT_DEVICE_NAME_IS_NOT_BLANK("800040","设备名称不可为空"),
    EVENT_SYSTEM_IS_NOT_BLANK("800040","系统名称不可为空"),
    EVENT_HAPPENPLACE_IS_NOT_BLANK("800040","发生地点不可为空"),
    EVENT_INFO_IS_NOT_BLANK("800040","上报详情不可为空"),
    EVENT_IS_NOT_EXIST("800040","事件不存在"),
    EVENT_ID_IS_NOT_BLANK("800040","事件ID不可为空"),
    EVENT_DISPOSE_RESULT_IS_NOT_BLANK("800040","事件处理结果不可为空"),
    EVENT_DISPOSE_MAN_IS_NOT_BLANK("800040","事件处理人不可为空"),
    EVENT_DISPOSE_TIME_IS_NOT_BLANK("800040","事件处理时间不可为空"),
    EVENT_DISPOSE_INFO_IS_NOT_BLANK("800040","事件处理详情不可为空"),
    TIME_STATUS_ISNOT_SUPPORT("200002","时间状态仅支持DAY,MONTH,YEAR"),
    TIME_STATUS_ISNOT_NULL("200003","时间状态不可为空"),



    SUBSYSTEM_NAME_NULL("800087","子系统名称不能为空"),
    SUBSYSTEM_NAME_EXIST("800087","子系统名称已存在"),
    TROUBLESHOOTING_SUBSYSTEM_NULL("800087","设备所属子系统不能为空"),
    TROUBLESHOOTING_STATUS_NULL("800087","故障状态不能为空"),
    TROUBLESHOOTING_PROCESSOR_NULL("800087","故障处理人不能为空"),
    TROUBLESHOOTING_LEVEL_NULL("800087","故障级别不能为空"),
    TROUBLESHOOTING_TYPE_NULL("800087","故障类型不能为空"),

    TROUBLESHOOTING_PATH_NULL("800087","故障文件地址不能为空"),
    TROUBLESHOOTING_RISKANALYSIS_NULL("800087","故障风险分析不能为空"),
    TROUBLESHOOTING_REASON_NULL("800087","故障原因不能为空"),
    FILE_DOWNLOAD_FAILED("-510302","文件下载失败"),
    FILE_DOWNLOADFILE_NULL("-510303","文件名称不能为空"),
    FILE_SAVEFILE_NULL("-510303","本地路径不能为空"),

    ACTION_CLOTHES_NUM_ERROR("800088","行为系统衣服数量接口查询异常"),

    ;


    private String code;
    private String msg;

    ErrorCodeAndMsg(String code, String msg) {
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
