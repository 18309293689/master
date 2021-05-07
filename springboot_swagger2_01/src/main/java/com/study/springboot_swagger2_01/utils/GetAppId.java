package com.study.springboot_swagger2_01.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 默认appId
 *
 * @author Lhw
 * @since 2020/10/22
 */

@Component
public class GetAppId {

    public String isDefaultAppId(String appId){

        if (StringUtils.isBlank(appId)){
            return PropertiesReader.getPropertiesByKey("appId.properties","appId");
        }

        return  appId;
    }

}
