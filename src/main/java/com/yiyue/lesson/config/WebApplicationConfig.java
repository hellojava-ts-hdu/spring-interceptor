package com.yiyue.lesson.config;

import com.yiyue.lesson.interpretor.MyInterpretor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Value("${open.url}")
    private String openurl;

    @Bean
    public MyInterpretor myInterpretor(){
        return new MyInterpretor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterpretor()).addPathPatterns("/api/**").excludePathPatterns(openurl);
    }
}
