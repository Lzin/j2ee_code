package com.lz.reflect_test.reflect;

import com.lz.reflect_test.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4_getMethod {

    /**
     * 1.获取成员变量们
     * *Field[] getFields()
     * *Field[]   getField(String name)
     * <p>
     * *Field[] getDeclaredFields()
     * *Field[] getDeclaredField(String name)
     * 2.获取构造方法们
     * *Constructor<?>getConstructors()
     * *Constructor<T>getConstructor(类<?>...parameterTypes)
     * <p>
     * *Constructor<?>getDeclaredConstructors()
     * *Constructor<?>getDeclaredConstructor(类<?>...parameterTypes)
     * 3.获取成员方法们
     * *Method[] getMethods()
     * *Method[] getMethod(String name,类<?>...parameterTypes)
     * <p>
     * *Method[] getDeclaredMethods()
     * *Method[] getgetDeclaredMethod(String name,类<?>...parameterTypes)
     * 4.获取类名
     * *String getName()
     */
    public static void main(String[] args) {
        //0.获取Person的class对象
        // * 3.获取成员方法们
        //     * *Method[] getMethods()
        //     * *Method[] getMethod(String name,类<?>...parameterTypes)
        Class<Person> mReflectPerson = Person.class;
        Person mPerson = new Person();
        try {
            /**
             * getMethod:方法名 参数列表
             * */
            Method eat_method = mReflectPerson.getMethod("eat");
            //进行参数的执行
            eat_method.invoke(mPerson);
            Method[] methods = mReflectPerson.getMethods();
            for (Method method : methods) {
                System.out.println(method);
                //获取方法名称
                System.out.println(method.getName());
            }
            String className = mReflectPerson.getName();
            System.out.println("类名为:"+className);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

