package com.Feng;

import javax.security.auth.login.AccountException;

public class UnsafeBank {
    public static void main(String[] args) {
        //创建账户对象（只创建一个）
        Account act = new Account("act-001", 10000);
        Account act2 = new Account("act-002",10000);
        //创建线程进行取款
        AccountThread t1 = new AccountThread(act);
        AccountThread t2 = new AccountThread(act);
        AccountThread t3 = new AccountThread(act2);
        //设置name
        t1.setName("张三");
        t2.setName("李四");
        t3.setName("王五");
        //启动线程取款
        t1.start();
        t2.start();
        t3.start();
    }
}

class Account{
    //账号
    private String actno;
    //余额
    private double balance;

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withDraw(double money){
        synchronized (this){
            //取款前余额
            double before = this.getBalance();
            //取款后余额
            double after = before - money;

            try {
                Thread.sleep(1000);//模拟延时放大问题发生性
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //更新余额
            this.setBalance(after);
        }
    }
}

class AccountThread extends Thread{

    private Account act = null;

    public AccountThread() {
    }

    public AccountThread(Account account) {
        this.act = account;
    }


    @Override
    public void run() {
        //假设取5000
        double money = 5000;
        //取款
        act.withDraw(money);
        System.out.println(Thread.currentThread().getName()+"对账户"+act.getActno()+"取款成功，余额" + act.getBalance());

    }
}