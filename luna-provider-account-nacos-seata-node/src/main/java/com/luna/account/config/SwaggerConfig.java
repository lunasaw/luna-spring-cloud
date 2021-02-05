package com.luna.account.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author luna_mac
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 定义分隔符
    private static final String SPLITOR = ";";

    @Bean
    public Docket createRestApi(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        // 通过environment.acceptsProfiles()判断是否处于需要开启Swagger的环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
            // DocumentationType.SWAGGER_2 固定的，代表swagger2
            // .groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
            .apiInfo(apiInfo())
            // 用于生成API信息
            .select()
            // select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
            .apis(RequestHandlerSelectors.basePackage("com.luna"))
            // 用于指定扫描哪个包下的接口
            .paths(PathSelectors.any())
            // 选择所有的API,如果你想只为部分API生成文档，可以配置这里
            .build();
    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     *
     * @return
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("luna", "https://www.isczy.tk/blog", "luna_nov@163.com");
        return new ApiInfo("luna's SwaggerAPI doc",
            "自己选的路，怎么也要走完", "1.0",
            "https://www.isczy.tk/blog", contact, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());

    }
}
