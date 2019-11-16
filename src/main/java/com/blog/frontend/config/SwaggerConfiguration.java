package com.blog.frontend.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
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
 * Swagger的配置类
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfiguration {

    private final static String myName = "JerryGao";
    private final static String myHost = "www.jerry-gao.com";
    private final static String myEmail = "415309574@qq.com";

    private final static String apiTitle = "个人博客前台接口";
    private final static String apiDesc = "个人博客前台部分的前后端交互接口说明";
    private final static String apiVersion = "1.0.0";

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(myName, myHost, myEmail);
        return new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDesc)
                .contact(contact)
                .version(apiVersion)
                .build();
    }
}
