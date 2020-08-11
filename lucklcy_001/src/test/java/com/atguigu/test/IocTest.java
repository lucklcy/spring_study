package com.atguigu.test;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IocTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void importTest(){
        printBeans(applicationContext);

        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("colorBeanFactory的类型:"+colorFactoryBean.getClass());
    }

    private void printBeans( AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        // 获取操作系统类型
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String type : beanNamesForType) {
            System.out.println(type);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void test02() {
        Object person = applicationContext.getBean("person");
        Object person1 = applicationContext.getBean("person");
        System.out.println(person == person1);
    }


    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
