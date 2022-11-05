package com.ql.blog.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置
 *
 * @author wanqiuli
 * @date 2022/8/4 21:12
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ql.blog.interaction.web"))
                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("QiuLi Wan", "https://wautumnli.github.io", "wautumnli@163.com");
        return new ApiInfoBuilder()
                .title("API文档接口")
                .description("api接口文档")
                .version("1.0")
                .contact(contact)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
