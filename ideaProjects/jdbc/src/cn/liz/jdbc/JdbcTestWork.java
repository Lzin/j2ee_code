package cn.liz.jdbc;

import cn.liz.util.JDBCUtils;

import java.sql.*;

/**
 * 事务操作
 */
public class JdbcTestWork {
    //转账

    public static void main(String[] args) {
        Connection mConn = null;
        PreparedStatement mPstmt_drop = null;
        PreparedStatement mPstmt_add = null;
        try {
            //1.获取连接对象
            mConn = JDBCUtils.getConnection();
            //开启事务
            mConn.setAutoCommit(false);
            //2.定义sql,获取执行对象
            String sql_drop = "update account set balance=balance-? where id =?";
            String sql_add = "update account set balance=balance+ ? where id =?";
            mPstmt_drop = mConn.prepareStatement(sql_drop);
            mPstmt_add = mConn.prepareStatement(sql_add);
            //3.设置参数
            //张三-500
            mPstmt_drop.setDouble(1, 500);
            mPstmt_drop.setInt(2, 1);
            //set bug

            //李四+500
            mPstmt_add.setDouble(1, 500);
            mPstmt_add.setInt(2, 2);
            //4.执行参数
            mPstmt_add.executeUpdate();
            mPstmt_drop.executeUpdate();
            //事务的提交
            mConn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if(mConn!=null){
                    //如果一旦出现任何问题，回滚
                    mConn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtils.close(mPstmt_add, mConn);
            JDBCUtils.close(mPstmt_drop, null);
        }
    }
}
