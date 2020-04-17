package com.biosh.owner.daily_log;

/**
 * @author konglingbiao
 * @description
 * @date 2020/3/31
 */
public class TestClass  {

    static class InnerClass1 implements Runnable{
        @Override
        public void run() {
            new ThreadParable().methodA();
        }
    }

    static class InnerClass2 implements Runnable{
        @Override
        public void run() {
            new ThreadParable().methodB();
        }
    }

    static class InnerClass3 implements Runnable{
        @Override
        public void run() {
            new ThreadParable().methodC();
        }
    }





    public static void main(String[] args) {
        new Thread(new InnerClass2()).start();
        new Thread(new InnerClass1()).start();
        new Thread(new InnerClass3()).start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
