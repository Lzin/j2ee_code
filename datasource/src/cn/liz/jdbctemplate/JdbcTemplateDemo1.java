package cn.liz.jdbctemplate;

import cn.liz.datasource.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的入门学习
 * */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导人jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDataSource());
        //3.调用方法
        String sql="update account set balance=5000 where id=?";

        int account=template.update(sql,2);
        System.out.println(account);
    }
}
