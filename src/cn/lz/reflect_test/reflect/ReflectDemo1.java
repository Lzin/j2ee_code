package cn.lz.reflect_test.reflect;

import cn.lz.reflect_test.domain.Person;

/**
 * 获取class的三种方式:
 * 1.Class.forName(“全类名”); 将字节码文件加载入内存，返回class
 * 2.类名.class:			通过类名.class获取
 * 3:对象.getclass			该方法在Object中
 */
public class ReflectDemo1 {
    public static void main(String[] args)  {
        mGetClass();
    }

    public static void mGetClass() {
        //1.Class.forName(“全类名”); 将字节码文件加载入内存，返回class
        Class cls1 = null;
        try {
            cls1 = Class.forName("cn.lz.reflect_test.domain.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cls1);
        //2.类名.class:			通过类名.class获取
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3:对象.getclass			该方法在Object中
        Person mPerson = new Person();
        Class cls3 = mPerson.getClass();
        System.out.println(cls3);
        //比较内存地址
        System.out.println("内存地址比较:");
        System.out.println(cls1 == cls2);//true
        System.out.println(cls3 == cls2);//true
    }
}
