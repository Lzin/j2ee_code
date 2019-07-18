package cn.lz.annotation.checkutils;

public class Calculator {
    @Check
    public void add(){
        int a=1/0;
        System.out.println("1+0="+(1+0));
    }
    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("1*0="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("1/0"+(1/0));
    }

    public void show(){
        System.out.println("no bug");
    }

}
