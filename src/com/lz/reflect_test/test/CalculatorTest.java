package com.lz.reflect_test.test;

import com.lz.reflect_test.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * 测试add方法
 * */
public class CalculatorTest {
    /**
     * 定义测试方法并且让其可以独立运行
     * */
    /**
     * 初始化方法
     * 用于资源的申请
     * */
    @Before
    public void init(){
        System.out.println("init is ready");
    }
    @Test
    public void testAdd(){
        /**
         * 1.创建对象
         * 2.调用方法
         * */
        Calculator c=new Calculator();
        int result=c.add(1,2);
        //System.out.println(result);
        //单元测试中一般不使用输出，使用断言
        /**
         * assertEquals(expected,actual) 期望是3 如果不同，断言失败
         * */
        Assert.assertEquals(3,result);
    }
    /**
     * 测试减法
     * */
    @Test
    public void testSub(){
        Calculator mCalc=new Calculator();
        int result=mCalc.sub(1,2);
        System.out.println("testSub is ready");
        Assert.assertEquals(-1,result);
    }
    /**
     * 释放资源
     * 在所有测试方法执行完后，会自动执行方法
     * */
    @After
    public void close(){
        System.out.println("close is ready");
    }
}
