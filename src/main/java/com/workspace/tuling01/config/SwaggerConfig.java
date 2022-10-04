package com.workspace.tuling01.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.workspace.tuLing.mall.modules.*.mapper")
                .title("后台管理xit")
                .description("tuling_mall项目后台管理接口文档")
                .contactName("xushu")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
