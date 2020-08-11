package com.lucklcy.test;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;

public class TestBase {


    @Test
    public void testShortToInt() {
        short s1 = 1;
//        s1 = (short)(s1 + 1);
//        s1 ++;
        s1 += 1;
        System.out.println(s1);

    }

    @Test
    public void testDotClass() throws ClassNotFoundException {

//        TestClassType temp = new TestClassType();
//        Class<? extends TestClassType> testTypeGetClass = temp.getClass();
//        System.out.println("testTypeGetClass---" + testTypeGetClass.getClass());

        Class<TestClassType> testTypeClass = TestClassType.class;
        System.out.println("testTypeClass---" + testTypeClass);
//
//        Class testTypeForName = Class.forName("com.lucklcy.test.TestClassType");
//        System.out.println("testTypeForName---" + testTypeForName);


//        System.out.println("testTypeClass ==> '.class':" + testTypeClass);
//        System.out.println("testTypeGetClass ==> 'getClass':" + testTypeGetClass);
//        System.out.println("testTypeForName ==> Class.forName:" + testTypeForName);
//        System.out.println("testTypeClass == testTypeGetClass ==> " + (testTypeClass == testTypeGetClass));
//        System.out.println("testTypeGetClass == testTypeForName ==> " + (testTypeGetClass == testTypeForName));
//        System.out.println("");
//        System.out.println("getName:" + testTypeGetClass.getName());
//        System.out.println("getCanonicalName:" + testTypeGetClass.getCanonicalName());
//        System.out.println("getSuperclass:" + testTypeGetClass.getSuperclass());
    }

    @Test
    public void testReflect() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> c = TestClassType.class;
        Object object = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        //获取methodClass类的add方法
        Method method = c.getMethod("add", int.class, int.class);
        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        for(Method m:methods)
            System.out.println(m);
        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declaredMethods)
            System.out.println(m);
    }

    @Test
    public void testObjectSerialize() throws IOException, ClassNotFoundException {
        TestClassType a1 = new TestClassType(123, "abc");
        String objectFile = "./file/objSerial";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        TestClassType a2 = (TestClassType) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }

    public void testCollection(){
        Integer[] arr = {1,2,3};
    }
}
