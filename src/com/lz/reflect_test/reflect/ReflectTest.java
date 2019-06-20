package com.lz.reflect_test.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    /**
     * 设计框架类
     * */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //可以创建任意类的对象，执行任意方法
        /**
         * 前提:不能改变类的任何代码，可以创建任意类的对象，可以执行任意方法
         * */
        //1.加载配置文件
        //1.1创建Properties对象
        Properties mPro=new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取配置文件的路径（通过类加载器获取字节流）
        ClassLoader classLoader=ReflectTest.class.getClassLoader();
        InputStream mInstream=classLoader.getResourceAsStream("com/lz/reflect_test/pro.properties");
        try {
            mPro.load(mInstream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.获取配置文件中获取的数据
        String className=mPro.getProperty("className");
        String methodName=mPro.getProperty("methodName");
        //3.加载该类进内存
       Class mCls= Class.forName(className);
       //4.创建对象
       Object obj=mCls.newInstance();
       //5.获取方法对象
        Method method=mCls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

    }
}
