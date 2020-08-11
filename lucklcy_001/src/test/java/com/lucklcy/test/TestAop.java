package com.lucklcy.test;

import com.lucklcy.bean.Calculator;
import com.lucklcy.config.MyConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MyConfigOfAOP.class);
        Calculator bean = configApplicationContext.getBean(Calculator.class);
        bean.div(1,1);
    }
}
