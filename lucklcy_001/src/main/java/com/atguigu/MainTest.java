package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
