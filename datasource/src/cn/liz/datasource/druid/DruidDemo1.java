package cn.liz.datasource.druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 * */
public class DruidDemo1 {
    public static void main(String[] args) {
        //1.导包
        //2.导入配置文件
        //3.加载配置文件
        Properties mPro=new Properties();
        InputStream mIs=DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            mPro.load(mIs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.获取数据库的连接池对象
        try {
            DataSource ds=DruidDataSourceFactory.createDataSource(mPro);
            //5.获取连接对象
            Connection mConn=ds.getConnection();
            System.out.println(mConn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
