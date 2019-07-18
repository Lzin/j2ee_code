package cn.liz.datasource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class JDBCUtil {
    //1.定义一个成员变量 DataSource
    private static DataSource ds = null;
    private static Connection mConn = null;

    //使用静态代码块进行配置文件的读取和数据库连接池的初始化
    static {
        //1.加载配置文件
        Properties mPro = new Properties();
        try {
            mPro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            ds = DruidDataSourceFactory.createDataSource(mPro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    //重载
    public static void close(ResultSet mRs, Statement stmt, Connection conn) {
        if (mRs != null) {
            try {
                mRs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (conn != null) {
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("已清空资源");
    }

    //获取连接池
    public static DataSource getDataSource() {
        return ds;
    }
}
