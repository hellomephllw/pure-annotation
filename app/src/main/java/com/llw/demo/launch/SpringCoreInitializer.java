package com.llw.demo.launch;

import com.llw.demo.config.HibernateDataConfig;
import com.llw.demo.config.SpringMvcConfig;
import com.llw.demo.config.SwaggerConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @discription: 启动spring
 * @author: llw
 * @date: 2016-11-17
 */
public class SpringCoreInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /** 加载其他配置 */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
//                HibernateDataConfig.class
        };
    }

    /** 加载spring mvc配置 */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {SpringMvcConfig.class, SwaggerConfig.class};
    }

    /** 为DispatcherServlet拦截所有请求 */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
