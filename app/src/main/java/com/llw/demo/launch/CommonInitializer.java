package com.llw.demo.launch;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @discription: 启动或配置非spring级别的程序
 * @author: llw
 * @date: 2016-11-17
 */
public class CommonInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        // TODO: 2016/11/17
    }
    
}
