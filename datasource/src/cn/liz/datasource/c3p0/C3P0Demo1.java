package cn.liz.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * c3p0的演示
 * */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象ds,使用默认的配置文件
        DataSource ds=new ComboPooledDataSource();
        //1.1获取数据库连接池对象，使用指定名称
       // DataSource ds=new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象mConn
        Connection mConn=ds.getConnection();
        //3.打印
        System.out.println(mConn);
        String sql="update account set balance=? where id=?";
        PreparedStatement mPspt=mConn.prepareStatement(sql);
        mPspt.setInt(1,1888);
        mPspt.setInt(2,2);
        mPspt.execute();
        mPspt.close();
        mConn.close();
    }
}
