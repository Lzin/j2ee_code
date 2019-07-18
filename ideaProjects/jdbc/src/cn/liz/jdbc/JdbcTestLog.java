package cn.liz.jdbc;

import cn.liz.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * *需求
 * 1.用户录入用户名密码
 * 2.判断用户是否登录成功
 * 3.如果成功就登录成功，如果失败就登录失败
 * */
public class JdbcTestLog {
    /**
     * 登录方法
     * */
    private Connection mConn=null;
    private Statement mStmt=null;
    private ResultSet mRs=null;
    private PreparedStatement mPstat;
    public boolean login(String userName,String password) {
        if (userName == null || password == null) {
            //连接数据库
            return false;
        }
        //连接数据库，判断是否登录成功
        //获取连接
        try {
            mConn=JDBCUtils.getConnection();
            mStmt=mConn.createStatement();
            //定义sql
            //select*from userNama=''and password='';
            String sql="select*from user where username='"+userName+"'and password='"+password+"'";
            System.out.println(sql);
            //获取执行对象
            mRs=mStmt.executeQuery(sql);
            //判断结果集有无数据即可
          return mRs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(mRs,mStmt,mConn);
        }
        return false;
    }
    public boolean newLogin(String userName,String password){
        if(userName==null||password==null){
            System.out.println("账号密码错误");
            return false;
        }
        //开始连接数据库
        try {
            //查询连接
            mConn=JDBCUtils.getConnection();
            //找到sql
            String sql="select*from user where username=? and password=?";
            //获取执行对象
             mPstat=mConn.prepareStatement(sql);
            //设置参数
            mPstat.setString(1,userName);
            mPstat.setString(2,password);
            //执行sql
            mRs=mPstat.executeQuery();
            return mRs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //测试登录逻辑
    public static void main(String[] args) {
        //1.键盘写入，接收用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String usrname=sc.nextLine();
        System.out.println();
        System.out.println("请输入密码:");
        String password=sc.nextLine();
        //2.调用方法+判断结果
        if(new JdbcTestLog().newLogin(usrname,password)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
