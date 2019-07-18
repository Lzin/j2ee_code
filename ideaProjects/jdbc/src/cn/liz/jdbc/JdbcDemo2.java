package cn.liz.jdbc;


import java.sql.*;

/**
 * account 表 添加一条记录 insert语句
 * account 表 修改表中的记录
 */
public class JdbcDemo2 {
    static String mUri = "jdbc:mysql://localhost:3306/db1" +
            "?useUnicode=true" +
            "&characterEncoding=UTF-8" +
            "&useSSL=false&serverTimezone=Asia/Shanghai" +
            "&zeroDateTimeBehavior=CONVERT_TO_NULL";
    static String mUser = "root";
    static String mPwd = "123456";

    public static void main(String[] args) {
        Statement mStmt = null;
        Connection mConn = null;
        ResultSet mRes=null;
        String sql_insert = "insert into account values(null,'wangwu',3000)";
        String sql_update = "update account set balance=2500 where id=3";
        String sql_delete = "delete from account where id=3";
        String sql_select="select*from account";
        //一般而言 表都会设计好 然后再去执行
        String sql_create = "create table stu_by_jdbc (id int, name varchar(20))";
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql

            //3.获取connection
            mConn = DriverManager.getConnection(mUri, mUser, mPwd);
            //获取执行sql的对象
            mStmt = mConn.createStatement();
            int state = mStmt.executeUpdate(sql_insert);//影响的行数
            //处理结果
            System.out.println(state);
            if (state > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
// Result基础操作
            mRes=mStmt.executeQuery(sql_select);
            //查询结果
            while(mRes.next()){
                int id=mRes.getInt(1);
                String name=mRes.getString("name");
                double balance=mRes.getDouble(3);
                System.out.println(id+"---"+name+"---"+balance);
            }
//            if(mRes.next()){
//                //判断是否有数据
//
//            }
//            if(mRes.next()){
//                //判断是否有数据
//                int id=mRes.getInt(1);
//                String name=mRes.getString("name");
//                double balance=mRes.getDouble(3);
//                System.out.println(id+"---"+name+"---"+balance);
//            }
//            if(mRes.next()){
//                //判断是否有数据
//                int id=mRes.getInt(1);
//                String name=mRes.getString("name");
//                double balance=mRes.getDouble(3);
//                System.out.println(id+"---"+name+"---"+balance);
//            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(mRes!=null){
                try {
                    mRes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (mStmt != null) {
                try {
                    mStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (mConn != null) {
                try {
                    mConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
