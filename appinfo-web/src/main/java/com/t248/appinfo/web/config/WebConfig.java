package com.t248.appinfo.web.config;


import com.t248.appinfo.web.intercepter.BackendIntercepter;
import com.t248.appinfo.web.intercepter.DevIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {
    //开发者用户权限用拦截器来把控
    @Bean
    public DevIntercepter devIntercepter(){
        return new DevIntercepter();
    }


    @Bean
    public BackendIntercepter backendIntercepter(){return new BackendIntercepter();}

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(devIntercepter()).addPathPatterns("/dev/**");
        registry.addInterceptor(backendIntercepter()).addPathPatterns("/backend/**");
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:/D:/fileupload/");
        registry.addResourceHandler("/download/**").addResourceLocations("file:/D:/filedownload");

    }
}
