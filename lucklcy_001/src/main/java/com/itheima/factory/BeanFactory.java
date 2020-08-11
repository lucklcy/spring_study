package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;
    private static Map<String,Object> beans ;

    static {
        try {
            // 实例化对象
            props = new Properties();
            // 获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                beans.put(key,Class.forName(beanPath).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化Properties失败");
        }
    }

    // 根据bean名称获取bean对象
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
