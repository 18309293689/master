package com.study.springboot_swagger2_01.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * <p>
 * 配置swagger2：只需要开发者提供一个Docket的Bean
 * @Configuration用于定义配置类,可替换xml配置文件,被注解的类中被@Bean注解的方法会被扫描用于构建bean定义，初始化Spring容器
 * @EnableSwagger2用于启用Swagger2
 * </p>
 *
 * @author 刘嘉淋
 * @since
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * <p>
     * 配置映射路径和要扫描的接口的位置，
     * 在apiInfo中，主要配置一下Swagger2文档网站的信息(如网站的title，描述，联系人，协议等)
     * </p>
     *
     * @return
     * @author 刘嘉淋
     * @since
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.study.springboot_swagger2_01.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("测试用户api")
                .description("SpringBoot整合Swagger，详细信息......")
                .version("9.0")
                .contact(new Contact("管理员","blog.csdn.net","aaa@gmail.com"))
                .license("The Apache License")
                .licenseUrl("http://www.baidu.com")
                .build();
    }
}