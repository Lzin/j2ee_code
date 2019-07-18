package cn.liz.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC的工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String pwd;
    private static String driver;

    /**
     * 获取连接
     * @return 连接对象
     * @author Liz
     * 采用配置文件进行文件的读取，文件的读取只需要一次即可，使用静态代码块
     *
     */
    static {
        //读取资源文件，获取值

        try {
            //1.创建Properites集合类

            Properties mPro = new Properties();
            //2.加载文件
            //获取src路径下文件的方式-->ClassLoader
           ClassLoader mCls=JDBCUtils.class.getClassLoader();
           //以src为相对的根路径
            URL res=mCls.getResource("jdbc.properties");
            String path=res.getPath();
            System.out.println(path);
            mPro.load(new FileReader(path));
            //3.获取数据，赋值
            //mPro是k_v结构
            url = mPro.getProperty("url");
            user = mPro.getProperty("user");
            pwd = mPro.getProperty("pwd");
            driver = mPro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 释放资源 方法的重载
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
