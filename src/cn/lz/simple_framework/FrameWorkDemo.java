package cn.lz.simple_framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用反射机制建立简单的框架
 */
@AnnoPro(className = "cn.lz.simple_framework.Student",methodName = "eat")
public class FrameWorkDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         1.获取配置文件
         */

//        //实例化Properties对象
//        Properties AnnoPro = new Properties();
//        //获取配置文件路径
//        ClassLoader mClassLoader = FrameWorkDemo.class.getClassLoader();
//        //以数据流的方式进行配置文件的读取
//        InputStream mResourceInstream = mClassLoader.getResourceAsStream("cn/lz/simple_framework/pro.properties");
//        AnnoPro.load(mResourceInstream);
        /**
         使用注解的方式进行配置文件
         */
        Class<FrameWorkDemo>mClass=FrameWorkDemo.class;
        //获取注解实例
        AnnoPro mPro=mClass.getAnnotation(AnnoPro.class);
        /**
         * 2.读取配置文件
         * */
        //Hash结构
        String className = mPro.className();
        String methodName = mPro.methodName();
        /**
         * 3.加载类进内存，创建对象*/
        Class mCls = Class.forName(className);
        //实例化对象
        Object mObj = mCls.newInstance();
        /**
         * 3.通过反射获取方法，调用方法
         * */
        Method mUseMethod = mCls.getMethod(methodName);
        mUseMethod.invoke(mObj);
        System.out.println("反射成功");
    }
}
