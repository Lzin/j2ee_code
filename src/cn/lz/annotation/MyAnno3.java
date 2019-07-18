package cn.lz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试四种元注解
 @Target 描述注解可以作用的位置
 @Retention 描述注解被保留的阶段
 @Documented 描述注解是否被抽取到api文档
 @Inherited 描述注解能否被子类继承
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno3 {
}
