package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;

    static {
        try {
            // 实例化对象
            props = new Properties();
            // 获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化Properties失败");
        }
    }

    // 根据bean名称获取bean对象
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        return bean;
    }
}
