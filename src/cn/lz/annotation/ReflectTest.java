package cn.lz.annotation;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;
@Pro(className = "cn.lz.annotation.Demo1",methodName = "show")
public class ReflectTest {
    /**
     * 设计框架类
     * */

    public static void main(String[] args) throws Exception{
        //可以创建任意类的对象，执行任意方法
        /**
         * 前提:不能改变类的任何代码，可以创建任意类的对象，可以执行任意方法
         * */
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> mReflectTestClass=ReflectTest.class;
        //2.获取上面的注解对象
        //在内存中生成了一个该注解接口的子类实现对象
        Pro mGetPro=mReflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回
      //  System.out.println(mGetPro.className());
      //  System.out.println(mGetPro.methodName();

        String className=mGetPro.className();
        String methodName=mGetPro.methodName();
        //4.反射创建类
        Class cls=Class.forName(className);
        Object obj=cls.newInstance();
        Method mMethod=cls.getMethod(methodName);
        mMethod.invoke(obj);
    }
}
