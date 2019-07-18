package cn.liz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC的快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //导入相应的jar add as library
        //2.注册驱动(通过反射机制)
        /**
         * java5.0之后注册驱动可以省略
         * META_INF-->services-->java.sql.Driver 中帮注册
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库的连接对象
        /**
         * jdbc.driver=com.mysql.cj.jdbc.Driver
         * jdbc.url=jdbc:mysql://localhost:3306/sys_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL
         * jdbc.username=root
         * jdbc.password=root
         * */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1" +
                        "?useUnicode=true" +
                        "&characterEncoding=UTF-8" +
                        "&useSSL=false&serverTimezone=Asia/Shanghai" +
                        "&zeroDateTimeBehavior=CONVERT_TO_NULL",
                "root", "123456");
        //简写
//        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1" +
//                        "?useUnicode=true" +
//                        "&characterEncoding=UTF-8" +
//                        "&useSSL=false&serverTimezone=Asia/Shanghai" +
//                        "&zeroDateTimeBehavior=CONVERT_TO_NULL",
//                "root", "123456");
        //4.定义sql语句
        String sql = "UPDATE account SET balance=1000 WHERE id=1";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
