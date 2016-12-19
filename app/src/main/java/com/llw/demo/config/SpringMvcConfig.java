package com.llw.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @discription: SpringMVC配置
 * @author: llw
 * @date: 2016-11-17
 */
//为spring解释，该文件为配置文件
@Configuration
//激活spring mvc的注解行为
@EnableWebMvc
//扫描指定的beans
@ComponentScan(basePackages = {"com.llw.demo.web.controller"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 静态目录
     *  - 该目录存放图片、css、js等静态文件
     *  - 不需要经过controller，可供直接访问
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/WEB-INF/assets/");
        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("/WEB-INF/swagger2/");
    }

    /**
     * 视图解析器
     *  - 为方便controller做视图跳转，只需要写jsp文件名称
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        return bean;
    }

    /**
     * 处理响应字符串中文乱码
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        //媒体类型
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        //处理Content-Type响应头
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        //去掉Accept-Charset响应头
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        messageConverters.add(stringHttpMessageConverter);

        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(messageConverters);

        return requestMappingHandlerAdapter;
    }

    /** 添加拦截器 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

}
