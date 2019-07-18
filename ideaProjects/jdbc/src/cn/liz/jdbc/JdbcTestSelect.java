package cn.liz.jdbc;

import cn.liz.domain.Emp;
import cn.liz.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTestSelect {
    static String mUri = "jdbc:mysql://localhost:3306/db2" +
            "?useUnicode=true" +
            "&characterEncoding=UTF-8" +
            "&useSSL=false&serverTimezone=Asia/Shanghai" +
            "&zeroDateTimeBehavior=CONVERT_TO_NULL";
    static String mUserId = "root";
    static String mPwd = "123456";

    //查询所有Emp对象
    //演示JdbcUtils
    public static List<Emp> findAll() {
        Statement mStmt = null;
        Connection mConn = null;
        ResultSet mRs = null;
        String sql_query = "select*from emp";
        //1.注册驱动
        try {
            //注册
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //获取连接
//            mConn = DriverManager.getConnection(mUri, mUserId, mPwd);
            mConn=JDBCUtils.getConnection();
            //获取执行对象
            mStmt = mConn.createStatement();
            //执行sql
            mRs = mStmt.executeQuery(sql_query);
            //遍历结果集 封装对象 装载集合
            Emp empElem = null;
            List<Emp> mEmpList = new ArrayList<Emp>();
            while (mRs.next()) {
                //获取数据
                int id = mRs.getInt("id");
                String name = mRs.getString("name");
                String gender = mRs.getString("gender");
                Double salary = mRs.getDouble("salary");
                Date join_date = mRs.getDate("join_date");
                int dept_id = mRs.getInt("dept_id");
                //创建emp对象
                empElem = new Emp();
                //开始设置映射
                empElem.setId(id);
                empElem.setName(name);
                empElem.setGendar(gender);
                empElem.setDept_id(dept_id);
                empElem.setSalary(salary);
                empElem.setJoin_date(join_date);
                //转载集合
                mEmpList.add(empElem);
            }
            return mEmpList;
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            if (mRs != null) {
////                try {
////                    mRs.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
////            if (mStmt != null) {
////                try {
////                    mStmt.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
////            if (mConn != null) {
////                try {
////                    mConn.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
            JDBCUtils.close(mRs,mStmt,mConn);
        }

        return null;
    }


    public static void main(String[] args) {
        List<Emp> mTestEmp = findAll();
        System.out.println(mTestEmp);
    }
}
