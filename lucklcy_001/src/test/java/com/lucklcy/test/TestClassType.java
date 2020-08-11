package com.lucklcy.test;

import java.io.Serializable;

public class TestClassType implements Serializable {
    public final int fuck = 3;

    private int age;
    private String name;

    public  TestClassType(int age,String name){
        this.age = age;
        this.name =name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 构造函数
    public TestClassType() {
        System.out.println("----构造函数---");
    }

    public int add(int a,int b) {
        return a+b;
    }
    public int sub(int a,int b) {
        return a+b;
    }

    // 静态的参数初始化
    static {
        System.out.println("---静态的参数初始化---");
    }

    // 非静态的参数初始化
    {
        System.out.println("----非静态的参数初始化---");
    }

    @Override
    public String toString() {
        return "TestClassType{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
