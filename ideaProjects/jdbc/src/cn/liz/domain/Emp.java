package cn.liz.domain;

import java.util.Date;

/**
 * 实体类 用来封装emp表的javabean
 * <p>
 * 将表映射成为一个类 方便操作
 */
public class Emp {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private Date join_date;
    private int dept_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGendar() {
        return gender;
    }

    public void setGendar(String gendar) {
        this.gender = gendar;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gendar=" + gender +
                ", salary=" + salary +
                ", join_date=" + join_date +
                ", dept_id=" + dept_id +
                '}';
    }
}
