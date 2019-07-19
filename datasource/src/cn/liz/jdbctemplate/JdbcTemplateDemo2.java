package cn.liz.jdbctemplate;

import cn.liz.datasource.utils.JDBCUtil;
import cn.liz.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //Junit单元测试，可以让方法独立执行
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Test
    public void test_update() {
        //1.修改id=1的数据salary为10000
        //定义sql
        String sql = "update emp set salary=10000 where id=1";

        //执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    //添加一条新记录
    @Test
    public void test_insert() {
        //定义sql
        String sql_insert = "insert into emp(id,salary,dept_id) values(?,?,?)";
        //执行sql
        int count = template.update(sql_insert, 10, 2999, 1);
        System.out.println(count);
    }

    //删除一条记录
    @Test
    public void test_delete() {
        String sql_delete = "delete from emp where id=10";
        int count = template.update(sql_delete);
        System.out.println(count);
    }

    //执行查询语句

    /**
     * 查询id为1的记录，将其封装为一个map集合
     * 注意:该方法查询的结果集长度只能为1
     */
    @Test
    public void testQueryAsMap() {
        String sql_query1 = "select*from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql_query1, 1);
        System.out.println(map);

    }

    @Test
    public void testQueryForAll() {
        String sql_queryForAll = "select*from emp";
        List<Map<String, Object>> mapList = template.queryForList(sql_queryForAll);
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }

    @Test
    /**
     * 将查询的结果放在javabean对象中,然后再统一放置在emp中(自己实现接口)
     * */
    public void testQueryForJavaBean() {
        String sql_query = "select*from emp";
        //建立映射关系
        List<Emp> mList = template.query(sql_query, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet mRs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = mRs.getInt("id");
                String name = mRs.getString("name");
                String gender = mRs.getString("gender");
                int salary = mRs.getInt("salary");
                Date join_date = mRs.getDate("join_date");
                int dept_id = mRs.getInt("dept_id");
                //开始映射
                emp.setJoin_date(join_date);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);
                emp.setGender(gender);
                emp.setName(name);
                emp.setId(id);

                return emp;
            }
            //匿名内部类
        });
        for(Emp emp:mList){
            System.out.println(emp);
        }
    }

    @Test
    /**
     * !!!
     * 将查询的结果放在javabean对象中,然后再统一放置在emp中(使用提供好的接口)
     * */
    public void testQueryForJavaBeanAuto() {
        String sql_query = "select*from emp";
        //建立映射关系 但是不能设置null值
      List<Emp>mList=template.query(sql_query,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : mList) {
            System.out.println(emp);
        }
    }
    @Test
    /**
     * 查询总的记录数
     * */
    public void testQueryForCount(){
        String sql_ForNote="select count(id) from emp";
       Long totalNum=template.queryForObject(sql_ForNote,Long.class);
        System.out.println(totalNum);
    }
}
