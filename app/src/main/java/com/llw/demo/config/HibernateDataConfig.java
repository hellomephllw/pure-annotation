package com.llw.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @discription: 数据层配置
 * @author: llw
 * @date: 2016-11-17
 */
@Configuration
//开启事务注解行为
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.llw.demo.service.impl",
        "com.llw.demo.dao.impl"})
//为该配置文件读取properties文件的信息
@PropertySource("classpath:/jdbc.properties")
public class HibernateDataConfig {

    /** 读取的properties文件信息会被注入到env */
    @Autowired
    private Environment env;

    /** 数据源配置 */
    @Bean
    public DataSource dataSource() throws Exception {
        //c3p0
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //jdbc
        dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        //connections pool
        // TODO: 2016/11/17

        return dataSource;
    }

    /** 注册session工厂 */
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws Exception {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        //为session工厂提供数据源
        sessionFactory.setDataSource(dataSource());
        //为session工厂提供hibernate配置信息
        sessionFactory.setHibernateProperties(propertiesFactoryBean().getObject());
        //为session工厂提供hbm，这里为注解
        sessionFactory.setPackagesToScan("com.llw.demo.model");

        return sessionFactory;
    }

    /** hibernate配置信息 */
    @Bean
    public PropertiesFactoryBean propertiesFactoryBean() throws Exception {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        //读取hibernate配置文件
        propertiesFactoryBean.setLocation(new ClassPathResource("/hibernate.properties"));
        //把配置文件信息生成properties对象
        propertiesFactoryBean.afterPropertiesSet();

        return propertiesFactoryBean;
    }

    /** 事务管理器 */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        //为事务管理器提供对session工厂的引用
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

}
