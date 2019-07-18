package cn.lz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用注解来代替配置文件
 * 描述需要执行的类名和方法名
 * */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Pro {
    String className();
    String methodName();
}
/**
 如何理解:Pro mGetPro=mReflectTest.getAnnotation(Pro.class);
 public class mGetPro implements Pro{
     public String className(){
        return "cn.lz.annotation.demo1"
 }
     public String methodName(){
        return "show"
 }
 * */
