package cn.lz.annotation.checkutils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 主方法执行后，会自动执行被检测的方法，（加了check注解的方法），判断方法是否有异常，记录到文件中
 * */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculator mCal=new Calculator();
        //2.获取字节码
        Class mCalClass=mCal.getClass();
        //3.获取所有方法
        Method[] methods = mCalClass.getMethods();
        //bug出现的次数
        int num=0;
            //记录文件
            BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            //4.方法上是否有注解
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(mCal);
                } catch (Exception e) {
                    //捕获异常，记录到文件中
                    num++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称是"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因是"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------");
                }
            }
        }
        bw.write("本次测试一共出现"+num+"次异常");
        bw.flush();
        bw.close();

    }

}
