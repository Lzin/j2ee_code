package cn.liz.datasource.druid;

import cn.liz.datasource.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    private static PreparedStatement mPstm = null;
    private static Connection mConn = null;

    public static void main(String[] args) {
        /**
         * 完成添加操作
         * */
        try {
            //获取连接
            mConn = JDBCUtil.getConnection();
            //定义sql
            String sql = "insert into account values(null,?,?)";
            //获取连接对象设置参数
            mPstm = mConn.prepareStatement(sql);
            mPstm.setString(1, "wanger");
            mPstm.setInt(2, 8888);
            //使用sql
            mPstm.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //清除资源 连接回收
            JDBCUtil.close(mPstm,mConn);
        }
    }
}
