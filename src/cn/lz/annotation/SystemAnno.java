package cn.lz.annotation;

@SuppressWarnings("all")//压制所有的警告
public class SystemAnno {
    /**
     * 1.@Override:检测被该注解标注的方法是否是继承自父类（接口）的
     * <p>
     * 2.@Deprecated:该注解标注的内容，表示已过时
     * <p>
     * 3.@SuppressWarning:压制警告
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void showOldWay() {
        System.out.println("the way is old");
    }
    public void showNewWay() {
        System.out.println("the way is new");
    }

    public void demo(){
        showOldWay();
        showNewWay();
    }


}
