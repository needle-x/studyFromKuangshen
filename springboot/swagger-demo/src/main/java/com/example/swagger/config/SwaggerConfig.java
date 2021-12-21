package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  // 开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //获取项目的环境
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("needle")
                //enable是否启动Swagger，如果为false，则Swagger不能在浏览器中使用
                .enable(flag)
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage: 指定要扫描的包
                //any(): 扫描全部
                //none(): 不扫描
                //withClassAnnotation: 扫描类上的注解，参数是一个注解的反射对象  GetController.class
                //withMethodAnnotation: 扫描方法上的注解  RestController.class
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                //过滤路径
                //.paths(PathSelectors.ant("/needle/**"))
                .build();
    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("needle", "https://blog.csdn.net/qq_43838177?spm=1001.2101.3001.5343", "1472233788@qq.com");
        return new ApiInfo("needle的SwaggerApi文档",
                "It's now!",
                "v1.0",
                "https://blog.csdn.net/qq_43838177?spm=1001.2101.3001.5343",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
