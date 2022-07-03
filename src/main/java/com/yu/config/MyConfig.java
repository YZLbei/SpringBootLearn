package com.yu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/2 20:23
 * @Description: 扩展MVC
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//    
//    public static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyMVCConfig();
    } 

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
