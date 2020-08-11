package com.lucklcy.config;

import com.lucklcy.aop.LogAccess;
import com.lucklcy.bean.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MyConfigOfAOP {
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAccess logAccess(){
        return new LogAccess();
    }
}
