package com.lz.reflect_test.reflect;

import com.lz.reflect_test.domain.Person;

import java.lang.reflect.Field;

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
public class ReflectDemo2_getField {
    public static void main(String[] args) {
        //0.获取Person的class对象
        Class<Person> mReflectPerson = Person.class;
        //1.获取成员变量
        Field[] fields = mReflectPerson.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------------------------------");
        try {
            Field mField1 = mReflectPerson.getField("sex");
            /**
             * 获得了成员变量 一般获取值和设置值
             * */
            Person mPerson = new Person();
            Object value = mField1.get(mPerson);
            System.out.println(value);
            mField1.set(mPerson, "female");
            Object value1 = mField1.get(mPerson);
            System.out.println(value1);
            //获取私有属性


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        learnReflection();
    }

    public static void learnReflection() {
        Class<Person> mTest = Person.class;
        try {
            Person mTestPerson = new Person();
            Field mTestField = mTest.getDeclaredField("name");
            //非法的访问异常 需要忽略访问权限修饰符的安全检查
            mTestField.setAccessible(true);//暴力反射
            Object testDemo = mTestField.get(mTestPerson);
            System.out.println(testDemo);
            mTestField.set(mTestPerson, "张三");
            Object testDemo1 = mTestField.get(mTestPerson);
            System.out.println(testDemo1);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
