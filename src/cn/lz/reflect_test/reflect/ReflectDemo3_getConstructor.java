package cn.lz.reflect_test.reflect;

import cn.lz.reflect_test.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3_getConstructor {

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
        Class<Person> mReflectPerson = Person.class;
        //1.获取构造方法
        //     * *Constructor<?>getConstructors()
        //     * *Constructor<T>getConstructor(类<?>...parameterTypes)
        try {
            Constructor mConstructor=mReflectPerson.getConstructor(String.class,int.class);
            System.out.println(mConstructor);
            //使用构造器来创建对象
           Object mPerson= mConstructor.newInstance("张三",23);
            System.out.println(mPerson);
            System.out.println("-------------------------");
            Object mNullPerson=mReflectPerson.getConstructor();
            System.out.println(mNullPerson);
            Object mNullPerson2=mReflectPerson.newInstance();
            System.out.println(mNullPerson2);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

