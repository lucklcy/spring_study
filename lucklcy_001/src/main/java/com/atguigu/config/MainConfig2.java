package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.*;
import org.springframework.context.annotation.*;

@Configuration
@Conditional({MacOsCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    @Bean("person")
    public Person person() {
        return new Person("xiaoming", 18);
    }

    @Lazy
    @Scope("singleton")
    @Conditional({MacOsCondition.class})
    @Bean("steve")
    public Person person01() {
        return new Person("Steve Jobs", 70);
    }

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person02() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person03() {
        return new Person("Linus ", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
