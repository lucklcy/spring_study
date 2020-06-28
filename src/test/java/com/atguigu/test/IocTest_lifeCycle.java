package com.atguigu.test;

import com.atguigu.config.MyConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest_lifeCycle {
    AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);

    @Test
    public void test01() {
        System.out.println("容器创建完成。。。。。");
        configApplicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
