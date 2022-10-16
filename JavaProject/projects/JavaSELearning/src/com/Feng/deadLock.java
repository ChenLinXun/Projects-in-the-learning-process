package com.Feng;

public class deadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        ThreadLock1 l1 = new ThreadLock1(o1,o2);
        ThreadLock2 l2 = new ThreadLock2(o1,o2);

        l1.start();
        l2.start();

    }
}

class ThreadLock1 extends Thread{
     Object o1;
     Object o2;

    public ThreadLock1() {
    }

    public ThreadLock1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }

    }
}

class ThreadLock2 extends Thread{
    private Object o1;
    private Object o2;

    public ThreadLock2() {
    }

    public ThreadLock2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }

    }
}