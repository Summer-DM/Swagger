package com.summer.swagger2_demo.config;

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
 * @program: swagger2-demo
 * @description: swagger2配置类
 * @author: Summer-DM
 * @create: 2020年08月26日
 **/
@Configuration
@EnableSwagger2
public class swagger2Config {

    @Bean
    public Docket buildDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.summer.swagger2_demo.web"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("Summer-DM","https://blog.csdn.net/yy_wzh","626749077@qq.com");
        return  new ApiInfoBuilder()
                .title("springboot结合swagger2构建Restful API") //标题
                .description("This is a swagger2 demo!") //描述(小标题)
                .termsOfServiceUrl("www.baidu.com") //网站链接
                .contact(contact) //链接显示的文字
                .version("0.0.1") //版本
                .build();

//        ApiInfo apiInfo = new ApiInfo("springboot结合swagger2构建Restful API",//大标题
//                "This is a swagger2 demo!" ,//小标题
//                ""0.0.1",//版本
//                "www.baidu.com",
//                new Contact("叶湘伦", "", ""),// 作者
//                "",//链接显示文字
//                ""//网站链接
//        );
//        return apiInfo;

    }
}