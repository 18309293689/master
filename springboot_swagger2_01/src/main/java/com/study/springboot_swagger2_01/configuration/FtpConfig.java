package com.study.springboot_swagger2_01.configuration;/**
 * @author xiey
 * @date 2020/7/10 11:05
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiey
 * @date 2020/7/10
 */
@ConfigurationProperties(prefix = "ftp")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FtpConfig {

    private String host;

    private int port;

    private String user;

    private String password;

}
