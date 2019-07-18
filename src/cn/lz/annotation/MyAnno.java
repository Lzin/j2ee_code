package cn.lz.annotation;

public @interface MyAnno {
    /**
     * 注解中只允许
     * 属性的返回值类型
     * 基本数据类型
     *  String
     *  枚举
     *  注解
     *  以上类型的数组
     * */
    int value();
//    //枚举类型
    Person mPer();
//    //注解类型
    MyAnno2 anno2();
    String[]strs();

}
