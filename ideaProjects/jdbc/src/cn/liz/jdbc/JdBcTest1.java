package cn.liz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdBcTest1 {
    /**
     * 1.导入驱动jar包
     * 2.注册驱动
     * 3.获取数据库的连接对象 Connection(本地和数据库之间的桥梁)
     * 4.定义sql
     * 5.获取执行sql语句的对象Statement
     * 6.执行sql，接收返回结果
     * 7.处理结果
     * 8.释放资源
     */
    static String mUri = "jdbc:mysql://localhost:3306/db1" +
            "?useUnicode=true" +
            "&characterEncoding=UTF-8" +
            "&useSSL=false&serverTimezone=Asia/Shanghai" +
            "&zeroDateTimeBehavior=CONVERT_TO_NULL";
    static String mUser = "root";
    static String mPwd = "123456";

    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库的链接对象
        Connection mConn = DriverManager.getConnection(mUri, mUser, mPwd);
        //定义sql
        String mSqlCode = "update account set balance=1400 where id=2";
        //创建执行对象
        Statement mStm = mConn.createStatement();
        //处理结果
        //执行DML
        int result = mStm.executeUpdate(mSqlCode);
        System.out.println(result);
        //释放资源
        mStm.close();
        mConn.close();
    }
}
